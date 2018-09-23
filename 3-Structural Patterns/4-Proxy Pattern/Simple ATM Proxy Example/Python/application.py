#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Application that actually uses Proxy Pattern.
"""

__author__ = 'Ziang Lu'

from atm import AtmMachine
from atm_proxy import AtmMachineInfoProxy
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

    # Output:
    # Current balance: $1000
    # No enough balance in the card!
    # Thanks for using.
    #
    # Current balance: $1000
    # No enough balance in the card!
    # Thanks for using.

    print()

    # Proxy Pattern demo

    real_atm = AtmMachine()
    atm_info_proxy = AtmMachineInfoProxy(real_atm)

    # By using the proxy, we limit the accessible methods of the real subject
    # AtmMachine to be only getAtmState() and getCashInAtm().
    print(f'Current state of the ATM: {atm_info_proxy.get_atm_state()}')
    print(f'Current cash in the ATM: ${atm_info_proxy.get_cash_in_atm()}')

    # Output:
    # Current state of the ATM: NoCardState
    # Current cash in the ATM: $2000


if __name__ == '__main__':
    main()
