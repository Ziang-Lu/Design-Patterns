#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
BMW car factory module.
"""

__author__ = 'Ziang Lu'

from abc import ABC, abstractmethod

from flyweight.car import BMWSeries1, BMWSeries2, FlyweightBMWCar


class BMWCarFactory(ABC):
    """
    Abstract factory BMWCarFactory class.
    """
    __slots__ = []

    @abstractmethod
    def create_car(self) -> FlyweightBMWCar:
        """
        Abstract factory method to make an abstract product FlyweightBMWCar
        instance.
        However, the ability to determine which concrete type of FlyweightBMWCar
        product to instantiate is deferred to concrete factories (subclasses).
        :return: FlyweightBMWCar
        """
        pass


class BMWSeries1Factory(BMWCarFactory):
    """
    Concrete factory BMWSeries1Factory class.
    This class is implemented as a singleton class.
    """

    @classmethod
    def get_instance(cls):
        """
        Gets the singleton instance.
        :return: BMWSeries1Factory
        """
        return cls.__new__(cls)

    def __new__(cls, *args, **kwargs):
        if not hasattr(cls, '_instance'):
            cls._instance = super().__new__(cls)
        return cls._instance

    def create_car(self):
        return BMWSeries1()


class BMWSeries2Factory(BMWCarFactory):
    """
    Concrete factory BMWSeries2Factory class.
    This class is implemented as a singleton class.
    """

    @classmethod
    def get_instance(cls):
        """
        Gets the singleton instance.
        :return: BMWSeries1Factory
        """
        return cls.__new__(cls)

    def __new__(cls, *args, **kwargs):
        if not hasattr(cls, '_instance'):
            cls._instance = super().__new__(cls)
        return cls._instance

    def create_car(self):
        return BMWSeries2()
