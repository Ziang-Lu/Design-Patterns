#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Color module.
"""

__author__ = 'Ziang Lu'

from enum import Enum, auto


class Color(Enum):
    """
    Color enumeration.
    """
    BLACK = auto()
    GREEN = auto()
    ORANGE = auto()
    RED = auto()
    PURPLE = auto()


def process_color(color: Color) -> str:
    """
    Processes the given color.
    :param color: Color
    :return: str
    """
    color_str = str(color)
    dot = color_str.find('.')
    return color_str[dot + 1:]
