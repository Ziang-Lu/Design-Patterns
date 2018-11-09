#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Customer module that actually uses Command Pattern.
"""

__author__ = 'Ziang Lu'

from restaurant import CleanCommand, Cleaner, Cook, Waiter


def main():
    restaurant_cook = Cook()  # Receiver
    restaurant_cleaner = Cleaner()  # Receiver
    restaurant_waiter = Waiter(restaurant_cook)  # Invoker

    # Request the waiter [Invoker] to place an order [Command]
    restaurant_waiter.place_order('Kung Pao Chicken', 'Sesame Chicken')

    print()

    # Create a clean command [Command] by passing the cleaner [Receiver]
    clean_command = CleanCommand(restaurant_cleaner)
    # Let the waiter [Invoker] to execute the clean command [Command]
    restaurant_waiter.clean(clean_command)


if __name__ == '__main__':
    main()

# Output:
# Waiter [Invoker] has received an order with items ('Kung Pao Chicken', 'Sesame Chicken')
# A new order [Command] has been created.
# Kung Pao Chicken has been added to the order.
# Sesame Chicken has been added to the order.
# Waiter [Invoker] starts executing the command...
# Cook [Receiver] is cooking Sesame Chicken.
# Cook [Receiver] is cooking Kung Pao Chicken.
#
# A new clean command [Command] has been created.
# Waiter [Invoker] has received the clean command [Command] and starts executing the command...
# Cleaner [Receiver] is cleaning up the table.
