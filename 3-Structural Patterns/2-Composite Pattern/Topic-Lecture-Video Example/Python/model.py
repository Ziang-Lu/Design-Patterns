#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Model module.
"""

__author__ = 'Ziang Lu'

from abc import ABC, abstractmethod


class Module(ABC):
    """
    Abstract Module class that works as "Component".
    """
    __slots__ = ['_title']

    def __init__(self, title: str):
        """
        Constructor with parameter.
        :param title: str
        """
        self._title = title

    @abstractmethod
    def display(self, indent_level: str) -> None:
        """
        Displays this module.
        :param indent_level: str
        :return: None
        """
        pass


class Topic(Module):
    """
    Topic class that works as "Composite".
    The "Composite" models nodes with children in the hierarchical structure.
    However, since both "Composite" and "Leaf" inherit from the super class
    "Component", "Composite" does not need to keep track of its children's
    actual type, but only need to keep track of a collection of the abstract
    "Component" as its contents.
    Without the abstract "Component" super class abstraction, "Component" would
    have to maintain different lists for each kind of element in its contents,
    and would need to provide separate method for each kind of element.
    """
    __slots__ = ['_modules']

    def __init__(self, title: str):
        """
        Constructor with parameter.
        :param title: str
        """
        super().__init__(title)
        self._modules = []

    def display(self, indent_level: str) -> None:
        print(indent_level + 'Topic - ' + self._title)
        for submodule in self._modules:
            submodule.display(indent_level + indent_level)

    def add_module(self, module: Module) -> None:
        """
        Adds the given module to the submodules of this topic.
        :param module: Module
        :return: None
        """
        self._modules.append(module)


class Lecture(Module):
    """
    Lecture class that works as one kind of "Leaf".
    """
    __slots__ = []

    def __init__(self, title: str):
        """
        Constructor with parameter.
        :param title: str
        """
        super().__init__(title)

    def display(self, indent_level: str) -> None:
        print(indent_level + 'Lecture - ' + self._title)


class Video(Module):
    """
    Video class that works as one kind of "Leaf".
    """
    __slots__ = []

    def __init__(self, title: str):
        """
        Constructor with parameter.
        :param title: str
        """
        super().__init__(title)

    def display(self, indent_level):
        print(indent_level + 'Video - ' + self._title)
