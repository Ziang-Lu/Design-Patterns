#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Application module.
"""

__author__ = 'Ziang Lu'

from atm import AtmMachine
from card import Card


def main():
    pnc_card = Card(1005, 1000)
    atm = AtmMachine()

    atm.insert_card(pnc_card)
    atm.enter_pin(1005)
    atm.check_balance()
    atm.request_cash(1500)
    atm.eject_card()

    print()
    atm.insert_card(pnc_card)
    atm.enter_pin(1005)
    atm.check_balance()
    atm.request_cash(1500)
    atm.eject_card()


if __name__ == '__main__':
    main()

# Output:
# Current balance: $1000
# No enough balance in the card!
# Thanks for using.
#
# Current balance: $1000
# No enough balance in the card!
# Thanks for using.
