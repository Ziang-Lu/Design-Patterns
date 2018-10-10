#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Appliance implementor module.
"""

__author__ = 'Ziang Lu'

from abc import ABC, abstractmethod


class ApplianceImplementor(ABC):
    """
    Abstract appliance implementor class that works as "Implementor" to define
    the methods that the concrete implementation classes must implement.
    This abstract class acts as a bridge between the abstraction layer and the
    concrete implementation classes.
    """
    __slots__ = []

    @abstractmethod
    def turn_on(self) -> None:
        """
        Turns on this appliance.
        :return: None
        """
        pass

    @abstractmethod
    def turn_off(self) -> None:
        """
        Turns off this appliance.
        :return: None
        """
        pass


class TV(ApplianceImplementor):
    """
    Concrete TV class that works as "ConcreteImplementor".
    """
    __slots__ = []

    def turn_on(self):
        print('TV is turned on.')

    def turn_off(self):
        print('TV is turned off.')


class FloorLamp(ApplianceImplementor):
    """
    Concrete FloorLamp class that works as "ConcreteImplementor".
    """
    __slots__ = []

    def turn_on(self):
        print('Floor Lamp is turned on.')

    def turn_off(self):
        print('Floor Lamp is turned off.')
