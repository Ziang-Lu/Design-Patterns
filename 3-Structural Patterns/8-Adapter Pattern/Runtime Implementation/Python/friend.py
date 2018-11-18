#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Friend's stuff module.
"""

__author__ = 'Ziang Lu'


class InkPen:
    """
    InkPen class that works as "Adaptee".

    By comparing the signatures of ink() method and the Pen.write() method, we
    can find that this class and the Pen are independent or incompatible
    systems.
    """
    __slots__ = []

    def ink(self, text: str) -> None:
        """
        Inks the given text.
        :param text: str
        :return: None
        """
        print(f"'{text}' is written in Ink Pen.")


class PilotPen:
    """
    PilotPen class that works as "Adaptee".

    By comparing the signatures of mark() method and the Pen.write() method, we
    can find that this class and the Pen are independent or incompatible
    systems.
    """
    __slots__ = []

    def mark(self, text: str) -> None:
        """
        Marks the given context.
        :param text: str
        :return: None
        """
        print(f"'{text}' is written in Pilot Pen.")


class CorrectionTape:
    """
    CorrectionTape class that works as "Adaptee".

    By comparing the signatures of dash_out() method and the Eraser.erase()
    method, we can find that this class and the Eraser are independent or
    incompatible systems.
    """
    __slots__ = []

    def dash_out(self, text: str) -> None:
        """
        Dashes out the given text.
        :param text: str
        :return: None
        """
        print(f"'{text}' is dashed out by Correction Tape.")


class Tape:
    """
    Tape class that works as "Adaptee".

    By comparing the signatures of stick_out() method and the Eraser.erase()
    method, we can find that this class and the Eraser are independent or
    incompatible systems.
    """
    __slots__ = []

    def stick_out(self, text: str) -> None:
        print(f"'{text}' is stuck out by Tape.")
