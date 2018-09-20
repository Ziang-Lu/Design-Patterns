#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Product module.
"""

__author__ = 'Ziang Lu'

from abc import ABC


class Letter(ABC):
    """
    Abstract product Letter class.
    """
    __slots__ = []


class FancyLetter(Letter):
    """
    Concrete product FancyLetter class.
    """
    __slots__ = []

    def __repr__(self):
        return 'This is a FANCY LETTER.'


class ModernLetter(Letter):
    """
    Concrete product ModernLetter class.
    """
    __slots__ = []

    def __repr__(self):
        return 'This is a MODERN LETTER.'


class Resume(ABC):
    """
    Abstract product Resume class.
    """
    __slots__ = []


class FancyResume(Resume):
    """
    Concrete product FancyResume class.
    """
    __slots__ = []

    def __repr__(self):
        return 'This is a FANCY RESUME.'


class ModernResume(Resume):
    """
    Concrete product ModernResume class.
    """
    __slots__ = []

    def __repr__(self):
        return 'This is a MODERN RESUME.'
