#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Flyweight module.
"""

__author__ = 'Ziang Lu'

from abc import ABC, abstractmethod

from color import Color


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
