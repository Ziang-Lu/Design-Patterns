#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Flyweight circle module.
"""

__author__ = 'Ziang Lu'

from abc import abstractmethod

from flyweight import FlyweightShape


class FlyweightCircle(FlyweightShape):
    """
    Abstract FlyweightCircle class that works as "Flyweight".
    This abstract class enables sharing but does not enforce it; it defines
    "operation(extrinsic_state)" to assign extrinsic states to or customize
    "ConcreteFlyweight", to let it change to "UnsharedConcreteFlyweight".
    """
    __slots__ = []

    @abstractmethod
    def set_radius(self, radius: float) -> None:
        """
        Sets the radius of this circle.
        :param radius: float
        :return: None
        """
        pass


class SharedCircle(FlyweightCircle):
    """
    Concrete SharedCircle class that works as "ConcreteFlyweight".
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
        self._x = 0.0
        self._y = 0.0
        print(f'Creating a Shared Circle without color: {self}')

    @property
    def x(self) -> float:
        """
        Accessor of x.
        :return: float
        """
        return self._x

    @property
    def y(self) -> float:
        """
        Accessor of y.
        :return: float
        """
        return self._y

    def set_radius(self, radius):
        # Do nothing
        pass

    def draw(self, color):
        # Do nothing
        pass

    def __repr__(self):
        return f'SharedCircle [x={self._x}, y={self._y}]'


class UnsharedCircle(FlyweightCircle):
    """
    Concrete UnsharedCircle class that works as "UnsharedConcreteFlyweight".
    This class contains a reference to the shared "ConcreteFlyweight", which
    contains all the intrinsic states. And after customized with the given
    extrinsic states (which are NOT constant, context-dependent and needs to be
    calculated on the fly), this class works as "UnsharedConcreteFlyweight".
    """
    __slots__ = ['_flyweight_circle', '_radius', '_color']

    def __init__(self, flyweight_circle: SharedCircle):
        """
        Constructor with parameter.
        :param flyweight_circle: SharedCircle
        """
        # Reference to the shared flyweight circle (Intrinsic states)
        self._flyweight_circle = flyweight_circle

        # Extrinsic states
        self._radius = 5.0
        self._color = None

    def set_radius(self, radius):
        self._radius = radius

    def draw(self, color):
        self._color = color
        print(f'Circle has been drawn with {color}: {self}')

    def __repr__(self):
        return f'UnsharedCircle [x={self._flyweight_circle.x}, ' \
               f'y={self._flyweight_circle.y}, radius={self._radius}, ' \
               f'color={self._color}]'
