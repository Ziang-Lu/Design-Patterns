#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Ice cream module.
"""

__author__ = 'Ziang Lu'

from abc import ABC, abstractmethod


class IceCream(ABC):
    """
    Abstract IceCream class that works as "Component".
    """
    __slots__ = ['_toppings']

    def __init__(self):
        self._toppings = []

    @abstractmethod
    def make_ice_cream(self):
        """
        Makes an ice cream.
        :return: IceCream
        """
        pass

    def add_topping(self, topping: str) -> None:
        """
        Adds the given topping to this ice cream.
        :param topping:
        :return:
        """
        self._toppings.append(topping)

    def __repr__(self):
        return f'{type(self).__name__} with toppings {self._toppings}'


class VanillaIceCream(IceCream):
    """
    VanillaIceCream class that works as one kind of "ConcreteComponent".
    """
    __slots__ = []

    def make_ice_cream(self):
        print('Creating a Vanilla Ice Cream')
        return self


class IceCreamDecorator(IceCream):
    """
    Abstract IceCreamDecorator class that works as "Decorator".
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
    __slots__ = ['_ice_cream_to_decorator']

    def __init__(self, ice_cream: IceCream):
        """
        Constructor with parameter.
        :param ice_cream: IceCream
        """
        super().__init__()
        self._ice_cream_to_decorator = ice_cream

    def make_ice_cream(self):
        self._ice_cream_to_decorator.make_ice_cream()


class IceCreamWithSprinkles(IceCreamDecorator):
    """
    IceCreamWithSprinkles class that works as one kind of "ConcreteDecorator".
    This class adds (decorates) sprinkles to an IceCream ("Component") object.
    """
    __slots__ = []

    def __init__(self, ice_cream: IceCream):
        """
        Constructor with parameter.
        :param ice_cream: IceCream
        """
        super().__init__(ice_cream)

    def make_ice_cream(self):
        original = self._ice_cream_to_decorator.make_ice_cream()
        print('Adding Sprinkles')
        original.add_topping('Sprinkles')
        return original


class IceCreamWithNuts(IceCreamDecorator):
    """
    IceCreamWithNuts class that works as one kind of "ConcreteDecorator".
    This class adds (decorates) nuts to an IceCream ("Component") object.
    """
    __slots__ = []

    def __init__(self, ice_cream: IceCream):
        """
        Constructor with parameter.
        :param ice_cream: IceCream
        """
        super().__init__(ice_cream)

    def make_ice_cream(self):
        original = self._ice_cream_to_decorator.make_ice_cream()
        print('Adding Nuts')
        original.add_topping('Nuts')
        return original
