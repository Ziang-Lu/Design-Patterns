#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Shape module.
"""

__author__ = 'Ziang Lu'


from abc import ABC, abstractmethod


class Shape(ABC):
    """
    Abstract Shape class that works as "Component".
    """
    __slots__ = []

    @abstractmethod
    def draw(self) -> None:
        """
        Draws this shape.
        :return: None
        """
        pass


class Rectangle(Shape):
    """
    Rectangle class that works as one kind of "ConcreteComponent".
    """
    __slots__ = []

    def draw(self) -> None:
        print('Shape: Rectangle has been drawn.')

    def __repr__(self):
        return 'Shape: Rectangle'


class Circle(Shape):
    """
    Circle class that works as one kind of "ConcreteComponent".
    """
    __slots__ = []

    def draw(self) -> None:
        print('Shape: Circle has been drawn.')

    def __repr__(self):
        return 'Shape: Circle'


class ShapeDecorator(Shape):
    """
    Abstract ShapeDecorator class that works as "Decorator".
    This is essentially a wrapper that reproduces the functionality of an
    existing class and adds new functionality to it, without impacting existing
    structure and functionality of the objects.

    However, since decorators should be stackable, which means we should be able
    to add decorators on decorators on decorators...... to further increase the
    provided functionalities.
    Thus, we let different "ConcreteComponent" classes and the abstract
    "Decorator" both inherit from the common super class "Component", so that
    "Decorator" will only have an abstract "Component" object to decorate, but
    does not need to care it will actually decorate a "ConcreteComponent" or
    another "Decorator."

    Note that since for "Decorator", we are forwarding the request from the
    client to the "Component" it's decorating, we are actually in some sense
    using Delegation Pattern here
    """
    __slots__ = ['_shape_to_decorate']

    def __init__(self, shape_to_decorate: Shape):
        """
        Constructor with parameter.
        :param shape_to_decorate: Shape
        """
        self._shape_to_decorate = shape_to_decorate
        # Dynamically customize and add functionality to this Shape instance,
        # which could either be a concrete shape or some other ShapeDecorator.

    def draw(self) -> None:
        self._shape_to_decorate.draw()

    def __repr__(self):
        return repr(self._shape_to_decorate)


class ShapeInBlue(ShapeDecorator):
    """
    ShapeInBlue class that works as one kind of "ConcreteDecorator".
    This class decorates blue color to a Shape ("Component") object.
    """
    __slots__ = []

    def __init__(self, shape: Shape):
        """
        Constructor with parameter.
        :param shape: Shape
        """
        super().__init__(shape)

    def draw(self) -> None:
        super().draw()
        print(f'Color: Blue has been applied to {self._shape_to_decorate}.')


class ShapeInRed(ShapeDecorator):
    """
    ShapeInRed class that works as one kind of "ConcreteDecorator".
    This class decorates blue color to a Shape ("Component") object.
    """
    __slots__ = []

    def __init__(self, shape: Shape):
        """
        Constructor with parameter.
        :param shape: Shape
        """
        super().__init__(shape)

    def draw(self) -> None:
        super().draw()
        print(f'Color: Red has been applied to {self._shape_to_decorate}.')


class ShapeInYellowOutline(ShapeDecorator):
    """
    ShapeInYellowOutline class that works as one kind of
    "ConcreteDecorator".
    This class decorates yellow outline to a Shape ("Component") object.
    """
    __slots__ = []

    def __init__(self, shape: Shape):
        """
        Constructor with parameter.
        :param shape: Shape
        """
        super().__init__(shape)

    def draw(self) -> None:
        super().draw()
        print(f'Outline: Yellow has been applied to {self._shape_to_decorate}')
