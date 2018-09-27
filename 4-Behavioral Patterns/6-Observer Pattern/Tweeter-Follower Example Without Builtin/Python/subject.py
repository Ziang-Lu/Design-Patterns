#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Subject module.
"""

__author__ = 'Ziang Lu'

from abc import ABC, abstractmethod

from observer import Observer


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

    def register(self, observer: Observer) -> None:
        """
        Registers a new observer.
        :param observer: Observer
        :return: None
        """
        self._my_observers.add(observer)

    @abstractmethod
    def _notify_observers(self) -> None:
        """
        Notifies all observers about a state change.
        :return: None
        """
        pass


class Tweeter(Subject):
    """
    Tweeter class that works as "ConcreteSubject".
    """
    __slots__ = ['_name', '_latest_tweet']

    def __init__(self, name: str):
        """
        Constructor with parameter.
        :param name: str
        """
        super().__init__()
        self._name = name

    @property
    def name(self) -> str:
        """
        Accessor of name.
        :return: str
        """
        return self._name

    @property
    def latest_tweet(self) -> str:
        """
        Accessor of latest_tweet.
        :return: str
        """
        return self._latest_tweet

    def write_tweeter(self) -> None:
        """
        Writes a new tweet and notifies all the observers.
        :return: None
        """
        self._latest_tweet = 'A wonderful way with my family!'
        print(f'{self._name}: I wrote a new tweet: {self._latest_tweet}')
        self._notify_observers()

    def _notify_observers(self):
        for observer in self._my_observers:
            observer.update(self)
