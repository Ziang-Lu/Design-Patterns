#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Subject module.
"""

__author__ = 'Ziang Lu'

import weakref
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
        self._my_observers.add(weakref.ref(observer))

    def unregister(self, observer: Observer) -> None:
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


class Tweeter(Subject):
    """
    Tweeter class that works as "ConcreteSubject".
    """
    __slots__ = ['_username', '_latest_tweet']

    def __init__(self, username: str):
        """
        Constructor with parameter.
        :param username: str
        """
        super().__init__()
        self._username = username

    @property
    def username(self) -> str:
        """
        Accessor of username.
        :return: str
        """
        return self._username

    @property
    def latest_tweet(self) -> str:
        """
        Accessor of latest_tweet.
        :return: str
        """
        return self._latest_tweet

    def write_tweet(self) -> None:
        """
        Writes a new tweet and notifies all the observers.
        :return: None
        """
        self._latest_tweet = 'A wonderful way with my family!'
        print(f'{self._username}: I wrote a new tweet: {self._latest_tweet}')
        self._notify_observers()

    def _notify_observers(self):
        for weak_ref in self._my_observers:
            observer = weak_ref()
            if observer:
                observer.update(self)
