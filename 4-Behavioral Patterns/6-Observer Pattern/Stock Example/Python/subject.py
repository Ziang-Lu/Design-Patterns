#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Subject module.
"""

__author__ = 'Ziang Lu'

from abc import ABC, abstractmethod

from company import Company


class Subject(ABC):
    """
    Abstract Subject class.
    """
    __slots__ = ['_my_observers']

    def __init__(self):
        """
        Default constructor.
        """
        self._my_observers = set()

    def register(self, observer) -> None:
        """
        Registers a new observer.
        :param observer: Observer
        :return: None
        """
        self._my_observers.add(observer)

    def unregister(self, observer) -> None:
        """
        Unregister the given observer.
        :param observer: Observer
        :return: None
        """
        if observer in self._my_observers:
            self._my_observers.remove(observer)

    @abstractmethod
    def _notify_observers(self) -> None:
        """
        Notifies all observers about a state change.
        :return: None
        """
        pass


class StockCenter(Subject):
    """
    StockCenter class that works as "ConcreteSubject".
    """
    __slots__ = ['_prices']

    COMPANY_INITIAL_PRICES = {Company.Google: 100.0, Company.Apple: 80.0}

    def __init__(self):
        """
        Default constructor.
        """
        super().__init__()
        self._prices = self.COMPANY_INITIAL_PRICES.copy()

    def get_price(self, company: Company) -> float:
        """
        Gets the current price for the given company.
        :param company: Company
        :return: float
        """
        return self._prices[company]

    def set_price(self, company: Company, price: float) -> None:
        """
        Sets the price for the given company.
        :param company: Company
        :param price: float
        :return:
        """
        self._prices[company] = price
        self._notify_observers()

    def _notify_observers(self):
        for observer in self._my_observers:
            observer.update(self)
