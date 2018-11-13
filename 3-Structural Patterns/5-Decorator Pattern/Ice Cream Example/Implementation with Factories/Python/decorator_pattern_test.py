#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Application that actually uses Decorator Pattern.
"""

__author__ = 'Ziang Lu'

from ice_cream_factory import (
    IceCreamWithNutsFactory, IceCreamWithSprinklesFactory,
    VanillaIceCreamFactory
)


def main():
    my_ice_cream = IceCreamWithNutsFactory(
        IceCreamWithSprinklesFactory(VanillaIceCreamFactory.get_instance())
    ).make_ice_cream()
    print(my_ice_cream)


if __name__ == '__main__':
    main()

# Output:
# Creating a Vanilla Ice Cream
# Adding Sprinkles
# Adding Nuts
# VanillaIceCream with toppings ['Sprinkles', 'Nuts']
