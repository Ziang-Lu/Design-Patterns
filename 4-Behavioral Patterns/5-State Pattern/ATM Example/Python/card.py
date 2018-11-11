#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Card module.
"""

__author__ = 'Ziang Lu'


class Card(object):
    __slots__ = ['_pin', '_balance']

    def __init__(self, pin: int, balance: int):
        """
        Constructor with parameter.
        :param pin: int
        :param balance: int
        """
        if len(str(pin)) != 4:
            raise RuntimeError('The PIN should be exactly 4 digits.')
        self._pin = pin
        self._balance = balance

    def check_pin(self, provided_pin: int) -> bool:
        """
        Checks whether the entered PIN is correct.
        :param provided_pin: int
        :return: bool
        """
        return provided_pin == self._pin

    def check_balance(self) -> int:
        """
        Accessor of balance.
        :return: int
        """
        return self._balance

    def withdraw(self, amount: int) -> None:
        """
        Withdraws the given amount of cash.
        :param amount: int
        :return: None
        """
        # Assumption: amount <= balance
        self._balance -= amount

    def deposit(self, amount: int) -> None:
        """
        Deposits the given amount of cash.
        :param amount: int
        :return: None
        """
        self._balance += amount
