#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Factory module.
"""

__author__ = 'Ziang Lu'


from abc import ABC, abstractmethod

from product_button import MyButton, OsxButton, WinButton


class GuiFactory(ABC):
    """
    Abstract factory GuiFactory class.
    """
    __slots__ = []

    @abstractmethod
    def create_button(self) -> MyButton:
        """
        Abstract factory method to make an abstract product MyButton instance.
        However, the ability to determine which concrete type of MyButton
        product to instantiate is deferred to concrete factories (subclasses).
        :return: MyButton
        """
        pass


class OsxFactory(GuiFactory):
    """
    Concrete factory OsxFactory class.
    This class is implemented as a singleton class.
    """

    @classmethod
    def get_instance(cls):
        """
        Gets the singleton instance.
        :return: OsxFactory
        """
        return cls.__new__(cls)

    def __new__(cls, *args, **kwargs):
        if not hasattr(cls, '_instance'):
            cls._instance = super().__new__(cls)
        return cls._instance

    def create_button(self):
        return OsxButton()


class WinFactory(GuiFactory):
    """
    Concrete factory WinFactory class.
    This class is implemented as a singleton class.
    """

    @classmethod
    def get_instance(cls):
        """
        Gets the singleton instance.
        :return: WinFactory
        """
        return cls.__new__(cls)

    def __new__(cls, *args, **kwargs):
        if not hasattr(cls, '_instance'):
            cls._instance = super().__new__(cls)
        return cls._instance

    def create_button(self):
        return WinButton()
