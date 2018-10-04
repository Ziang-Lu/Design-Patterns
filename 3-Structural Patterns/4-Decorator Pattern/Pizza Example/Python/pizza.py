#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Pizza module.
"""

__author__ = 'Ziang Lu'

from abc import ABC, abstractmethod


class Pizza(ABC):
    """
    Abstract Pizza class that works as "Component".
    """
    __slots__ = []

    @abstractmethod
    def get_description() -> str:
        """
        Returns the description of this pizza.
        :return: str
        """
        pass

    @abstractmethod
    def get_price() -> float:
        """
        Returns the price of this pizza.
        :return: float
        """
        pass


class PlainPizza(Pizza):
    """
    PlainPizza class that works as one kind of "ConcreteComponent".
    """
    __slots__ = []

    def __init__(self):
        """
        Default constructor.
        """
        print('Adding thin dough')

    def get_description(self):
        return 'Thin Dough'

    def get_price(self):
        print('Cost of Plain Pizza: $8.0')
        return 8.0


class PizzaDecorator(Pizza):
    """
    Abstract PizzaDecorator class that works as "Decorator".
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
    __slots__ = ['_pizza_to_decorate']

    def __init__(self, pizza: Pizza):
        """
        Constructor with parameter.
        :param pizza: Pizza
        """
        self._pizza_to_decorate = pizza
        # Dynamically customize and add functionality to this Pizza instance,
        # which could either be a PlainPizza or some other PizzaDecorator.

    def get_description(self):
        return self._pizza_to_decorate.get_description()

    def get_price(self):
        return self._pizza_to_decorate.get_price()


class PizzaWithMozzarella(PizzaDecorator):
    """
    PizzaWithMozzarella class that works as one kind of "ConcreteDecorator".
    This class adds (decorates) mozzarella cheese to a Pizza ("Component")
    object.
    """
    __slots__ = []

    def __init__(self, pizza: Pizza):
        """
        Constructor with parameter.
        :param pizza: Pizza
        """
        super().__init__(pizza)
        print('Adding mozzarella cheese')

    def get_description(self):
        # Returns the decorated Pizza after adding mozzarella cheese to it
        return self._pizza_to_decorate.get_description() + ', Mozzarella Cheese'

    def get_price(self):
        print('Cost of Mozzarella Cheese: $1.0')
        # Returns the cost of the decorated Pizza after adding mozzarella cheese
        # to it
        return self._pizza_to_decorate.get_price() + 1.0


class PizzaWithTomatoSauce(PizzaDecorator):
    """
    PizzaWithTomatoSauce clas that works as one kind of
    "ConcreteDecorator".
    This class adds (decorates) tomato sauce to Pizza ("Component") object.
    """
    __slots__ = []

    def __init__(self, pizza: Pizza):
        """
        Constructor with parameter.
        :param pizza: Pizza
        """
        super().__init__(pizza)
        print('Adding tomato sauce')

    def get_description(self):
        # Returns the decorated Pizza after adding tomato sauce to it
        return self._pizza_to_decorate.get_description() + ', Tomato Sauce'

    def get_price(self):
        print('Cost of Tomato Sauce: $0.5')
        # Returns the cost of the decorated Pizza after adding tomato sauce to
        # it
        return self._pizza_to_decorate.get_price() + 0.5
