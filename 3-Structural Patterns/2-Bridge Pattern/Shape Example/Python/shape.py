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
    __slots__ = ['_color_impl']

    def __init__(self):
        """
        Default constructor.
        """
        self._color_impl = None

    def draw(self) -> None:
        """
        Draws this shape.
        :return: None
        """
        print(f'{self} has been drawn without any color.')

    def set_color_implementor(self, color_impl: ColorImplementor) -> None:
        """
        Mutator of color_impl.
        :param color_impl: ColorImplementor
        :return: None
        """
        self._color_impl = color_impl

    def fill_color(self) -> None:
        """
        Fills the color of this shape using a filling-color implementor.
        :return: None
        """
        self._color_impl.fill_color(self)


class Rectangle(Shape):
    """
    Concrete Rectangle class that works as "ConcreteAbstraction".
    """
    __slots__ = ['_center_x', '_center_y', '_width', '_height']

    def __init__(self, center_x: float, center_y: float, width: float,
                 height: float):
        """
        Constructor with parameter.
        :param center_x: float
        :param center_y: float
        :param width: float
        :param height: float
        """
        super().__init__()
        self._center_x = center_x
        self._center_y = center_y
        self._width = width
        self._height = height

    def __repr__(self):
        return f'Rectangle[center_x={self._center_x}, ' \
               f'center_y={self._center_y}, width={self._width}, ' \
               f'height={self._height}]'


class Circle(Shape):
    """
    Concrete Circle class that works as "ConcreteAbstraction".
    """
    __slots__ = ['_x', '_y', '_radius']

    def __init__(self, x: float, y: float, radius: float):
        """
        Constructor with parameter.
        :param x: float
        :param y: float
        :param radius: float
        """
        super().__init__()
        self._x = x
        self._y = y
        self._radius = radius

    def __repr__(self):
        return f'Circle[x={self._x}, y={self._y}, radius={self._radius}]'
