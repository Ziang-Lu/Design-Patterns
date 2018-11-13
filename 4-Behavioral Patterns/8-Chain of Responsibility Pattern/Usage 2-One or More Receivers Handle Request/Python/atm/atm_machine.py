#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
ATM module.
"""

__author__ = 'Ziang Lu'

from atm.dispatcher import (
    FiveDispatcher, HundredDispatcher, OneDispatcher, TenDispatcher,
    TwentyDispatcher
)


class AtmMachine(object):
    __slots__ = ['_first_dispatcher']

    def __init__(self):
        """
        Default constructor.
        """
        self._first_dispatcher = HundredDispatcher.get_instance(
            TwentyDispatcher.get_instance(
                TenDispatcher.get_instance(
                    FiveDispatcher.get_instance(OneDispatcher.get_instance())
                )
            )
        )

    def withdraw(self, requested_amount: int) -> None:
        """
        Withdraws the given amount of money from this ATM.
        :param requested_amount: int
        :return: None
        """
        # Delegate to the dispatchers to handle this withdraw request
        self._first_dispatcher.dispatch(requested_amount)
