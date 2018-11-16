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
    __slots__ = ['_username', '__weakref__']
    # In order to create weak references to Follower objects, we need to include
    # a '__weakref__' slot.

    def __init__(self, username: str):
        """
        Constructor with parameter.
        :param username: str
        """
        self._username = username

    @property
    def username(self) -> str:
        """
        Accessor of username.
        :return: str
        """
        return self._username

    def follow(self, tweeter) -> None:
        """
        Follows the given tweeter.
        :param tweeter: Tweeter
        """
        print(f'{self._username}: Starting to follow {tweeter.username}')
        tweeter.register(self)

    def unfollow(self, tweeter) -> None:
        """
        Unfollows the given tweeter.
        :param tweeter: Tweeter
        """
        print(f'{self._username}: Stops to follow {tweeter.username}')
        tweeter.unregister(self)

    def update(self, subject):
        tweeter = subject
        print(f'{self._username}: I got an update from {tweeter.username} about'
              f' a new tweet: {tweeter.latest_tweet}')

    def __eq__(self, other):
        if not isinstance(other, Follower):
            return False
        return other.username == self._username

    def __hash__(self):
        return hash(self._username)
