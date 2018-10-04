#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Ice cream module.
"""

__author__ = 'Ziang Lu'

from abc import ABC


class IceCream(ABC):
    """
    Abstract product IceCream class.
    """
    __slots__ = ['_toppings']

    def __init__(self):
        """
        Default constructor.
        """
        self._toppings = []

    def add_topping(self, topping: str) -> None:
        """
        Adds the given topping to this ice cream.
        :param topping: str
        :return: None
        """
        self._toppings.append(topping)

    def __repr__(self):
        return f'{type(self).__name__} with toppings {self._toppings}'


class VanillaIceCream(IceCream):
    """
    Concrete product VanillaIceCream class.
    """
    pass
