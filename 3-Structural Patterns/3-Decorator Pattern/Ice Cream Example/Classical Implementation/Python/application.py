#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Application that actually uses Decorator Pattern.
"""

__author__ = 'Ziang Lu'

from ice_cream import IceCreamWithNuts, IceCreamWithSprinkles, VanillaIceCream


def main():
    my_ice_cream = IceCreamWithNuts(
        IceCreamWithSprinkles(VanillaIceCream())
    ).make_ice_cream()
    print(my_ice_cream)


if __name__ == '__main__':
    main()

# Output:
# Creating a Vanilla Ice Cream
# Adding Sprinkles
# Adding Nuts
# VanillaIceCream with toppings ['Sprinkles', 'Nuts']
