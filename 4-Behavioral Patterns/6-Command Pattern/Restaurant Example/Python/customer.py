#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Customer module that actually uses Command Pattern.
"""

__author__ = 'Ziang Lu'

from restaurant import Cleaner, Cook, Waiter


def main():
    restaurant_cook = Cook()  # Receiver
    restaurant_cleaner = Cleaner()  # Receiver
    restaurant_waiter = Waiter(restaurant_cook, restaurant_cleaner)  # Invoker

    # Request the waiter [Invoker] to place an order [Command]
    restaurant_waiter.place_order('Kung Pao Chicken', 'Sesame Chicken')

    print()

    # Request the waiter [Invoker] to clean the table [Command]
    restaurant_waiter.clean()


if __name__ == '__main__':
    main()

# Output:
# Waiter [Invoker] has received an order with items ('Kung Pao Chicken', 'Sesame Chicken')
# A new order [Command] has been created.
# Kung Pao Chicken has been added to the order.
# Sesame Chicken has been added to the order.
# Waiter [Invoker] started executing the command...
# Cook [Receiver] is cooking Sesame Chicken.
# Cook [Receiver] is cooking Kung Pao Chicken.
#
# Waiter [Invoker] has received the clean request.
# A new clean command [Command] has been created.
# Waiter [Invoker] started executing the clean command...
# Cleaner [Receiver] is cleaning up the table.
