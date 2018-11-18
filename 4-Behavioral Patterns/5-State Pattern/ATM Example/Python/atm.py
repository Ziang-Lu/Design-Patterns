#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
ATM machine module.
"""

__author__ = 'Ziang Lu'

from abc import ABC, abstractmethod

from card import Card


class AtmState(ABC):
    """
    Abstract AtmState class that defines all the handlers for different requests
    for the ATM machine.
    Different concrete states extending this class will provide different
    implementations to these handlers to achieve different behaviors of the ATM
    based on its state.
    """
    __slots__ = []

    @abstractmethod
    def insert_card(self, atm, card: Card) -> None:
        """
        Inserts a card.
        :param atm: AtmMachine
        :param card: Card
        :return: None
        """
        pass

    @abstractmethod
    def enter_pin(self, atm, pin_entered: int) -> None:
        """
        Enters the PIN.
        :param atm: AtmMachine
        :param pin_entered: int
        :return: None
        """
        pass

    @abstractmethod
    def check_balance(self, atm) -> None:
        """
        Checks the balance for the inserted card.
        :param atm: AtmMachine
        :return: None
        """
        pass

    @abstractmethod
    def request_cash(self, atm, amount: int) -> None:
        """
        Requests cash from the given ATM.
        :param atm: AtmMachine
        :param amount: int
        :return: None
        """
        pass

    @abstractmethod
    def deposit_cash(self, atm, amount: int) -> None:
        """
        Deposits cash.
        :param atm: AtmMachine
        :param amount: int
        :return: None
        """
        pass

    @abstractmethod
    def eject_card(self, atm) -> None:
        """
        Ejects the card.
        :param atm: AtmMachine
        :return: None
        """
        pass


class NoCardState(AtmState):
    """
    Concrete NoCardState that corresponds to the state of the ATM that no card
    has been inserted yet.
    This class is implemented as a singleton class.
    """

    @classmethod
    def get_instance(cls):
        """
        Gets the singleton instance.
        :return: NoCardState
        """
        return cls.__new__(cls)

    def __new__(cls, *args, **kwargs):
        if not hasattr(cls, '_instance'):
            cls._instance = super().__new__(cls)
        return cls._instance

    def insert_card(self, atm, card: Card) -> None:
        atm.inserted_card = card

        # Change state to HasCardState
        atm.set_state(AtmMachine.HAS_CARD_STATE)

    def enter_pin(self, atm, pin_entered: int) -> None:
        print('Please insert the card first')

    def check_balance(self, atm) -> None:
        print('Please insert the card first')

    def request_cash(self, atm, amount: int) -> None:
        print('Please insert the card first')

    def deposit_cash(self, atm, amount: int) -> None:
        print('Please insert the card first')

    def eject_card(self, atm) -> None:
        print('Please insert the card first')


class HasCardState(AtmState):
    """
    Concrete HasCardState that corresponds to the state of the ATM that a card
    has been inserted.
    This class is implemented as a singleton class.
    """

    @classmethod
    def get_instance(cls):
        """
        Gets the singleton instance.
        :return: HasCardState
        """
        return cls.__new__(cls)

    def __new__(cls, *args, **kwargs):
        if not hasattr(cls, '_instance'):
            cls._instance = super().__new__(cls)
        return cls._instance

    def insert_card(self, atm, card):
        print('There is already a card inserted in this ATM')

    def enter_pin(self, atm, pin_entered):
        correct_pin = atm.inserted_card.check_pin(pin_entered)
        if not correct_pin:
            print('Incorrect PIN!')
            return

        # Change to HasCorrectPinState
        atm.set_state(AtmMachine.HAS_CORRECT_PIN_STATE)

    def check_balance(self, atm):
        print('Please first correctly enter the PIN')

    def request_cash(self, atm, amount):
        print('Please first correctly enter the PIN')

    def deposit_cash(self, atm, amount):
        print('Please first correctly enter the PIN')

    def eject_card(self, atm):
        atm.inserted_card = None
        print('Thanks for using.')

        # Change to NoCardState
        atm.set_state(AtmMachine.NO_CARD_STATE)


class HasCorrectPinState(AtmState):
    """
    Concrete HasCorrectPinState that corresponds to the state of the ATM that a
    card has been inserted and the correct PIN is provided
    This class is implemented as a singleton class.
    """

    @classmethod
    def get_instance(cls):
        """
        Gets the singleton instance.
        :return: HasCorrectPinState
        """
        return cls.__new__(cls)

    def __new__(cls, *args, **kwargs):
        if not hasattr(cls, '_instance'):
            cls._instance = super().__new__(cls)
        return cls._instance

    def insert_card(self, atm, card):
        print('There is already a card inserted in this ATM')

    def enter_pin(self, atm, pin_entered):
        print('No need to re-enter the PIN')

    def check_balance(self, atm):
        print(f'Current balance: ${atm.inserted_card.check_balance()}')

    def request_cash(self, atm, amount):
        inserted_card = atm.inserted_card
        if inserted_card.check_balance() < amount:
            print('No enough balance in the card!')
            return

        curr_cash = atm.cash
        if curr_cash == 0:
            print('There is no cash in this ATM')
        elif curr_cash < amount:
            inserted_card.withdraw(curr_cash)
            atm.cash = 0
            print(f'No enough cash! Can only withdraw ${curr_cash}')
        else:
            inserted_card.withdraw(amount)
            atm.cash = curr_cash - amount
            print(f'Successfully withdrew ${amount}')

    def deposit_cash(self, atm, amount):
        atm.inserted_card.deposit(amount)
        atm.cash += amount
        print(f'Successfully deposited ${amount}')

    def eject_card(self, atm):
        atm.inserted_card = None
        print('Thanks for using.')

        # Change to NoCardState
        atm.set_state(AtmMachine.NO_CARD_STATE)


class AtmMachine:
    """
    ATM machine class that actually uses State Pattern.
    """
    __slots__ = ['_my_state', '_cash', '_inserted_card']

    NO_CARD_STATE = NoCardState.get_instance()
    HAS_CARD_STATE = HasCardState.get_instance()
    HAS_CORRECT_PIN_STATE = HasCorrectPinState.get_instance()

    def __init__(self):
        """
        Default constructor.
        """
        self._my_state = self.NO_CARD_STATE
        self._cash = 2000
        self._inserted_card = None

    @property
    def cash(self) -> int:
        """
        Accessor of cash.
        :return: int
        """
        return self._cash

    @property
    def inserted_card(self) -> Card:
        """
        Accessor of inserted_card.
        :return: Card
        """
        return self._inserted_card

    def set_state(self, state: AtmState) -> None:
        """
        Mutator of my_state.
        :param state: AtmState
        :return: None
        """
        self._my_state = state

    @cash.setter
    def cash(self, cash: int) -> None:
        """
        Mutator of cash.
        :param cash: int
        :return: None
        """
        self._cash = cash

    @inserted_card.setter
    def inserted_card(self, card: Card) -> None:
        """
        Mutator of inserted_card.
        :param card: Card
        :return: None
        """
        self._inserted_card = card

    def insert_card(self, card: Card) -> None:
        """
        Inserts a card.
        :param card: Card
        :return: None
        """
        self._my_state.insert_card(self, card)

    def enter_pin(self, pin_entered: int) -> None:
        """
        Enters the PIN.
        :param pin_entered: int
        :return: None
        """
        self._my_state.enter_pin(self, pin_entered)

    def check_balance(self) -> None:
        """
        Checks the balance in the inserted card.
        :return: None
        """
        self._my_state.check_balance(self)

    def request_cash(self, amount: int) -> None:
        """
        Requests cash from this ATM.
        :param amount:
        :return:
        """
        self._my_state.request_cash(self, amount)

    def deposit_cash(self, amount: int) -> None:
        """
        Deposits cash.
        :param amount: int
        :return: None
        """
        self._my_state.deposit_cash(self, amount)

    def eject_card(self) -> None:
        """
        Ejects the card.
        :return: None
        """
        self._my_state.eject_card(self)
