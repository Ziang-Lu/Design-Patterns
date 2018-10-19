#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Flyweight module.
"""

__author__ = 'Ziang Lu'

from abc import ABC, abstractmethod

from color import Color, process_color


class FlyweightShape(ABC):
    """
    Abstract FlyweightShape class that works as "Flyweight".
    This abstract class enables sharing but does not enforce it; it defines
    "operation(extrinsic_state)" to assign extrinsic states to or customize
    "ConcreteFlyweight", to let it change to "UnsharedConcreteFlyweight".
    """
    __slots__ = []

    @abstractmethod
    def draw(self, color: Color) -> None:
        """
        Draws this flyweight shape with the given color.
        :param color: Color
        :return: None
        """
        pass


class SharedCircle(FlyweightShape):
    """
    Concrete SharedCircle class.
    This class first works as "ConcreteFlyweight", pre-defines all the intrinsic
    states (which are constant).
    After assignment of extrinsic states (which are NOT constant and needs to be
    calculated on the fly) or customization, this class would work as
    "UnsharedConcreteFlyweight".
    """
    __slots__ = ['_x', '_y', '_radius', '_color']

    def __init__(self):
        """
        Default constructor.
        """
        # Intrinsic states
        self._x = 0.0
        self._y = 0.0

        # Extrinsic states
        self._radius = 5.0
        self._color = None
        print(f'Creating a Shared Circle without color: {self}')

    def set_radius(self, radius: float) -> None:
        """
        Mutator of radius.
        :param radius: float
        :return: None
        """
        self._radius = radius

    def draw(self, color):
        self._color = color
        print(f'Circle has been drawn with {process_color(self._color)}: '
              f'{self}')

    def __repr__(self):
        return f'Circle@{hex(hash(self))} [x={self._x}, y={self._y}, ' \
               f'radius={self._radius}, color={process_color(self._color)}]'


class SharedRectangle(FlyweightShape):
    """
    Concrete SharedRectangle class.
    This class first works as "ConcreteFlyweight", pre-defines all the intrinsic
    states (which are constant).
    After assignment of extrinsic states (which are NOT constant and needs to be
    calculated on the fly) or customization, this class would work as
    "UnsharedConcreteFlyweight".
    """
    __slots__ = [
        '_left_bottom_x', '_left_bottom_y', '_width', '_height', '_color'
    ]

    def __init__(self):
        """
        Default constructor.
        """
        # Intrinsic states
        self._left_bottom_x = 0.0
        self._left_bottom_y = 0.0

        # Extrinsic states
        self._width = 4.0
        self._height = 3.0
        self._color = None
        print(f'Creating a Shared Rectangle without color: {self}')

    def set_width(self, width: float) -> None:
        """
        Mutator of width.
        :param width: float
        :return: None
        """
        self._width = width

    def set_height(self, height: float) -> None:
        """
        Mutator of height.
        :param height: float
        :return: None
        """
        self._height = height

    def draw(self, color):
        self._color = color
        print(f'Rectangle has been drawn with {process_color(self._color)}: '
              f'{self}')

    def __repr__(self):
        return f'Rectangle@{hex(hash(self))} ' \
               f'[left_bottom_x={self._left_bottom_x}, ' \
               f'left_bottom_y={self._left_bottom_y}, width={self._width}, ' \
               f'height={self._height}, color={process_color(self._color)}]'


class FlyweightShapeFactory(object):
    """
    FlyweightShapeFactory class that actually uses Flyweight Pattern.
    Flyweight Pattern stores already existing similar objects
    ("ConcreteFlyweight") in a cache, so that they can easily be used (shared),
    and creates a new object only when no matching object is found.

    This class is implemented as a singleton class.
    """

    @classmethod
    def get_instance(cls):
        """
        Gets the singleton instance.
        :return: FlyweightShapeFactory
        """
        return cls.__new__(cls)

    def __new__(cls, *args, **kwargs):
        if not hasattr(cls, '_instance'):
            cls._instance = super().__new__(cls)
            cls._instance.__init__()
        return cls._instance

    def __init__(self):
        """
        Default constructor.
        """
        self._flyweight_shapes = {}

    def get_flyweight_shape(self, shape_type: str):
        """
        Gets the flyweight shape of the given type.
        :param shape_type: str
        :return: FlyweightShape
        """
        if shape_type not in self._flyweight_shapes:
            if shape_type.lower() == 'circle':
                self._flyweight_shapes['circle'] = SharedCircle()
            elif shape_type.lower() == 'rectangle':
                self._flyweight_shapes['rectangle'] = SharedRectangle()
        return self._flyweight_shapes[shape_type]
