#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Car module.
"""

__author__ = 'Ziang Lu'

from abc import ABC, abstractmethod

from color import Color
from visitor import (
    CarPartPrinter, CarPartRenderer, CarPartVisitor, CarPartUpgrader
)


class CarPart(ABC):
    """
    Abstract CarPart class that works as "Element/Visitable".
    This class represents an element in the object structure, and can be visited
    by a "Visitor", so that the "Visitor" can perform algorithm (handle
    operation) on this "Element".
    """
    __slots__ = ['_color']

    def __init__(self, color: Color):
        """
        Constructor with parameter.
        :param color: Color
        """
        self._color = color

    def set_color(self, color: Color) -> None:
        """
        Mutator of color.
        :param color: Color
        :return: None
        """
        self._color = color

    @abstractmethod
    def upgrade(self) -> None:
        """
        Upgrades this car part.
        :return: None
        """
        pass

    @abstractmethod
    def accept(self, visitor: CarPartVisitor) -> None:
        """
        Accepts the given visitor and lets it perform algorithm (handle
        operation) on this "Element".
        In this way, we can change the executing algorithm (operation) on this
        "Element" by simply varying the visitor object.
        :param visitor: CarPartVisitor
        :return: None
        """
        pass


class Engine(CarPart):
    """
    Concrete Engine class that works as "ConcreteElement".
    """
    __slots__ = ['_horsepower']

    def __init__(self, color: Color):
        """
        Constructor with parameter.
        :param color: Color
        """
        super().__init__(color)
        self._horsepower = 200

    def upgrade(self):
        self._horsepower += 50

    def accept(self, visitor):
        visitor.visit_engine(self)

    def __repr__(self):
        return f'Engine[color={self._color}, horsepower={self._horsepower}]'


class Wheel(CarPart):
    """
    Concrete Wheel class that works as "ConcreteElement".
    """
    __slots__ = ['_level']

    def __init__(self, color: Color):
        """
        Constructor with parameter.
        :param color: Color
        """
        super().__init__(color)
        self._level = 1

    def upgrade(self):
        self._level += 1

    def accept(self, visitor):
        visitor.visit_wheel(self)

    def __repr__(self):
        return f'Wheel[color={self._color}, level={self._level}]'


class Light(CarPart):
    """
    Concrete Light class that works as "ConcreteElement".
    """
    __slots__ = ['_lightness']

    def __init__(self, color: Color):
        """
        Constructor with parameter.
        :param color: Color
        """
        super().__init__(color)
        self._lightness = 1

    def upgrade(self):
        self._lightness += 1

    def accept(self, visitor):
        visitor.visit_light(self)

    def __repr__(self):
        return f'Light[color={self._color}, lightness={self._lightness}]'


class Car(object):
    """
    Car class that actually uses Visitor Pattern.
    The Visitor Pattern separates an algorithm (an operation) from the object
    structure it operates on, and the executing algorithm (operation) is
    encapsulated in a visitor object.
    In this way, we can change the executing algorithm (operation) on each
    element in the object structure by simply varying the visitor object,
    without needing to modify the object structure itself.
    """
    __slots__ = ['_parts']

    def __init__(self):
        """
        Default constructor.
        """
        self._parts = [Engine(Color.GRAY)]
        for _ in range(4):
            self._parts.append(Wheel(Color.GRAY))
        for _ in range(2):
            self._parts.append(Light(Color.YELLOW))

    def print_car_parts(self) -> None:
        """
        Prints the car parts.
        :return: None
        """
        print('Preparing to print car parts...')
        # Create a car part printer that is able to visit each car part in the
        # car parts objects structure, and prints that car part
        car_part_printer = CarPartPrinter()
        for part in self._parts:
            part.accept(visitor=car_part_printer)

    def render_car_parts(self) -> None:
        """
        Renders the car parts.
        :return: None
        """
        print('Preparing to render car parts...')
        # Create a car part renderer that is able to visit each car part in the
        # car parts objects structure, and renders that car part
        car_part_renderer = CarPartRenderer()
        for part in self._parts:
            part.accept(visitor=car_part_renderer)

    def upgrade_car_parts(self) -> None:
        """
        Upgrades the car parts.
        :return: None
        """
        print('Preparing to upgrade car parts...')
        # Create a car part upgrader that is able to visit each car part in the
        # car parts objects structure, and upgrades that car part
        car_part_upgrader = CarPartUpgrader()
        for part in self._parts:
            part.accept(visitor=car_part_upgrader)
