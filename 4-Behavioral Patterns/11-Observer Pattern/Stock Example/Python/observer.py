#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Observer module.
"""

__author__ = 'Ziang Lu'

from abc import ABC, abstractmethod
from threading import current_thread

from company import Company, process_company_name
from subject import StockCenter, Subject


class Observer(ABC):
    """
    Abstract Observer class.
    """
    __slots__ = []

    @abstractmethod
    def update(self, subject: Subject) -> None:
        """
        Gets notified with an update from some subject.
        :param subject: Subject
        :return: None
        """
        pass


class StockHolder(Observer):
    """
    StockHolder class that works as "ConcreteObserver".
    """
    __slots__ = [
        '_my_observer_id', '_stock', '_stock_latest_price', '__weakref__'
    ]
    # In order to create weak references to StockHolder objects, we need to
    # include a '__weakref__' slot, or Python will throw "TypeError: cannot
    # create weak reference to 'StockHolder' object"

    _observer_id = 0

    def __init__(self, stock: Company):
        """
        Constructor with parameter.
        :param stock:
        """
        StockHolder._observer_id += 1
        self._my_observer_id = StockHolder._observer_id
        self._stock = stock
        self._stock_latest_price = StockCenter.COMPANY_INITIAL_PRICES[stock]

    def follow(self, stock_center: StockCenter) -> None:
        """
        Follows the given stock center.
        :param stock_center: StockCenter
        :return: None
        """
        stock_center.register(self)

    def unfollow(self, stock_center: StockCenter) -> None:
        """
        Unfollows the given stock center.
        :param stock_center: StockCenter
        :return: None
        """
        stock_center.unregister(self)

    def update(self, subject):
        stock_center = subject
        curr_price = stock_center.get_price(self._stock)
        if curr_price != self._stock_latest_price:
            print(f'{current_thread().name} {type(self).__name__} (ID: '
                  f'{self._my_observer_id}) got an update on '
                  f'{process_company_name(self._stock)} Price: '
                  f'{curr_price:.2f}')
            self._stock_latest_price = curr_price
