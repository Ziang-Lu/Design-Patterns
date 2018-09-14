#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Application that actually uses Facade Pattern.
Note that by using Facade Pattern, the application now doesn't necessarily need
to know the complex logic and implementation details in sub-components, but only
need to interact with the Facade.
"""

__author__ = 'Ziang Lu'

from bank_account_access import BankAccountAccessFacade


def main():
    bank_account_access = BankAccountAccessFacade(12345678, 1234)

    print()
    bank_account_access.withdraw_cash(50)
    print()
    bank_account_access.withdraw_cash(900)
    print()
    bank_account_access.deposit_cash(200)


if __name__ == '__main__':
    main()

# Output:
# Welcome to ABC bank!
# We are glad to serve you.
#
# Withdrawal completed! Current balance: $950.0
# Transaction completed!
#
# Withdrawal completed! Current balance: $50.0
# Transaction completed!
#
# Deposition completed! Current balance: $250.0
# Transaction completed!
