#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Turn-on-and-off operation module.
"""

__author__ = 'Ziang Lu'

from abc import ABC

from appliance_implementor import ApplianceImplementor


class TurnOnAndOff(ABC):
    """
    Abstract TurnOnAndOff class that works as "Abstraction".
    This class defines turnOn() and turnOff() methods for the client to call,
    and holds a reference to an appliance, so that the client will use this
    turn-on-and-off operation to control that appliance.
    """
    __slots__ = ['_appliance']

    def __init__(self, appliance: ApplianceImplementor):
        """
        Constructor with parameter.
        :param appliance: ApplianceImplementor
        """
        self._appliance = appliance

    def turn_on(self) -> None:
        """
        Turns on the controlled appliance.
        :return: None
        """
        self._appliance.turn_on()

    def turn_off(self) -> None:
        """
        Turns off the controlled appliance.
        :return: None
        """
        self._appliance.turn_off()


class PullCord(TurnOnAndOff):
    """
    Concrete PullCord class that works as "ConcreteAbstraction".
    This turn-on-and-off operation controls an appliance using a pull cord.
    """
    __slots__ = []

    def __init__(self, appliance: ApplianceImplementor):
        """
        Constructor with parameter.
        :param appliance: ApplianceImplementor
        """
        super().__init__(appliance)


class OnOffSwitch(TurnOnAndOff):
    """
    Concrete OnOffSwitch class that works as "ConcreteAbstraction".
    This turn-on-and-off operation controls an appliance using a on/off switch.
    """
    __slots__ = []

    def __init__(self, appliance: ApplianceImplementor):
        """
        Constructor with parameter.
        :param appliance: ApplianceImplementor
        """
        super().__init__(appliance)
