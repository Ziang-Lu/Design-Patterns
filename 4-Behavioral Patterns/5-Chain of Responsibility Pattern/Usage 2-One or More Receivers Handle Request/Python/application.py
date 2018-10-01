#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Application that actually uses Chain of Responsibility Pattern.
In this example, ONE OR MORE THAN ONE receivers in the chain handles the
request.
"""

__author__ = 'Ziang Lu'

from atm.atm_machine import AtmMachine


def main():
    atm = AtmMachine()
    atm.withdraw(455)


if __name__ == '__main__':
    main()

# Output:
# HundredDispatcher dispatching 4 100-dollar notes
# After dispatched by HundredDispatcher: 55 dollars pending to be dispatched
# TwentyDispatcher dispatching 2 20-dollar notes
# After dispatched by TwentyDispatcher: 15 dollars pending to be dispatched
# TenDispatcher dispatching 1 10-dollar notes
# After dispatched by TenDispatcher: 5 dollars pending to be dispatched
# FiveDispatcher dispatching 1 5-dollar notes
