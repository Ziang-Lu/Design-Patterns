#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
ATM machine proxy module.
"""

__author__ = 'Ziang Lu'

from abc import ABC, abstractmethod


class GetAtmData(ABC):
    """
    Abstract GetAtmData interface that works as "Subject".

    In order to let the "Proxy" controls the access to its hiding "RealSubject"
    behind the scene, the "Proxy" needs to provide similar API as the
    "RealSubject".
    Therefore, we simply let this step be done via letting "RealSubject"
    and "Proxy" share a common super class "Subject", in which we define only
    the methods that we want the "Proxy" to provide access to.
    """
    __slots__ = []

    @abstractmethod
    def get_atm_state(self) -> str:
        """
        Gets the current state of the ATM.
        :return: str
        """
        pass

    @abstractmethod
    def get_cash_in_atm(self) -> int:
        """
        Gets the current amount of cash in the ATM.
        :return: int
        """
        pass


class AtmMachineInfoProxy(GetAtmData):
    """
    AtmMachineInfoProxy class that works as "Proxy".
    An AtmMachineInfoProxy object acts as a proxy that controls the access to
    its hiding AtmMachine object behind the scene. In this way, the "Proxy" will
    work on behalf of the "RealSubject", or the "Proxy" represents the
    "RealSubject".
    """
    __slots__ = ['_real_atm']

    def __init__(self, atm):
        """
        Constructor with parameter.
        :param atm: AtmMachine
        """
        self._real_atm = atm

    def get_atm_state(self):
        return self._real_atm.get_atm_state()

    def get_cash_in_atm(self):
        return self._real_atm.get_cash_in_atm()
