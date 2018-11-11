#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Vending machine module.
"""

__author__ = 'Ziang Lu'

from abc import ABC, abstractmethod


class VendingMachine(object):
    """
    Vending machine class that actually uses State Pattern.
    """
    __slots__ = ['_my_state', '_balance', '_selected_product']

    def __init__(self):
        self._my_state = NoMoneyState.get_instance()
        self._balance = 0
        self._selected_product = None

    @property
    def selected_product(self) -> str:
        """
        Accessor of selected_product.
        :return: str
        """
        return self._selected_product

    def set_state(self, state) -> None:
        """
        Mutator of my_state.
        :param state: VendingMachineState
        :return: None
        """
        self._my_state = state

    def set_balance(self, balance: int) -> None:
        """
        Mutator of balance.
        :param balance: int
        :return: None
        """
        self._balance = balance

    @selected_product.setter
    def selected_product(self, selected_product: str) -> None:
        """
        Mutator of selected_product.
        :param selected_product: str
        :return:
        """
        self._selected_product = selected_product

    def insert_money_and_select_product(self, amount: int, product: str):
        """
        Lets the user inserts some money and select a product.
        :param amount: int
        :param product: str
        :return: None
        """
        self._my_state.display_state()
        self._my_state.insert_money_and_select_product(self, amount, product)

    def dispense_product(self) -> None:
        """
        Dispenses the selected product, and returns balance if any.
        :return: None
        """
        self._my_state.display_state()
        self._my_state.dispense_product(self)


class VendingMachineState(ABC):
    """
    Abstract VendingMachineState class that defines the handlers for different
    requests for the vending machine.
    Different concrete states extending this class will provide different
    implementations to these handlers to achieve different behaviors of the
    vending machine based on its state.
    """
    __slots__ = []

    @abstractmethod
    def display_state(self) -> None:
        """
        Displays this state.
        :return: None
        """
        pass

    @abstractmethod
    def insert_money_and_select_product(self, vending_machine: VendingMachine,
                                        amount: int, product: str) -> None:
        """
        Lets the user inserts some money and select a product.
        :param vending_machine: VendingMachine
        :param amount: int
        :param product: str
        :return: None
        """
        pass

    @abstractmethod
    def dispense_product(self, vending_machine: VendingMachine) -> None:
        """
        Dispenses selected the product, and returns balance if any.
        :param vending_machine: VendingMachine
        :return: None
        """
        pass


class NoMoneyState(VendingMachineState):
    """
    Concrete NoMoneyState that corresponds to the state of the vending machine
    that no money has been inserted and no product has been selected yet.
    This class is implemented as a singleton class.
    """
    _STATE_NAME = 'No Product Selected & No Money Inserted'

    @classmethod
    def get_instance(cls):
        """
        Gets the singleton instance.
        :return: NoMoneyState
        """
        return cls.__new__(cls)

    def __new__(cls, *args, **kwargs):
        if not hasattr(cls, '_instance'):
            cls._instance = super().__new__(cls)
        return cls._instance

    def display_state(self):
        print('Current state: No Product Selected & No Money Inserted')

    def insert_money_and_select_product(self, vending_machine, amount, product):
        vending_machine.set_balance(amount)
        vending_machine.selected_product = product
        print(f'${amount} has been inserted and {product} has been selected...')

        # Change state to HasMoneyState
        vending_machine.set_state(HasMoneyState.get_instance())

    def dispense_product(self, vending_machine):
        print('Vending machine cannot dispense product because no money is '
              'inserted and no product is selected.')


class HasMoneyState(VendingMachineState):
    """
    Concrete HasMoneyState that corresponds to the state of the vending machine
    that some money has been inserted and a product has been selected.
    This class is implemented as a singleton class.
    """
    _STATE_NAME = 'Product Selected & Money Inserted'

    @classmethod
    def get_instance(cls):
        """
        Gets the singleton instance.
        :return: NoMoneyState
        """
        return cls.__new__(cls)

    def __new__(cls, *args, **kwargs):
        if not hasattr(cls, '_instance'):
            cls._instance = super().__new__(cls)
        return cls._instance

    def display_state(self):
        print('Current state: Product Selected & Money Inserted')

    def insert_money_and_select_product(self, vending_machine, amount, product):
        print('Money already inserted and product already selected.')
        print('Please wait till it finishes the current dispensing process.')

    def dispense_product(self, vending_machine):
        print(f'Vending machine dispensing product '
              f'{vending_machine.selected_product}')
        vending_machine.set_balance(0)
        vending_machine.selected_product = None

        # Change state to NoMoneyState
        vending_machine.set_state(NoMoneyState.get_instance())
