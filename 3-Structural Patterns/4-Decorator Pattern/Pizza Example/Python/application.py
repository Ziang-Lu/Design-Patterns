#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Application that actually use Decorator Pattern.
"""

__author__ = 'Ziang Lu'

from pizza import PizzaWithMozzarella, PlainPizza, PizzaWithTomatoSauce


def main():
    my_pizza = PizzaWithTomatoSauce(PizzaWithMozzarella(PlainPizza()))
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
# Cost of Plain Pizza: $8.0
# Cost of Mozzarella Cheese: $1.0
# Cost of Tomato Sauce: $0.5
# Cost of my pizza: $9.5
