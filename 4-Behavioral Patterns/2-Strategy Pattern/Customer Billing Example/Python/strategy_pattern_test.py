#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Application that actually uses Strategy Pattern to provide multiple algorithms,
a family of algorithms, to perform a specific task (solve a specific problem),
so that the client can select which actual implementation to use at runtime.
"""

__author__ = 'Ziang Lu'

from billing_strategy import (
    BillingStrategy, HappyHourBillingStrategy, NormalBillingStrategy
)


class Customer:
    """
    Customer class that works as an interface to the outside world: it wraps a
    billing strategy and the client will use that strategy to calculate the
    actual prices for drinks.
    """
    __slots__ = ['_curr_billing_strategy', '_rounds']

    def __init__(self, billing_strategy: BillingStrategy):
        """
        Constructor with parameter.
        :param billing_strategy: BillingStrategy
        """
        self._curr_billing_strategy = billing_strategy
        self._rounds = []

    def set_billing_strategy(self, billing_strategy: BillingStrategy) -> None:
        """
        Mutator of curr_billing_strategy.
        :param billing_strategy: BillingStrategy
        :return: None
        """
        self._curr_billing_strategy = billing_strategy

    def add_drink(self, price: float, n: int) -> None:
        """
        Adds the given number of the given drinks.
        :param price: float
        :param n: int
        :return: None
        """
        self._rounds.append(
            self._curr_billing_strategy.get_actual_price(price * n)
        )

    def print_bill(self) -> None:
        """
        Prints the total bill for this customer
        :return: None
        """
        total = sum(self._rounds)
        print(f'Total due: {total}')
        self._rounds.clear()


def main():
    # Prepare billing strategies
    normal_strategy = NormalBillingStrategy.get_instance()
    happy_hour_strategy = HappyHourBillingStrategy.get_instance()

    # Normal time slot
    first_customer = Customer(normal_strategy)
    first_customer.add_drink(price=1.0, n=1)

    # Happy Hour starts! [Switch billing strategy]
    first_customer.set_billing_strategy(happy_hour_strategy)
    first_customer.add_drink(price=1.0, n=2)

    second_customer = Customer(happy_hour_strategy)
    second_customer.add_drink(price=0.8, n=1)

    # First customer checks out
    first_customer.print_bill()

    # Happy Hour ends [Switch billing strategy]
    second_customer.set_billing_strategy(normal_strategy)
    second_customer.add_drink(price=1.3, n=1)
    second_customer.add_drink(price=2.5, n=1)

    # Second customer checks out
    second_customer.print_bill()


if __name__ == '__main__':
    main()

# Output:
# Total due: 2.0
# Total due: 5.5
