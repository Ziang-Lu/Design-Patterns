#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Application module.
"""

__author__ = 'Ziang Lu'

from vending_machine import VendingMachine


def main():
    vending_machine = VendingMachine()

    vending_machine.dispense_product()
    print()

    vending_machine.insert_money_and_select_product(3, 'Pepsi')
    print()

    vending_machine.insert_money_and_select_product(3, 'Fanta')
    print()
    vending_machine.dispense_product()


if __name__ == '__main__':
    main()

# Output:
# Current state: No Product Selected & No Money Inserted
# Vending machine cannot dispense product because no money is inserted and no product is selected.
#
# Current state: No Product Selected & No Money Inserted
# $3 has been inserted and Pepsi has been selected...
#
# Current state: Product Selected & Money Inserted
# Money already inserted and product already selected.
# Please wait till it finishes the current dispensing process.
#
# Current state: Product Selected & Money Inserted
# Vending machine dispensing product Pepsi
