#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Living room module.
"""

__author__ = 'Ziang Lu'

import copy


class LedTV(object):
    __slots__ = ['_size', '_usb_support', '_price']

    def __init__(self, size: int, usb_support: bool, price: float):
        """
        Constructor with parameter.
        :param size: int
        :param usb_support: bool
        :param price: float
        """
        self._size = size
        self._usb_support = usb_support
        self._price = price

    def __repr__(self):
        return f'LedTV[size={self._size}, usb_support={self._usb_support}, ' \
               f'price={self._price}]'


class Sofa(object):
    __slots__ = ['_size', '_style']

    def __init__(self, size: int, style: str):
        """
        Constructor with parameter.
        :param size: int
        :param style: str
        """
        self._size = size
        self._style = style

    def __repr__(self):
        return f'Sofa[size={self._size}, style={self._style}]'


class Memento(object):
    """
    Memento class.
    This class holds a snapshot of the internal state of the "Originator".
    This is like a wrapper (a packing box) of the internal state of the
    "Originator".
    """
    __slots__ = ['_led_tv', '_sofa']

    def __init__(self, lev_tv: LedTV, sofa: Sofa):
        """
        Constructor with parameter.
        :param lev_tv: LedTV
        :param sofa: Sofa
        """
        self._led_tv = lev_tv
        self._sofa = sofa

    @property
    def led_tv(self) -> LedTV:
        """
        Accessor of led_tv.
        :return: LedTV
        """
        return self._led_tv

    @property
    def sofa(self) -> Sofa:
        """
        Accessor of sofa.
        :return: Sofa
        """
        return self._sofa

    def __repr__(self):
        return f'Memento [led_tv={self._led_tv}, sofa={self._sofa}]'


class LivingRoom(object):
    """
    LivingRoom class that works as "Originator".
    """
    __slots__ = ['_led_tv', '_sofa']

    def __init__(self):
        """
        Default constructor.
        """
        self._led_tv = None
        self._sofa = None

    def set_led_tv(self, led_tv: LedTV) -> None:
        """
        Mutator of led_tv.
        :param led_tv: LedTV
        :return:
        """
        self._led_tv = led_tv

    def set_sofa(self, sofa: Sofa) -> None:
        """
        Mutator of sofa.
        :param sofa: Sofa
        :return:
        """
        self._sofa = sofa

    def create_memento(self) -> Memento:
        """
        Creates a memento containing a snapshot of the internal state of this
        living room.
        :return: Memento
        """
        memo = Memento(copy.deepcopy(self._led_tv), copy.deepcopy(self._sofa))
        print(f'Created a memento for Living Room: {memo}')
        return memo

    def restore(self, memo: Memento) -> None:
        """
        Restores the internal state of this living room from the given memento.
        :param memo: Memento
        :return: None
        """
        self._led_tv = memo.led_tv
        self._sofa = memo.sofa

    def __repr__(self):
        return f'LivingRoom[led_tv={self._led_tv}, sofa={self._sofa}]'
