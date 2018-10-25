#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Satellite TV module.
"""

__author__ = 'Ziang Lu'

from abc import ABC, abstractmethod


class SatelliteTV(ABC):
    """
    Abstract SatelliteTV class that works as "Component".
    """
    __slots__ = []

    @abstractmethod
    def show(self, channel_number: int) -> None:
        """
        Shows the channel according to the given channel number.
        :param channel_number: int
        :return: None
        """
        pass

    @abstractmethod
    def get_subscription_cost(self) -> int:
        """
        Gets the total subscription cost of the package.
        :return: int
        """
        pass


class SkyTV(SatelliteTV):
    """
    SkyTV class that works as one kind of "ConcreteComponent".
    """
    __slots__ = []

    def show(self, channel_number):
        if 0 <= channel_number < 100:
            print('Enjoy the news!')
        else:
            print('You have not subscribed yet. Please subscribe.')

    def get_subscription_cost(self):
        print('Cost of the normal package: $100')
        return 100


class SatelliteTVDecorator(SatelliteTV):
    """
    Abstract SatelliteTVDecorator class that works as "Decorator".
    This is essentially a wrapper that reproduces the functionality of an
    existing class and adds new functionality to it, without impacting existing
    structure and functionality of the objects.

    However, since decorators should be stackable, which means we should be able
    to add decorators on decorators on decorators...... to further increase the
    provided functionalities.
    Thus, we let different "ConcreteComponent" classes and the abstract
    "Decorator" both inherit from the common super class "Component", so that
    "Decorator" will only have an abstract "Component" object to decorate, but
    does not need to care it will actually decorate a "ConcreteComponent" or
    another "Decorator".
    """
    __slots__ = ['_satellite_tv']

    def __init__(self, satellite_tv):
        """
        Constructor with parameter.
        :param satellite_tv: SatelliteTV
        """
        self._satellite_tv = satellite_tv
        # Dynamically customize and add functionality to this SatelliteTV
        # instance, which could either be a SatelliteTV or some other
        # SatelliteTVDecorator.

    def show(self, channel_number: int):
        self._satellite_tv.show(channel_number)

    def get_subscription_cost(self):
        # Forward the request to the encapsulated satellite TV
        return self._satellite_tv.get_subscription_cost()


class SatelliteTVWithEspn(SatelliteTVDecorator):
    """
    SatelliteTVWithEspn class that works as one kind of "ConcreteDecorator".
    This class adds (decorates) ESPN channels to a SatelliteTV ("Component")
    object.
    """
    __slots__ = []

    def __init__(self, satellite_tv):
        """
        Constructor with parameter.
        :param satellite_tv: SatelliteTV
        """
        super().__init__(satellite_tv)

    def show(self, channel_number):
        if 100 <= channel_number < 200:
            print('Enjoy the football game!')
        else:
            # Forward the request to the encapsulated satellite TV
            self._satellite_tv.show(channel_number)

    def get_subscription_cost(self):
        # Returns the cost of the decorated satellite TV after adding ESPN
        # channels to the package
        total = self._satellite_tv.get_subscription_cost() + 8
        print('Cost of ESPN channels: $8')
        return total


class SatelliteTVWithDiscovery(SatelliteTVDecorator):
    """
    SatelliteTVWithDiscovery class that works as one kind of
    "ConcreteDecorator".
    This class adds (decorates) Discovery channels to a SatelliteTV
    ("Component") object.
    """
    __slots__ = []

    def __init__(self, satellite_tv):
        """
        Constructor with parameter.
        :param satellite_tv: SatelliteTV
        """
        super().__init__(satellite_tv)

    def show(self, channel_number):
        if 200 <= channel_number < 300:
            print('Enjoy the boring documentary.')
        else:
            # Forward the request to the encapsulated satellite TV
            self._satellite_tv.show(channel_number)

    def get_subscription_cost(self):
        # Returns the cost of the decorated satellite TV after adding Discovery
        # channels to the package
        total = self._satellite_tv.get_subscription_cost() + 10
        print('Cost of Discovery channels: $10')
        return total


class SatelliteTVWithCartoonNetwork(SatelliteTVDecorator):
    """
    SatelliteTVWithCartoonNetwork class that works as one kind of
    "ConcreteDecorator".
    This class adds (decorates) Cartoon Network channels to a SatelliteTV
    ("Component") object.
    """
    __slots__ = []

    def __init__(self, satellite_tv):
        """
        Constructor with parameter.
        :param satellite_tv: SatelliteTV
        """
        super().__init__(satellite_tv)

    def show(self, channel_number):
        if 300 <= channel_number < 400:
            print('Enjoy the Mickey Mouse!')
        else:
            # Forward the request to the encapsulated satellite TV
            self._satellite_tv.show(channel_number)

    def get_subscription_cost(self):
        # Returns the cost of the decorated satellite TV after adding Cartoon
        # Network channels to the package
        total = self._satellite_tv.get_subscription_cost() + 5
        print('Cost of Cartoon Network channels: $5')
        return total
