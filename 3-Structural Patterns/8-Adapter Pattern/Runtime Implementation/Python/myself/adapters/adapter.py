#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Adapter and adapters factory module.
"""

__author__ = 'Ziang Lu'

from abc import ABC, abstractmethod


class Adapter(ABC):
    """
    Abstract Adapter class.
    An adapters adapts an object from some interface to an object of another
    interface, and these two interfaces are otherwise independent or
    incompatible.
    """
    __slots__ = []

    @abstractmethod
    def adapt(self, from_: object) -> object:
        """
        Adapts the given object of some interface to an object of another
        interface, and these two interfaces are otherwise independent or
        incompatible.
        :param from_: object
        :return: object
        """
        pass


class AdapterFactory:
    """
    AdapterFactory class.
    Through the use of an adapters factory, we can achieve runtime looking up and
    get the required adapters.
    This class is implemented as a singleton class.
    """

    @classmethod
    def get_instance(cls):
        """
        Gets the singleton instance.
        :return: AdapterFactory
        """
        return cls.__new__(cls)

    def __new__(cls, *args, **kwargs):
        if not hasattr(cls, '_instance'):
            cls._instance = super().__new__(cls)
            cls._instance.__init__()
        return cls._instance

    def __init__(self):
        self._adapters_map = {}
        # Registered adapters

    def register_adapter(self, from_: type, to: type, adapter: Adapter) -> None:
        """
        Registers the given adapters, which adapts an object of "from" class to
        an object of "to" class (and these classes are otherwise independent or
        incompatible) using the given adapters.
        :param from_: type
        :param to: type
        :param adapter: Adapter
        :return: None
        """
        from_map = self._adapters_map.get(from_, {})
        from_map[to] = adapter
        self._adapters_map[from_] = from_map

    def get_adapter_from_to(self, from_: type, to: type) -> Adapter:
        """
        Looks up and gets an adapters at runtime which adapts an object of "from"
        class to an object of "to" class, and these two class are otherwise
        independent or incompatible.
        :param from_: type
        :param to: type
        :return: Adapter
        """
        return self._adapters_map[from_][to]()
