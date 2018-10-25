#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Flyweight rectangle module.
"""

__author__ = 'Ziang Lu'

from abc import abstractmethod

from flyweight import FlyweightShape


class FlyweightRectangle(FlyweightShape):
    """
    Abstract FlyweightRectangle class that works as "Flyweight".
    This abstract class enables sharing but does not enforce it; it defines
    "operation(extrinsic_state)" to assign extrinsic states to or customize
    "ConcreteFlyweight", to let it change to "UnsharedConcreteFlyweight".
    """
    __slots__ = []

    @abstractmethod
    def set_width(self, width: float) -> None:
        """
        Sets the width of this rectangle.
        :param width: float
        :return: None
        """
        pass

    @abstractmethod
    def set_height(self, height: float) -> None:
        """
        Sets the height of this rectangle.
        :param height: float
        :return: None
        """
        pass


class SharedRectangle(FlyweightRectangle):
    """
    Concrete SharedRectangle class that works as "ConcreteFlyweight".
    This class pre-defines all the intrinsic states (which are constant and
    context-independent).
    This class is implemented as a singleton class.
    """

    @classmethod
    def get_instance(cls):
        """
        Gets the singleton instance.
        :return: SharedCircle
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
        # Intrinsic states
        self._bottom_left_x = 0.0
        self._bottom_left_y = 0.0
        print(f'Creating a Shared Rectangle without color: {self}')

    @property
    def bottom_left_x(self) -> float:
        """
        Accessor of bottom_left_x.
        :return: float
        """
        return self._bottom_left_x

    @property
    def bottom_left_y(self) -> float:
        """
        Accessor of bottom_left_y.
        :return: float
        """
        return self._bottom_left_y

    def set_width(self, width):
        # Do nothing
        pass

    def set_height(self, height):
        # Do nothing
        pass

    def draw(self, color):
        # Do nothing
        pass

    def __repr__(self):
        return f'SharedRectangle [bottom_left_x={self._bottom_left_x}, ' \
               f'bottom_left_y={self._bottom_left_y}]'


class UnsharedRectangle(FlyweightRectangle):
    """
    Concrete UnsharedRectangle class that works as "UnsharedConcreteFlyweight".
    This class contains a reference to the shared "ConcreteFlyweight", which
    contains all the intrinsic states. And after customized with the given
    extrinsic states (which are NOT constant, context-dependent and needs to be
    calculated on the fly), this class works as "UnsharedConcreteFlyweight".
    """
    __slots__ = ['_flyweight_rect', '_width', '_height', '_color']

    def __init__(self, flyweight_rect: SharedRectangle):
        """
        Constructor with parameter.
        :param flyweight_rect: SharedRectangle
        """
        # Reference to the shared flyweight rectangle (Intrinsic states)
        self._flyweight_rect = flyweight_rect

        # Extrinsic states
        self._width = 4.0
        self._height = 3.0
        self._color = None

    def set_width(self, width):
        self._width = width

    def set_height(self, height):
        self._height = height

    def draw(self, color):
        self._color = color
        print(f'Rectangle has been drawn with {color}: {self}')

    def __repr__(self):
        s = 'UnsharedRectangle' + ' ['
        s += f'bottom_left_x={self._flyweight_rect.bottom_left_x}' + ', '
        s += f'bottom_left_y={self._flyweight_rect.bottom_left_y}' + ', '
        s += f'width={self._width}' + ', '
        s += f'height={self._height}' + ', '
        s += f'color={self._color}' + ']'
        return s
