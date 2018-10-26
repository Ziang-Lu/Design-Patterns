#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Prototype module.
"""

__author__ = 'Ziang Lu'

from abc import ABC, abstractmethod


class Shape(ABC):
    """
    Abstract Shape class.
    """
    __slots__ = ['_type']

    def __init__(self, type_: str):
        """
        Constructor with parameter.
        :param type_: str
        """
        self._type = type_

    @property
    def type(self) -> str:
        """
        Accessor of type.
        :return: str
        """
        return self._type

    @abstractmethod
    def draw(self) -> None:
        """
        Draws this shape.
        :return: None
        """
        pass


class Rectangle(Shape):
    """
    Concrete Rectangle class.
    """
    __slots__ = []

    def __init__(self):
        """
        Default constructor.
        """
        super().__init__('Rectangle')

    def draw(self) -> None:
        print('In Rectangle.draw() method')


class Square(Shape):
    """
    Concrete Square class.
    """
    __slots__ = []

    def __init__(self):
        """
        Default constructor.
        """
        super().__init__('Square')

    def draw(self) -> None:
        print('In Square.draw() method')


class Circle(Shape):
    """
    Concrete Circle class.
    """
    __slots__ = []

    def __init__(self):
        """
        Default constructor.
        """
        super().__init__('Circle')

    def draw(self) -> None:
        print('In Circle.draw() method')
