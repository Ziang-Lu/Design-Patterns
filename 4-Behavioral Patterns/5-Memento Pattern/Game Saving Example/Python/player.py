#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Player module.
"""

__author__ = 'Ziang Lu'

from abc import ABC


class IMemento(ABC):
    """
    Abstract IMemento class that works as a mark interface for "Memento".
    In this way, all classes other than the "Originator" can only access
    "Memento" objects through this mark interface, so they will know nothing
    about the actual "Memento" objects.
    """
    __slots__ = []


class Memento(IMemento):
    """
    Memento class.
    This class holds a snapshot of the internal state of the "Originator".
    This is like a wrapper (a packing box) of the internal state of the
    "Originator".
    """
    __slots__ = ['_player_level', '_player_life']

    def __init__(self, level: int, life: float):
        """
        Constructor with parameter.
        :param level: int
        :param life: float
        """
        self._player_level = level
        self._player_life = life

    @property
    def player_level(self) -> int:
        return self._player_level

    @property
    def player_life(self) -> float:
        return self._player_life

    def __repr__(self):
        return f'Memento [player_level={self._player_level}, ' \
               f'player_life={self._player_life}]'


class Player(object):
    """
    Player class that works as "Originator".
    """
    __slots__ = ['_level', '_life']

    _FULL_LIFE = 1.0
    _DAMAGE_PER = 0.1

    def __init__(self, level: int, life: float):
        """
        Constructor with parameter.
        :param level: int
        :param life: float
        """
        self._level = level
        self._life = life

    def succeed(self) -> None:
        """
        Succeeds a checkpoint.
        :return: None
        """
        self._level += 1
        self._life = self._FULL_LIFE

    def fail(self) -> None:
        """
        Fails a checkpoint.
        :return: None
        """
        self._life *= self._DAMAGE_PER

    def create_memento(self) -> Memento:
        """
        Creates a memento containing a snapshot of the internal state of this
        player.
        :return: Memento
        """
        memo = Memento(self._level, self._life)
        print(f'Created a memento for Player: {memo}')
        return memo

    def restore(self, memo: Memento) -> None:
        """
        Restores the internal state of this player from the given memento.
        :param memo: Memento
        :return: None
        """
        print(f'Player restoring to {memo}...')
        self._level = memo.player_level
        self._life = memo.player_life

    def __repr__(self):
        return f'Player[level={self._level}, life={self._life}]'
