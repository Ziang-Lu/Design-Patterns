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
    This abstract class acts as a bridge between the abstraction layer and the
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
    This class is implemented as a singleton class.
    """

    @classmethod
    def get_instance(cls):
        """
        Gets the singleton instance.
        :return: RedImplementor
        """
        return cls.__new__(cls)

    def __new__(cls, *args, **kwargs):
        if not hasattr(cls, '_instance'):
            cls._instance = super().__new__(cls)
        return cls._instance

    def fill_color(self, shape):
        print(f'{shape} is filled with red color using RedImplementor.')


class BlueImplementor(ColorImplementor):
    """
    Concrete RedImplementor class that works as "ConcreteImplementor" to fill a
    shape with blue color.
    This class is implemented as a singleton class.
    """

    @classmethod
    def get_instance(cls):
        """
        Gets the singleton instance.
        :return: BlueImplementor
        """
        return cls.__new__(cls)

    def __new__(cls, *args, **kwargs):
        if not hasattr(cls, '_instance'):
            cls._instance = super().__new__(cls)
        return cls._instance

    def fill_color(self, shape):
        print(f'{shape} is filled with blue color using RedImplementor.')
