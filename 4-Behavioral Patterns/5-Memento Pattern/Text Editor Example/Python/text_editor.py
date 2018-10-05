#!usr/bin/env python3
# -*- coding: utf-*-

"""
Text editor module.
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
    This is like a wrapper (a packing box) for the internal state of the
    "Originator" to be stored.
    """
    __slots__ = ['_text']

    def __init__(self, text: str):
        self._text = text

    @property
    def text(self) -> str:
        """
        Accessor of text.
        :return: str
        """
        return self._text

    def __repr__(self):
        return f'Memento [text={self._text}]'


class TextEditor(object):
    """
    TextEditor class that works as "Originator".
    """
    __slots__ = ['_text']

    def __init__(self):
        """
        Default constructor.
        """
        self._text = ''

    def set_text(self, text: str) -> None:
        """
        Mutator of text.
        :param text: str
        :return: None
        """
        self._text = text

    def create_memento(self) -> IMemento:
        """
        Creates a memento containing a snapshot of the internal state of this
        text editor.
        :return: IMemento
        """
        memo = Memento(self._text)
        print(f'Created a memento for TextEditor: {memo}')
        return memo

    def restore(self, memo: IMemento) -> None:
        """
        Restores the internal state of this text editor from the given memento.
        :param memo: IMemento
        :return: None
        """
        self._text = memo.text

    def __repr__(self):
        return f'TextEditor[text={self._text}]'
