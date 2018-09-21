#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Ice cream factory module.
"""

__author__ = 'Ziang Lu'

from abc import ABC, abstractmethod

from ice_cream import IceCream, VanillaIceCream


class IceCreamFactory(ABC):
    """
    Note that in this ice cream example, the different behaviors are in the
    object creation process, and within the different behaviors (methods), we
    are returning the newly created instances: thus, this example is somehow
    related to creational design patterns.
    Thus, we incorporate Factory Method Pattern, and some concepts of Abstract
    Factory Pattern and Builder Pattern, and implement this example with
    factories.

    Abstract factory IceCreamFactory class that works as "Component".
    """
    __slots__ = []

    @abstractmethod
    def make_ice_cream(self) -> IceCream:
        """
        Abstract factory method to make an abstract product IceCream instance.
        However, the ability to determine which concrete type of IceCream
        product to instantiate is deferred to concrete factories (subclasses).
        :return: IceCream
        """
        pass


class VanillaIceCreamFactory(IceCreamFactory):
    """
    Concrete factory VanillaIceCreamFactory that works as one kind of
    "ConcreteComponent".
    This class is implemented as a singleton class.
    """

    @classmethod
    def get_instance(cls):
        """
        Gets the singleton instance.
        :return: VanillaIceCreamFactory
        """
        return cls.__new__(cls)

    def __new__(cls, *args, **kwargs):
        if not hasattr(cls, '_instance'):
            cls._instance = super().__new__(cls)
        return cls._instance

    def make_ice_cream(self):
        print('Creating a Vanilla Ice Cream')
        return VanillaIceCream()


class IceCreamFactoryDecorator(IceCreamFactory):
    """
    Abstract IceCreamFactoryDecorator class that works as "Decorator".
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
    __slots__ = ['_ice_cream_factory_to_decorate']

    def __init__(self, ice_cream_factory: IceCreamFactory):
        """
        Constructor with parameter.
        :param ice_cream_factory: IceCreamFactory
        """
        self._ice_cream_factory_to_decorate = ice_cream_factory

    def make_ice_cream(self):
        return self._ice_cream_factory_to_decorate.make_ice_cream()


class IceCreamWithSprinklesFactory(IceCreamFactoryDecorator):
    """
    IceCreamWithSprinklesFactory class that works as one kind of
    "ConcreteDecorator".
    This class adds (decorates) sprinkles to an IceCream object created from an
    IceCreamFactory ("Component") object.

    Note that this class shouldn't be implemented as a singleton class since
    we may create multiple instances of this class to decorate different
    IceCreamFactory objects
    """
    __slots__ = []

    def __init__(self, ice_cream_factory: IceCreamFactory):
        """
        Constructor with parameter.
        :param ice_cream_factory: IceCreamFactory
        """
        super().__init__(ice_cream_factory)

    def make_ice_cream(self):
        original = self._ice_cream_factory_to_decorate.make_ice_cream()
        print('Adding Sprinkles')
        original.add_topping('Sprinkles')
        return original


class IceCreamWithNutsFactory(IceCreamFactoryDecorator):
    """
    IceCreamWithNutsFactory class that works as one kind of "ConcreteDecorator".
    This class adds (decorates) nuts to an IceCream object created from an
    IceCreamFactory ("Component") object.

    Note that this class shouldn't be implemented as a singleton class since
    we may create multiple instances of this class to decorate different
    IceCreamFactory objects
    """
    __slots__ = []

    def __init__(self, ice_cream_factory: IceCreamFactory):
        """
        Constructor with parameter.
        :param ice_cream_factory: IceCreamFactory
        """
        super().__init__(ice_cream_factory)

    def make_ice_cream(self):
        original = self._ice_cream_factory_to_decorate.make_ice_cream()
        print('Adding Nuts')
        original.add_topping('Nuts')
        return original
