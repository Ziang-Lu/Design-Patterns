#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
BMW car module.
"""

__author__ = 'Ziang Lu'

from abc import ABC, abstractmethod

from flyweight.customization import BMWCarCustomization


class FlyweightBMWCar(ABC):
    """
    Abstract FlyweightBMWCar class that works as "Flyweight".
    This abstract class enables sharing but does not enforce it; it defines
    "operation(extrinsicState)" to customize a "ConcreteFlyweight" to a
    "UnsharedConcreteFlyweight".

    In this specific example, all of the extrinsic states are separately
    encapsulated in its own BMWCarCustomization class, so that when we want to
    customize our FlyweightBMWCar, we simply pass in a BMWCarCustomization
    object, which has all the extrinsic states we desire in it.
    """
    __slots__ = []

    def print_full_characteristics(self,
                                   customization: BMWCarCustomization) -> None:
        """
        Prints full characteristics of this car according to the given
        customization.
        :param customization: BMWCarCustomization
        :return: None
        """
        customization.print_customization()

    @abstractmethod
    def calc_price(self, customization: BMWCarCustomization) -> int:
        """
        Calculates the total price for this car according to the given
        customization.
        :param customization: BMWCarCustomization
        :return: int
        """
        pass

    @abstractmethod
    def _get_base_price(self) -> int:
        """
        Protected helper function to get the base price for this car (without
        customization).
        :return: int
        """
        pass


class BMWSeries1(FlyweightBMWCar):
    """
    Concrete BMWSeries1 class.
    This class first works as "ConcreteFlyweight", pre-defines all the intrinsic
    states (which are constant and context-independent).
    After customized with the given extrinsic states (which are NOT constant,
    context-dependent and needs to be calculated on the fly), this class would
    work as "UnsharedConcreteFlyweight".
    """
    __slots__ = []

    def calc_price(self, customization):
        # Base Series1 price
        price = self._get_base_price()

        # Add the additional price due to tire size specific to Series1
        if customization.tire_size == 19:
            price += 1200
        else:
            price += 2100

        # Add the additional price due to laser signature length specific to
        # Series1
        if len(customization.laser_signature):
            price += 987
        return price

    def _get_base_price(self):
        return 25000


class BMWSeries2(FlyweightBMWCar):
    """
    Concrete BMWSeries2 class.
    This class first works as "ConcreteFlyweight", pre-defines all the intrinsic
    states (which are constant and context-independent).
    After customized with the given extrinsic states (which are NOT constant,
    context-dependent and needs to be calculated on the fly), this class would
    work as "UnsharedConcreteFlyweight".
    """
    __slots__ = []

    def calc_price(self, customization):
        # Base Series2 price
        price = self._get_base_price()

        # Add the additional price due to tire size specific to Series2
        if customization.tire_size == 19:
            price += 2000
        else:
            price += 3000

        # Add the additional price due to laser signature length specific to
        # Series1
        laser_signature_length = len(customization.laser_signature)
        if laser_signature_length > 10:
            price += 1200
        elif laser_signature_length:
            price += 400
        return price

    def _get_base_price(self):
        return 28000
