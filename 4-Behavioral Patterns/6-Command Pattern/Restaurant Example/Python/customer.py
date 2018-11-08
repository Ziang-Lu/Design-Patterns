#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Customer module that actually uses Command Pattern.
"""

__author__ = 'Ziang Lu'

from restaurant import CleanCommand, Cleaner, Cook, Order, Waiter


def main():
    restaurant_cook = Cook()  # Receiver
    restaurant_cleaner = Cleaner()  # Receiver
    restaurant_waiter = Waiter()  # Invoker

    # Create a order [Command] by passing in the cook [Receiver]
    order = Order(cook=restaurant_cook)
    order.add_item('Kung Pao Chicken')
    order.add_item('Sesame Chicken')
    print()
    # Let the waiter [Invoker] execute this command
    restaurant_waiter.execute_command(command=order)

    print()

    # Create a clean command [Command] by passing in the cleaner [Receiver]
    clean_command = CleanCommand(cleaner=restaurant_cleaner)
    print()
    # Let the waiter [Invoker] execute this command
    restaurant_waiter.execute_command(command=clean_command)


if __name__ == '__main__':
    main()

# Output:
# A new order [Command] has been created.
# Kung Pao Chicken has been added to the order.
# Sesame Chicken has been added to the order.
#
# Waiter [Invoker] has received the command [Command] and start executing the command [Command] ...
# Cook [Receiver] is cooking Sesame Chicken.
# Cook [Receiver] is cooking Kung Pao Chicken.
#
# A new clean command [Command] has been created.
#
# Waiter [Invoker] has received the command [Command] and start executing the command [Command] ...
# Cleaner [Receiver] is cleaning up the table.
