#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Strategy module.
"""

__author__ = 'Ziang Lu'

from abc import ABC, abstractmethod


class BillingStrategy(ABC):
    """
    Abstract billing strategy interface to define the getting actual price task
    to perform (getting actual price problem to solve).
    """
    __slots__ = []

    @abstractmethod
    def get_actual_price(self, raw_price: float) -> float:
        """
        Calculates the actual price from the given raw price according to the
        current billing strategy.
        :return: float
        """
        pass


class NormalBillingStrategy(BillingStrategy):
    """
    Concrete NormalBillingStrategy to perform the getting actual price task
    (solve the getting actual price problem) using the normal billing strategy.
    This class is implemented as a singleton class.
    """

    @classmethod
    def get_instance(cls):
        """
        Gets the singleton instance.
        :return: NormalBillingStrategy
        """
        return cls.__new__(cls)

    def __new__(cls, *args, **kwargs):
        if not hasattr(cls, '_instance'):
            cls._instance = super().__new__(cls)
        return cls._instance

    def get_actual_price(self, raw_price):
        return raw_price


class HappyHourBillingStrategy(BillingStrategy):
    """
    Concrete HappyHourBillingStrategy to perform the getting actual price task
    (solve the getting actual price problem) using the happy hour billing
    strategy.
    This class is implemented as a singleton class.
    """

    @classmethod
    def get_instance(cls):
        """
        Gets the singleton instance.
        :return: HappyHourBillingStrategy
        """
        return cls.__new__(cls)

    def __new__(cls, *args, **kwargs):
        if not hasattr(cls, '_instance'):
            cls._instance = super().__new__(cls)
        return cls._instance

    def get_actual_price(self, raw_price):
        # 50% discount
        return raw_price * 0.5
