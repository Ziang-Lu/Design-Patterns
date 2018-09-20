#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Button module.
"""

__author__ = 'Ziang Lu'


from abc import ABC, abstractmethod


class MyButton(ABC):
    """
    Abstract product MyButton class.
    """
    __slots__ = []

    @abstractmethod
    def paint(self) -> None:
        """
        Paints this button.
        :return: None
        """
        pass


class OsxButton(MyButton):
    """
    Concrete product OsxButton class.
    """
    __slots__ = []

    def paint(self):
        print('This is a MaxOSX button.')


class WinButton(MyButton):
    """
    Concrete product WinButton class.
    """
    __slots__ = []

    def paint(self):
        print('This is a Windows button.')
