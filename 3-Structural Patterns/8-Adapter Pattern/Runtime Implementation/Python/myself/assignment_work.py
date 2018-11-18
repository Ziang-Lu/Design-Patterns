#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Assignment work module.
"""

__author__ = 'Ziang Lu'

from abc import ABC, abstractmethod


class Pen(ABC):
    """
    Abstract Pen class that works as "Target".

    By comparing the signatures of write() method and the
    InkPen.ink()/PilotPen.mark() method, we can find that this interface and the
    InkPen/PilotPen are independent or incompatible systems.
    """
    __slots__ = []

    @abstractmethod
    def write(self, text: str) -> None:
        """
        Writes the given text using this pen.
        :param text: str
        :return: None
        """
        pass


class Eraser(ABC):
    """
    Abstract Eraser class that works as "Target".

    By comparing the signatures of erase() method and the
    CorrectionType.ink()/Tape.mark() method, we can find that this interface and
    the CorrectionType/Tape are independent or incompatible systems.
    """
    __slots__ = []

    @abstractmethod
    def erase(self, text: str) -> None:
        """
        Erases the given text using this eraser.
        :param text: str
        :return: None
        """
        pass


class AssignmentWork:
    __slots__ = ['_pen', '_eraser']

    def __init__(self):
        """
        Default constructor.
        """
        self._pen = None
        self._eraser = None

    def set_pen(self, pen: Pen) -> None:
        """
        Mutator of pen.
        :param pen: Pen
        :return: None
        """
        self._pen = pen

    def set_eraser(self, eraser: Eraser) -> None:
        """
        Mutator of eraser.
        :param eraser: Eraser
        :return: None
        """
        self._eraser = eraser

    def do_assignment(self, text: str) -> None:
        """
        Does this assignment by writing the given text.
        :param text: str
        :return: None
        """
        self._pen.write(text)

    def erase_content(self, text: str) -> None:
        """
        Erases the given text in this assignment.
        :param text: str
        :return: None
        """
        self._eraser.erase(text)
