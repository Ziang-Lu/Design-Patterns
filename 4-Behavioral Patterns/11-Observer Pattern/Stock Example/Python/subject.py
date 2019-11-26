#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Subject module.
"""

__author__ = 'Ziang Lu'

import weakref
from abc import ABC, abstractmethod
from threading import Condition

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
        self._my_observers.add(weakref.ref(observer))

    def unregister(self, observer) -> None:
        """
        Unregister the given observer.
        :param observer: Observer
        :return: None
        """
        to_remove = None
        for weak_ref in self._my_observers:
            if weak_ref() is observer:
                to_remove = weak_ref
                break
        self._my_observers.remove(to_remove)

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
    __slots__ = ['_prices', '_condition']

    COMPANY_INITIAL_PRICES = {Company.Google: 100.0, Company.Apple: 80.0}

    def __init__(self):
        """
        Default constructor.
        """
        super().__init__()
        self._prices = self.COMPANY_INITIAL_PRICES.copy()
        self._lock = Lock()

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
        Note that since the two threads share a common StockCenter object, so if
        we don't make this method synchronized:
        The two threads may write to StockCenter.prices at the same time,
        leading to an update to an observer within a thread containing two price
        changes, which violates our initial idea to let each thread handle only
        one price changing.
        Thus, we need to make this method synchronized, so that only after one
        thread finished making price changes (writing to StockCenter.prices) and
        notifying the observers about the price change, can the other thread do
        its price change.
        :param company: Company
        :param price: float
        :return: None
        """
        self._condition.acquire()
        try:
            self._prices[company] = price
            self._notify_observers()
        finally:
            self._condition.release()  # Ensure that the lock must be released

    def _notify_observers(self):
        for observer in self._my_observers:
            observer.update(self)
