#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Color module.
"""

from enum import Enum, auto


class Color(Enum):
    """
    Color enumeration module.
    """
    BLACK = auto()
    BLUE = auto()
    GRAY = auto()
    GREEN = auto()
    ORANGE = auto()
    RED = auto()
    PURPLE = auto()
    VERDANT = auto()
    WHITE = auto()
    YELLOW = auto()


def process_color(color: Color) -> str:
    """
    Processes the given color.
    :param color: Color
    :return: str
    """
    color_str = str(color)
    dot = color_str.find('.')
    return color_str[dot + 1:]
