#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Model module.
"""

__author__ = 'Ziang Lu'


from abc import ABC, abstractmethod


class Graphic(ABC):
    """
    Abstract Graphic class that works as "Component".
    Note that this implementation uses Design-for-Type-Safety, i.e., defining
    child-related operations only in "Composite"
    """
    __slots__ = ['_name']

    def __init__(self, name: str):
        """
        Constructor with parameter.
        :param name: str
        """
        self._name = name

    @abstractmethod
    def draw(self) -> None:
        """
        Draws this graphic.
        :return: None
        """
        pass

    def _draw_helper(self):
        """
        Protected helper function to draw this graphic.
        :return: None
        """
        print(f'Drawing {self._name}')

    @abstractmethod
    def translate(self, x: int, y: int) -> None:
        """
        Translates this graphic by the given amount of translation.
        :param x: int
        :param y: int
        :return: None
        """
        pass

    def _translate_helper(self, x: int, y: int) -> None:
        """
        Protected helper function to translate this graphic.
        :param x: int
        :param y: int
        :return: None
        """
        print(f'Translating {self._name} by x={x}, y={y}')

    @abstractmethod
    def resize(self, times: float) -> None:
        """
        Resizes this graphic by the given amount of times.
        :param times: float
        :return: None
        """
        pass

    def _resize_helper(self, times: float) -> None:
        """
        Protected helper function to resize this graphic.
        :param times: float
        :return: None
        """
        print(f'Resizing {self._name} by {times} times')


class GraphicComposite(Graphic):
    """
    GraphicComposite class that works as "Composite".
    The "Composite" models nodes with children in the hierarchical structure.
    However, since both "Composite" and "Leaf" inherit from the common super
    class "Component", "Composite" does not need to keep track of its children's
    actual type, but only need to keep track of a collection of the abstract
    "Component" as its contents.
    Without the abstract "Component" super class abstraction, "Component" would
    have to maintain different lists for each kind of element in its contents,
    and would need to provide separate method for each kind of element.
    """
    __slots__ = ['_sub_graphics']

    def __init__(self, name: str):
        """
        Constructor with parameter.
        :param name: str
        """
        super().__init__(name)
        self._sub_graphics = []

    def draw(self):
        print(f'Drawing {self._name} as follows:')
        for sub_graphic in self._sub_graphics:
            sub_graphic.draw()

    def translate(self, x, y):
        print(f'Translating {self._name} as follows:')
        for sub_graphic in self._sub_graphics:
            sub_graphic.translate(x, y)

    def resize(self, times):
        print(f'Resizing {self._name} as follows:')
        for sub_graphic in self._sub_graphics:
            sub_graphic.resize(times)

    def add_graphic(self, graphic: Graphic) -> None:
        """
        Adds the given graphic to the sub-graphics of this graphic composite.
        :param graphic: Graphic
        :return: None
        """
        self._sub_graphics.append(graphic)


class Rectangle(Graphic):
    """
    Rectangle class that works as one kind of "Leaf".
    """

    def __init__(self, name: str):
        """
        Constructor with parameter.
        :param name: str
        """
        super().__init__(name)

    def draw(self):
        super()._draw_helper()

    def translate(self, x, y):
        super()._translate_helper(x, y)

    def resize(self, times):
        super()._resize_helper(times)


class Circle(Graphic):
    """
    Circle class that works as one kind of "Leaf".
    """

    def __init__(self, name: str):
        """
        Constructor with parameter.
        :param name: str
        """
        super().__init__(name)

    def draw(self):
        super()._draw_helper()

    def translate(self, x, y):
        super()._translate_helper(x, y)

    def resize(self, times):
        super()._resize_helper(times)
