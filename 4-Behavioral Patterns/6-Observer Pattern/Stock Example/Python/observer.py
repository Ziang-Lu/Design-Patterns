#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Observer module.
"""

__author__ = 'Ziang Lu'

from abc import ABC, abstractmethod

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
    _observer_id = 0

    __slots__ = ['_my_observer_id', '_stock', '_latest_price']

    def __init__(self, stock: Company):
        """
        Constructor with parameter.
        :param stock:
        """
        StockHolder._observer_id += 1
        self._my_observer_id = StockHolder._observer_id
        self._stock = stock
        self._latest_price = StockCenter.COMPANY_INITIAL_PRICES[stock]

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
        if curr_price != self._latest_price:
            print(f'{type(self).__name__} (ID: {self._my_observer_id}) got an '
                  f'update on {process_company_name(self._stock)} Price: '
                  f'{curr_price:.2f}')
            self._latest_price = curr_price
