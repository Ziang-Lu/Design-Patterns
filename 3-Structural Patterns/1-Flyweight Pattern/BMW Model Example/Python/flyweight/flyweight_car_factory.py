#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Flyweight BMW car factory module.
"""

__author__ = 'Ziang Lu'

from enum import Enum, auto

from flyweight.car import FlyweightBMWCar
from flyweight.car_factory import BMWSeries1Factory, BMWSeries2Factory


class Model(Enum):
    """
    BMW model enumeration.
    """
    Series1 = auto()
    Series2 = auto()


class FlyweightBMWCarFactory(object):
    """
    FlyweightBMWCarFactory class that actually uses Flyweight Pattern.
    Flyweight Pattern stores already existing similar objects
    ("ConcreteFlyweight") in a cache, so that they can easily be used (shared),
    and creates a new object only when no matching object is found.

    This class is implemented as a singleton class.
    """

    @classmethod
    def get_instance(cls):
        """
        Gets the singleton instance.
        :return: FlyweightBMWCarFactory
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
        self._flyweight_models = {}

    def get_flyweight_bmw_car(self, model: Model) -> FlyweightBMWCar:
        """
        Gets the flyweight car of the given model.
        :param model: Model
        :return: FlyweightBMWCar
        """
        if model not in self._flyweight_models:
            if model == Model.Series1:
                bmw_car_factory = BMWSeries1Factory()
            else:
                bmw_car_factory = BMWSeries2Factory()
            self._flyweight_models[model] = bmw_car_factory.create_car()
        return self._flyweight_models[model]
