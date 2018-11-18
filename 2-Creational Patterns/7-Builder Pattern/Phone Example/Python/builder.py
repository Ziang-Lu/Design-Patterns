#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Builder module.
"""

__author__ = 'Ziang Lu'


class Phone:
    """
    My own modular phone class.
    This class is complex, and thus can be instantiated using Builder Pattern.
    """
    __slots__ = ['_os', '_processor', '_ram', '_screen_size', '_battery']

    def __init__(self, builder):
        """
        Constructor with parameter.
        :param builder: PhoneBuilder
        """
        self._os = builder.os
        self._processor = builder.processor
        self._ram = builder.ram
        self._screen_size = builder.screen_size
        self._battery = builder.battery

    def __repr__(self):
        return f'Phone [os={self._os}, processor={self._processor}, ' \
               f'ram={self._ram}, screen_size={self._screen_size}, ' \
               f'battery={self._battery}]'


class PhoneBuilder:
    """
    PhoneBuilder class that works as a factory, a blueprint, that defines the
    construction process for a phone, i.e., how to build a phone by creating and
    assembling all of its parts.
    """
    __slots__ = ['_os', '_processor', '_ram', '_screen_size', '_battery']

    def __init__(self):
        """
        Default constructor.
        """
        self._os = None
        self._processor = None
        self._ram = 0
        self._screen_size = 0.0
        self._battery = 0

    @property
    def os(self) -> str:
        """
        Accessor of the operating system.
        :return: str
        """
        return self._os

    def set_os(self, os: str):
        """
        Sets the operating system for a phone.
        :param os: str
        :return: PhoneBuilder
        """
        self._os = os
        return self

    @property
    def processor(self) -> str:
        """
        Accessor of processor.
        :return: str
        """
        return self._processor

    def set_processor(self, processor: str):
        """
        Sets the processor for a phone.
        :param processor: str
        :return: PhoneBuilder
        """
        self._processor = processor

    @property
    def ram(self) -> int:
        """
        Accessor of RAM.
        :return: int
        """
        return self._ram

    def set_ram(self, ram: int):
        """
        Sets the RAM for a phone.
        :param ram: int
        :return: PhoneBuilder
        """
        self._ram = ram
        return self

    @property
    def screen_size(self) -> float:
        """
        Accessor of screen_size.
        :return: float
        """
        return self._screen_size

    def set_screen_size(self, screen_size: float):
        """
        Sets the screen size for a phone.
        :param screen_size: float
        :return: PhoneBuilder
        """
        self._screen_size = screen_size
        return self

    @property
    def battery(self) -> int:
        """
        Accessor of battery.
        :return: int
        """
        return self._battery

    def set_battery(self, battery: int):
        """
        Sets the battery for a phone.
        :param battery: int
        :return: PhoneBuilder
        """
        self._battery = battery
        return self

    def get_phone(self) -> Phone:
        """
        Returns a finished phone built by this phone builder.
        :return: Phone
        """
        if self._os is None or self._ram <= 0:
            raise ValueError('Illegal phone state')
        return Phone(self)
