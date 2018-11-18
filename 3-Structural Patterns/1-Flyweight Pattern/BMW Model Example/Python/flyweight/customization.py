#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
BMW car customization module.
"""

__author__ = 'Ziang Lu'


class BMWCarCustomization:
    """
    BMWCarCustomization class.
    This class encapsulates all the extrinsic states for a FlyweightBMWCar.
    """
    __slots__ = ['_tire_size', '_laser_signature']

    def __init__(self, tire_size: int, laser_signature: str):
        """
        Constructor with parameter.
        :param tire_size: int
        :param laser_signature: str
        """
        self._tire_size = tire_size
        self._laser_signature = laser_signature

    @property
    def tire_size(self) -> int:
        """
        Accessor of tire_size.
        :return: int
        """
        return self._tire_size

    @property
    def laser_signature(self) -> str:
        """
        Accessor of laser_signature.
        :return: str
        """
        return self._laser_signature

    def print_customization(self) -> None:
        """
        Prints this customization.
        :return: None
        """
        print(f'Tire Size: {self._tire_size}')
        print(f'Laser Signature: {self._laser_signature}')
        print(f'Laser Signature: {len(self._laser_signature)}')
