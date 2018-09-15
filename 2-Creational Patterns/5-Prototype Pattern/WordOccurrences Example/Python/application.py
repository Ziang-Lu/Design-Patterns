#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Application that actually uses WordOccurrences objects to perform some tasks.
"""

__author__ = 'Ziang Lu'

import copy

from prototype import WordOccurrences


def main():
    text = 'The Prototype Pattern is a creational design pattern in software ' \
           'development first described in the book Design Patterns.'
    word = 'pattern'
    prototype = WordOccurrences(text, word)

    product = copy.deepcopy(prototype)
    print(product.get_nth_occurrence(1))
    another_product = copy.deepcopy(prototype)
    print(another_product.get_nth_occurrence(1))


if __name__ == '__main__':
    main()

# Output:
# 45
# 45
