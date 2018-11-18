#!usr/bin/env python3
# -*- coding: utf-*-

"""
Text editor module.
"""

__author__ = 'Ziang Lu'


class Memento:
    """
    Memento class.
    This class holds a snapshot of the internal state of the "Originator".
    This is like a wrapper (a packing box) for the internal state of the
    "Originator" to be stored.
    """
    __slots__ = ['_text']

    def __init__(self, text: str):
        """
        Constructor with parameter.
        :param text: str
        """
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


class TextEditor:
    """
    TextEditor class that works as "Originator".
    """
    __slots__ = ['_text']

    def __init__(self):
        """
        Default constructor.
        """
        self._text = ''

    @property
    def text(self) -> str:
        """
        Accessor of text.
        :return: str
        """
        return self._text

    @text.setter
    def text(self, text: str) -> None:
        """
        Mutator of text.
        :param text: str
        :return: None
        """
        self._text = text

    def create_memento(self) -> Memento:
        """
        Creates a memento containing a snapshot of the internal state of this
        text editor.
        :return: Memento
        """
        memo = Memento(self._text)
        print(f'Created a memento for TextEditor: {memo}')
        return memo

    def restore(self, memo: Memento) -> None:
        """
        Restores the internal state of this text editor from the given memento.
        :param memo: Memento
        :return: None
        """
        self._text = memo.text

    def __repr__(self):
        return f'TextEditor[text={self._text}]'
