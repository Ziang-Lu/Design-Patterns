#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Subject module.
"""

__author__ = 'Ziang Lu'

import weakref
from abc import ABC, abstractmethod
from datetime import datetime

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


class Tweet:
    """
    Tweet class.
    """
    __slots__ = ['_timestamp', '_content']

    def __init__(self, content: str):
        """
        Constructor with parameter.
        :param content: str
        """
        self._timestamp = datetime.now()
        self._content = content

    @property
    def content(self) -> str:
        """
        Accessor of content.
        :return: str
        """
        return self._content

    def __repr__(self) -> str:
        return f'{self._timestamp} -> {self._content}'


class Tweeter(Subject):
    """
    Tweeter class that works as "ConcreteSubject".
    """
    __slots__ = ['_name', '_tweet_history']

    def __init__(self, name: str):
        """
        Constructor with parameter.
        :param name: str
        """
        super().__init__()
        self._name = name
        self._tweet_history = []

    @property
    def name(self) -> str:
        """
        Accessor of name.
        :return: str
        """
        return self._name

    @property
    def latest_tweet(self) -> Tweet:
        """
        Returns the latest tweet.
        :return: Tweet
        """
        return self._tweet_history[-1]

    def write_tweet(self, content: str) -> None:
        """
        Writes a new tweet and notifies all the observers.
        :param content: str
        :return: None
        """
        self._tweet_history.append(Tweet(content))
        print(f'{self._name}: I wrote a new tweet: {content}')
        self._notify_observers()

    def _notify_observers(self):
        for weak_ref in self._my_observers:
            observer = weak_ref()
            if observer:
                observer.update(self)
