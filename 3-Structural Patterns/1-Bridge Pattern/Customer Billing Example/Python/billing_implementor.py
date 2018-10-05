#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Billing implementor module.
"""

__author__ = 'Ziang Lu'

from abc import ABC, abstractmethod


class BillingImplementor(ABC):
    """
    Abstract billing implementor class that works as "Implementor" to define the
    methods that the concrete implementation classes must implement.
    This class acts as a bridge between the abstraction layer and the concrete
    implementation classes.
    """
    __slots__ = []

    @abstractmethod
    def get_actual_price(self, raw_price: float) -> float:
        """
        Calculates the actual price from the given raw price according to this
        billing implementor.
        :param raw_price: float
        :return: float
        """
        pass


class NormalBillingImplementor(BillingImplementor):
    """
    Concrete NormalBillingImplementor class that works as "ConcreteImplementor"
    to get the actual price using normal billing implementor.
    This class is implemented as a singleton class.
    """

    @classmethod
    def get_instance(cls):
        """
        Gets the singleton instance.
        :return: NormalBillingImplementor
        """
        return cls.__new__(cls)

    def __new__(cls, *args, **kwargs):
        if not hasattr(cls, '_instance'):
            cls._instance = super().__new__(cls)
        return cls._instance

    def get_actual_price(self, raw_price):
        return raw_price


class HappyHourBillingImplementor(BillingImplementor):
    """
    Concrete HappyHourBillingImplementor class that works as
    "ConcreteImplementor" to get the actual price using normal billing
    implementor.
    This class is implemented as a singleton class.
    """

    @classmethod
    def get_instance(cls):
        """
        Gets the singleton instance.
        :return: NormalBillingImplementor
        """
        return cls.__new__(cls)

    def __new__(cls, *args, **kwargs):
        if not hasattr(cls, '_instance'):
            cls._instance = super().__new__(cls)
        return cls._instance

    def get_actual_price(self, raw_price):
        # 50% discount
        return raw_price * 0.5
