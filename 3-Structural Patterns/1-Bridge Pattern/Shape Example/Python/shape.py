#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Shape module.
"""

__author__ = 'Ziang Lu'

from abc import ABC

from color_implementor import ColorImplementor


class Shape(ABC):
    """
    Abstract Shape class that works as "Abstraction".
    This class defines a fill_color() method for the client to call, and holds a
    reference to a fill-color implementor, so that the client will use that
    implementor to fill the color of this shape.
    """
    __slots__ = ['_color_implementor']

    def __init__(self):
        """
        Default constructor.
        """
        self._color_implementor = None

    def draw(self) -> None:
        """
        Draws this shape.
        :return: None
        """
        print(f'{type(self).__name__} has been drawn without any color.')

    def set_color_implementor(self,
                              color_implementor: ColorImplementor) -> None:
        """
        Mutator of color_implementor.
        :param color_implementor: ColorImplementor
        :return: None
        """
        self._color_implementor = color_implementor

    def fill_color(self) -> None:
        """
        Fills the color of this shape using a filling-color implementor.
        :return: None
        """
        self._color_implementor.fill_color(self)


class Rectangle(Shape):
    """
    Concrete Rectangle class that works as "ConcreteAbstraction".
    """
    __slots__ = []


class Circle(Shape):
    """
    Concrete Circle class that works as "ConcreteAbstraction".
    """
    __slots__ = []
