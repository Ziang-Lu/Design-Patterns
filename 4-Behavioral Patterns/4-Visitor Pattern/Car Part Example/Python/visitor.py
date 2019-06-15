#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Visitor module.
"""

__author__ = 'Ziang Lu'

import random
from abc import ABC, abstractmethod

from color import Color, process_color


class CarPartVisitor(ABC):
    """
    Abstract CarPartVisitor class that works as "Visitor".
    This class encapsulates the executing algorithm (operation) on elements in
    the object structure, and can visit each "Element" in the object structure,
    and perform desired algorithm (handle operation) on that "Element".
    """
    __slots__ = []

    @abstractmethod
    def visit_engine(self, engine) -> None:
        """
        Lets this car part visitor visit the given engine, and perform desired
        algorithm (handle operation) on it.
        :param engine: Engine
        :return: None
        """
        pass

    @abstractmethod
    def visit_wheel(self, wheel) -> None:
        """
        Lets this car part visitor visit the given wheel, and perform desired
        algorithm (handle operation) on it.
        :param wheel: Wheel
        :return: None
        """
        pass

    @abstractmethod
    def visit_light(self, light) -> None:
        """
        Lets this car part visitor visit the given light, and perform desired
        algorithm (handle operation) on it.
        :param light: Light
        :return: None
        """
        pass


class CarPartPrinter(CarPartVisitor):
    """
    Concrete CarPartPrinter class that works as "ConcreteVisitor".
    This class centralizes the printing functionality, so that an instance of
    this class can visit each "Element" in the object structure, and print that
    "Element".
    """
    __slots__ = []

    def visit_engine(self, engine):
        print(f'Car Part Printer prints an engine: {engine}')

    def visit_wheel(self, wheel):
        print(f'Car Part Printer prints a wheel: {wheel}')

    def visit_light(self, light):
        print(f'Car Part Printer prints a light: {light}')


class CarPartRenderer(CarPartVisitor):
    """
    Concrete CarPartRenderer class that works as "ConcreteVisitor".
    This class centralizes the rendering functionality, so that an instance of
    this class can visit each "Element" in the object structure, and render that
    "Element".
    """
    __slots__ = []

    @staticmethod
    def _print_rendered_color(car_part, color: Color) -> None:
        """
        Private helper method to print the rendered color of the given car part.
        :param car_part: CarPart
        :param color: Color
        :return: None
        """
        print(f'Car Part Renderer renders {type(car_part).__name__} with '
              f'{process_color(color)}.')

    def visit_engine(self, engine):
        # Randomly assign a color to the given engine
        random_number = random.randint(0, 2)
        if random_number == 0:
            self._print_rendered_color(engine, Color.BLACK)
            engine.set_color(Color.BLACK)
        elif random_number == 1:
            self._print_rendered_color(engine, Color.GRAY)
            engine.set_color(Color.GRAY)
        elif random_number == 2:
            self._print_rendered_color(engine, Color.WHITE)
            engine.set_color(Color.WHITE)

    def visit_wheel(self, wheel):
        # Randomly assign a color to the given wheel
        random_number = random.randint(0, 2)
        if random_number == 0:
            self._print_rendered_color(wheel, Color.BLACK)
            wheel.set_color(Color.BLACK)
        elif random_number == 1:
            self._print_rendered_color(wheel, Color.GRAY)
            wheel.set_color(Color.GRAY)
        elif random_number == 2:
            self._print_rendered_color(wheel, Color.WHITE)
            wheel.set_color(Color.WHITE)

    def visit_light(self, light) -> None:
        # Randomly assign a color to the given light
        random_number = random.randint(0, 2)
        if random_number == 0:
            self._print_rendered_color(light, Color.RED)
            light.set_color(Color.RED)
        elif random_number == 1:
            self._print_rendered_color(light, Color.YELLOW)
            light.set_color(Color.YELLOW)
        elif random_number == 2:
            self._print_rendered_color(light, Color.WHITE)
            light.set_color(Color.WHITE)


class CarPartUpgrader(CarPartVisitor):
    """
    Concrete CarPartUpgrader class that works as "ConcreteVisitor".
    This class centralizes the upgrading functionality, so that an instance of
    this class can visit each "Element" in the object structure, and upgrade
    that "Element".
    """
    __slots__ = []

    def visit_engine(self, engine):
        engine.upgrade()
        print(f'Car Part Upgrader upgrades an Engine to {engine}')

    def visit_wheel(self, wheel):
        wheel.upgrade()
        print(f'Car Part Upgrader upgrades a Wheel to {wheel}')

    def visit_light(self, light):
        light.upgrade()
        print(f'Car Part Upgrader upgrades a Light to {light}')
