#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Application that actually uses Strategy Pattern to provide multiple algorithms,
a family of algorithms, to perform a specific task (solve a specific problem),
so that the client can select which actual implementation to use at runtime.
"""

__author__ = 'Ziang Lu'

from typing import List

from sorting_strategy import (
    BubbleSort, InsertionSort, SelectionSort, SortingStrategy
)


class SortContext(object):
    """
    SortContext class works as an interface to the outside world: it wraps a
    sorting strategy and the client will use that strategy to sort an array.
    """
    __slots__ = ['_sorting_strategy']

    @staticmethod
    def read_user_input() -> List[int]:
        """
        Reads user input to get an array.
        :return: list[int]
        """
        try:
            n = int(input('Enter array size: '))
            print('Enter input array:')
            array = []
            for _ in range(n):
                num = int(input())
                array.append(num)
            return array
        except ValueError:
            print('Please only input integer values.')

    def __init__(self):
        """
        Default constructor.
        """
        self._sorting_strategy = None

    def set_sorting_strategy(self, sorting_strategy: SortingStrategy) -> None:
        """
        Mutator of sorting_strategy.
        :param sorting_strategy: SortingStrategy
        :return: None
        """
        self._sorting_strategy = sorting_strategy

    def sort_array(self, array: List[int]) -> None:
        """
        Sorts the given array.
        We could also do choosing sorting strategy based on the input size.
        Actually this would be a more practical way in most of the modern search
        engines.
        :param array: list[int]
        :return: None
        """
        self._sorting_strategy.sort(array)
        print(array)


def main():
    array = SortContext.read_user_input()
    print('Array before sorting:')
    print(array)

    sorting_algo = input("Enter sorting algorithm: 'SelectionSort' or "
                         "'BubbleSort' or 'InsertionSort'")
    print(f'Sorting Algorithm: {sorting_algo}')

    context = SortContext()
    if sorting_algo.lower() == 'SelectionSort'.lower():
        context.set_sorting_strategy(SelectionSort())
    elif sorting_algo.lower() == 'BubbleSort'.lower():
        context.set_sorting_strategy(BubbleSort())
    elif sorting_algo.lower() == 'InsertionSort'.lower():
        context.set_sorting_strategy(InsertionSort())

    context.sort_array(array)
    print('Array after sorting:')
    print(array)


if __name__ == '__main__':
    main()
