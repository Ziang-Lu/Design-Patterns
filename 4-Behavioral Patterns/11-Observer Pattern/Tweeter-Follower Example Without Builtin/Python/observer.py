#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Observer module.
"""

__author__ = 'Ziang Lu'

from abc import ABC, abstractmethod


class Observer(ABC):
    """
    Abstract Observer class.
    """
    __slots__ = []

    @abstractmethod
    def update(self, subject) -> None:
        """
        Gets notified with an update from some subject.
        :param subject: Subject
        :return: None
        """
        pass


class Follower(Observer):
    """
    Follower class that works as "ConcreteObserver".
    """
    __slots__ = ['_name', '__weakref__']
    # In order to create weak references to Follower objects, we need to include
    # a '__weakref__' slot.

    def __init__(self, name: str):
        """
        Constructor with parameter.
        :param name: str
        """
        self._name = name

    @property
    def name(self) -> str:
        """
        Accessor of name.
        :return: str
        """
        return self._name

    def follow(self, tweeter) -> None:
        """
        Follows the given tweeter.
        :param tweeter: Tweeter
        """
        print(f'{self._name}: Starting to follow {tweeter.name}')
        tweeter.register(self)

    def unfollow(self, tweeter) -> None:
        """
        Unfollows the given tweeter.
        :param tweeter: Tweeter
        """
        print(f'{self._name}: Stops to follow {tweeter.name}')
        tweeter.unregister(self)

    def update(self, subject):
        tweeter = subject
        print(f'{self._name}: I got an update from {tweeter.name} about a new '
              f'tweet: {tweeter.latest_tweet.content}')

    def __eq__(self, other):
        if not isinstance(other, Follower):
            return False
        return other.name == self._name

    def __hash__(self):
        return hash(self._name)
