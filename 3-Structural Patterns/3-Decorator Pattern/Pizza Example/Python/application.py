#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Application that actually use Decorator Pattern.
"""

__author__ = 'Ziang Lu'

from pizza import (
    MozzarellaPizzaDecorator, PlainPizza, TomatoSaucePizzaDecorator
)


def main():
    my_pizza = TomatoSaucePizzaDecorator(MozzarellaPizzaDecorator(PlainPizza()))
    print()
    print('Ingredients of my pizza:')
    print(my_pizza.get_description())
    print(f'Cost of my pizza: ${my_pizza.get_price()}')


if __name__ == '__main__':
    main()

# Output:
# Adding thin dough
# Adding mozzarella cheese
# Adding tomato sauce
#
# Ingredients of my pizza:
# Thin Dough, Mozzarella Cheese, Tomato Sauce
# Cost of my pizza: $9.5
