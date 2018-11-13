#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Application that actually uses Bridge Pattern.
"""

__author__ = 'Ziang Lu'

from billing_implementor import (
    HappyHourBillingImplementor, NormalBillingImplementor
)
from customer import NormalCustomer, TeenagerCustomer


def main():
    # Prepare the billing implementors
    normal_implementor = NormalBillingImplementor.get_instance()
    happy_hour_implementor = HappyHourBillingImplementor.get_instance()

    # Normal time slot
    first_customer = NormalCustomer(normal_implementor)
    first_customer.add_drinks(price=1.0, n=1)

    # Happy Hour starts! [Switch billing implementor]
    first_customer.set_billing_implementor(happy_hour_implementor)
    first_customer.add_drinks(price=1.0, n=2)

    second_customer = TeenagerCustomer(happy_hour_implementor)
    second_customer.add_drinks(price=0.8, n=1)

    # First customer checks out
    first_customer.print_bill()

    # Happy Hour ends [Switch billing implementor]
    second_customer.set_billing_implementor(normal_implementor)
    second_customer.add_drinks(price=1.3, n=2)
    second_customer.add_drinks(price=2.5, n=1)

    # Second customer checks out
    second_customer.print_bill()


if __name__ == '__main__':
    main()

# Output:
# Total due: 2.0
# Total due: 5.5
