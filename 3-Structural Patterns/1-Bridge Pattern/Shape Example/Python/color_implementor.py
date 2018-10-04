#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Filling-color implementor module.
"""

__author__ = 'Ziang Lu'

from abc import ABC, abstractmethod


class ColorImplementor(ABC):
    """
    Abstract filling-color implementor class that works as "Implementor" to
    define the methods that the concrete implementation classes must implement.
    This interface acts as a bridge between the abstraction layer and the
    concrete implementation classes.
    """
    __slots__ = []

    @abstractmethod
    def fill_color(self, shape) -> None:
        """
        Fills the given shape with some color.
        :param shape: Shape
        :return: None
        """
        pass


class RedImplementor(ColorImplementor):
    """
    Concrete RedImplementor class that works as "ConcreteImplementor" to fill a
    shape with red color.
    """
    __slots__ = []

    def fill_color(self, shape):
        print(f'{type(shape).__name__} is filled with red color using '
              f'RedImplementor.')


class BlueImplementor(ColorImplementor):
    """
    Concrete RedImplementor class that works as "ConcreteImplementor" to fill a
    shape with blue color.
    """
    __slots__ = []

    def fill_color(self, shape):
        print(f'{type(shape).__name__} is filled with blue color using '
              f'RedImplementor.')
