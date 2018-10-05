#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Strategy module.
"""

__author__ = 'Ziang Lu'

from abc import ABC, abstractmethod
from typing import List


class SortingStrategy(ABC):
    """
    Abstract sorting strategy class to define the sorting task to perform
    (sorting problem to solve).
    """
    __slots__ = []

    @abstractmethod
    def sort(self, array: List[int]) -> None:
        """
        Sort the given array using some sorting algorithm.
        :param array: list[int]
        :return: None
        """
        pass


class SelectionSort(SortingStrategy):
    """
    Concrete Selection Sort strategy to perform the sorting task (solve the
    sorting problem).
    This class is implemented as a singleton class.
    """

    @classmethod
    def get_instance(cls):
        """
        Gets the singleton instance.
        :return: SelectionSort
        """
        return cls.__new__(cls)

    def __new__(cls, *args, **kwargs):
        if not hasattr(cls, '_instance'):
            cls._instance = super().__new__(cls)
        return cls._instance

    def sort(self, array):
        for out in range(len(array) - 1):
            min_idx = out
            for in_ in range(out + 1, len(array)):
                if array[in_] < array[min_idx]:
                    min_idx = in_
            array[out], array[min_idx] = array[min_idx], array[out]
        print('Sorting is performed using Selection Sort algorithm.')


class BubbleSort(SortingStrategy):
    """
    Concrete Bubble Sort strategy to perform the sorting task (solve the sorting
    problem).
    This class is implemented as a singleton class.
    """

    @classmethod
    def get_instance(cls):
        """
        Gets the singleton instance.
        :return: BubbleSort
        """
        return cls.__new__(cls)

    def __new__(cls, *args, **kwargs):
        if not hasattr(cls, '_instance'):
            cls._instance = super().__new__(cls)
        return cls._instance

    def sort(self, array):
        for out in range(len(array) - 1, 0, -1):
            for in_ in range(out):
                if array[in_] > array[in_ + 1]:
                    array[in_], array[in_ + 1] = array[in_ + 1], array[in_]
        print('Sorting is performed using Bubble Sort algorithm.')


class InsertionSort(SortingStrategy):
    """
    Concrete Insertion Sort strategy to perform the sorting task (solve the
    sorting problem).
    This class is implemented as a singleton class.
    """

    @classmethod
    def get_instance(cls):
        """
        Gets the singleton instance.
        :return: InsertionSort
        """
        return cls.__new__(cls)

    def __new__(cls, *args, **kwargs):
        if not hasattr(cls, '_instance'):
            cls._instance = super().__new__(cls)
        return cls._instance

    def sort(self, array):
        for out in range(1, len(array)):
            tmp = array[out]
            insert_idx = out
            while insert_idx > 0 and array[insert_idx - 1] > tmp:
                insert_idx -= 1
            array[insert_idx + 1:out + 1] = array[insert_idx:out]
            array[insert_idx] = tmp
        print('Sorting is performed using Insertion Sort algorithm.')
