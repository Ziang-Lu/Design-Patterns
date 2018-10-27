#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Car module.
"""

__author__ = 'Ziang Lu'

from abc import ABC, abstractmethod


class Car(ABC):
    """
    Abstract product Car class.
    """
    __slots__ = ['_curr_speed']

    def __init__(self):
        """
        Default constructor.
        """
        self._curr_speed = 0

    @property
    def curr_speed(self) -> int:
        return self._curr_speed

    def exceeding_speed(self, desired_speed: int) -> bool:
        """
        Checks whether the current speed of this car exceeds the given desired
        speed.
        :param desired_speed: int
        :return: bool
        """
        return self._curr_speed > desired_speed

    @abstractmethod
    def speed_up(self) -> None:
        """
        Speeds this car up.
        :return: None
        """
        pass


class SlowCar(Car):
    """
    Concrete product SlowCar class.
    """
    __slots__ = []

    def __init__(self):
        """
        Default constructor.
        """
        super().__init__()
        print('Creating a Slow Car')

    def speed_up(self):
        self._curr_speed += 5
        print(f'Speeding up... Current speed: {self._curr_speed}')


class FastCar(Car):
    """
    Concrete product FastCar class.
    """
    __slots__ = []

    def __init__(self):
        """
        Default constructor.
        """
        super().__init__()
        print('Creating a Fast Car')

    def speed_up(self):
        self._curr_speed += 10
        print(f'Speeding up... Current speed: {self._curr_speed}')


class NullCar(Car):
    """
    NullCar class that works as null objects.
    A NullCar object does nothing to indicate that a Car object does not exist.

    This class is implemented as a singleton class.
    """

    @classmethod
    def get_instance(cls):
        """
        Gets the singleton instance.
        :return: NullCar
        """
        return cls.__new__(cls)

    def __new__(cls, *args, **kwargs):
        if not hasattr(cls, '_instance'):
            cls._instance = super().__new__(cls)
        return cls._instance

    def exceeding_speed(self, desired_speed):
        return True

    def speed_up(self):
        # Do nothing
        print('Null Car encountered')


class CarFactory(object):
    """
    Factory CarFactory class that actually uses Null Object Pattern.
    """
    __slots__ = []

    @staticmethod
    def get_car(max_speed: int) -> Car:
        """
        Factory method to make a product Car instance according to the given max
        speed.
        :param max_speed: int
        :return: Car
        """
        # Assumption: max_speed > 0
        if max_speed < 70:
            return SlowCar()
        elif max_speed < 120:
            return FastCar()
        else:
            # Normal way: Return a None
            # return None

            # Null Object Pattern: Return a null object
            return NullCar()
