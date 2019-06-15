#!usr/bin/env python3
# -*- coding: utf-8 -*-

__author__ = 'Ziang Lu'

"""
Module for Facade Pattern models.
"""


class WelcomeScreen:
    """
    WelcomeScreen class as a sub-component of a bank account access.
    """
    __slots__ = []

    def __init__(self):
        print('Welcome to ABC bank!')
        print('We are glad to serve you.')


class AccountNumberManager:
    """
    AccountNumberManager class as a sub-component of a bank account access.
    """
    __slots__ = ['_account_number']

    def __init__(self):
        """
        Default constructor.
        """
        self._account_number = 12345678

    def correct_account_number(self, provided_account_number: int) -> bool:
        """
        Checks whether the provided account number is correct.
        :param provided_account_number: int
        :return: bool
        """
        if provided_account_number != self._account_number:
            print('Incorrect account number!')
            return False
        return True


class SecurityCodeManager:
    """
    SecurityCodeManager class as a sub-component of a bank account access.
    """

    __slots__ = ['_pin']

    def __init__(self):
        """
        Default constructor.
        """
        self._pin = 1234

    def correct_pin(self, provided_pin: int) -> bool:
        """
        Checks whether the provided PIN is correct.
        :param provided_pin: PIN provided by the client
        :return: whether the provided PIN is correct
        """
        if provided_pin != self._pin:
            print('Incorrect PIN!')
            return False
        return True


class BalanceManager:
    """
    BalanceManager class as a sub-component of a bank account access.
    """
    __slots__ = ['_balance']

    def __init__(self):
        """
        Default constructor.
        """
        self._balance = 1000.0

    def withdraw(self, amount: float) -> None:
        """
        Withdraws money from the bank account.
        :param amount: float
        :return: None
        """
        if self._has_enough_balance(amount):
            self._balance -= amount
            print(f'Withdrawal completed! Current balance: ${self._balance}')

    def _has_enough_balance(self, amount: float) -> bool:
        """
        Private helper method to check whether there is enough balance in the
        bank account comparing to the given amount.
        :param amount: float
        :return: bool
        """
        return amount <= self._balance

    def deposit(self, amount) -> None:
        """
        Deposits money to the bank account.
        :param amount: float
        :return: None
        """
        self._balance += amount
        print(f'Deposition completed! Current balance: ${self._balance}')


class BankAccountAccessFacade:
    """
    Facade class for bank account access that serves as a front-facing interface
    masking more complex sub-components to simplify the usage for client and
    minimize the dependencies between the client and the sub-components.
    """
    __slots__ = [
        '_welcome_screen', '_account_manager', '_pin_manager',
        '_balance_manager', '_account_number', '_pin'
    ]

    def __init__(self, account_number: int, pin: int):
        """
        Constructor with parameter.
        :param account_number: int
        :param pin: int
        """
        self._welcome_screen = WelcomeScreen()
        self._account_manager = AccountNumberManager()
        self._pin_manager = SecurityCodeManager()
        self._balance_manager = BalanceManager()
        self._account_number = account_number
        self._pin = pin

    def withdraw_cash(self, amount: float) -> None:
        """
        Withdraws money from the bank account.
        :param amount: int
        :return: None
        """
        if not self._correct_account_info():
            return

        self._balance_manager.withdraw(amount)
        print('Transaction completed!')

    def _correct_account_info(self) -> bool:
        """
        Private helper method to check the provided account number and PIN.
        :return: bool
        """
        return self._account_manager.correct_account_number(self._account_number) \
            and self._pin_manager.correct_pin(self._pin)

    def deposit_cash(self, amount: float) -> None:
        """
        Deposits money to the bank account.
        :param amount: float
        :return: None
        """
        if not self._correct_account_info():
            return
        self._balance_manager.deposit(amount)
        print('Transaction completed!')
