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
    __slots__ = ['_name']

    def __init__(self, name: str):
        self._name = name

    @property
    def name(self) -> str:
        return self._name

    def update(self, subject):
        tweeter = subject
        print(f'{self._name}: I got an update from {tweeter.name} about a new '
              f'tweet: {tweeter.latest_tweet}')

    def __eq__(self, other):
        if not isinstance(other, Follower):
            return False
        return other.name == self._name

    def __hash__(self):
        return hash(self._name)
