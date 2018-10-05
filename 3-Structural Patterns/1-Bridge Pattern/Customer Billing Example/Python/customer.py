#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Customer module.
"""

__author__ = 'Ziang Lu'

from abc import ABC

from billing_implementor import BillingImplementor


class Customer(ABC):
    """
    Abstract Shape class that works as "Abstraction".
    This class defines an add_drinks() method for the client to call, and holds
    a reference to a billing implementor, so that the client will use that
    implementor to calculate the actual price for drinks.
    """
    __slots__ = ['_curr_billing_implementor', '_rounds']

    def __init__(self, billing_implementor: BillingImplementor):
        """
        Constructor with parameter.
        :param billing_implementor: BillingImplementor
        """
        self._curr_billing_implementor = billing_implementor
        self._rounds = []

    def set_billing_implementor(
        self, billing_implementor: BillingImplementor
    ) -> None:
        """
        Mutator of billing_implementor.
        :param billing_implementor: BillingImplementor
        :return: None
        """
        self._curr_billing_implementor = billing_implementor

    def add_drinks(self, price: float, n: int) -> None:
        """
        Adds the given number of the given drinks.
        :param price: float
        :param n: int
        :return: None
        """
        self._rounds.append(
            self._curr_billing_implementor.get_actual_price(price * n)
        )

    def print_bill(self) -> None:
        """
        Prints the total bill for this customer.
        :return: None
        """
        total = sum(self._rounds)
        print(f'Total due: {total}')
        self._rounds.clear()


class NormalCustomer(Customer):
    """
    Concrete NormalCustomer class that works as "ConcreteImplementor".
    """
    __slots__ = []

    def __init__(self, billing_implementor: BillingImplementor):
        """
        Constructor with parameter.
        :param billing_implementor: BillingImplementor
        """
        super().__init__(billing_implementor)
        self._rounds = []


class TeenagerCustomer(Customer):
    """
    Concrete TeenagerCustomer class that works as "ConcreteImplementor".
    """
    __slots__ = []

    def __init__(self, billing_implementor: BillingImplementor):
        """
        Constructor with parameter.
        :param billing_implementor: BillingImplementor
        """
        super().__init__(billing_implementor)
        self._rounds = []

    def add_drinks(self, price, n):
        if len(self._rounds) < 3:
            super().add_drinks(price, n)
