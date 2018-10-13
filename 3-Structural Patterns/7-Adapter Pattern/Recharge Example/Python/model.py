#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Model module.
"""

__author__ = 'Ziang Lu'

from abc import ABC, abstractmethod


class Rechargeable(ABC):
    """
    Abstract Rechargeable class that defines the recharging behavior.
    """
    __slots__ = []

    @abstractmethod
    def recharge(self) -> None:
        """
        Recharges this device.
        :return: None
        """
        pass


class FormatIPhone(Rechargeable):
    """
    Abstract FormatIPhone interface that defines recharging an iPhone-format
    device.
    """
    __slots__ = []

    @abstractmethod
    def use_lightning(self) -> None:
        """
        Connects this device to iPhone lightning recharger.
        :return: None
        """
        pass


class IPhone(FormatIPhone):
    __slots__ = ['_connection']

    def __init__(self):
        """
        Default constructor.
        """
        self._connection = False

    def use_lightning(self):
        print('iPhone connected to lightning recharger')
        self._connection = True

    def recharge(self):
        if not self._connection:
            print('Please connect to the recharger first')
            return
        print('Recharging iPhone via lightning recharger')


class FormatAndroid(Rechargeable):
    """
    Abstract FormatAndroid interface that defines recharging an Android-format
    device.
    This interface works as "Target".

    By comparing the signatures of use_micro_usb() method and the
    IPhone.use_lightning() method, we can find that this interface and the
    IPhone are independent or incompatible systems.
    """
    __slots__ = []

    @abstractmethod
    def use_micro_usb(self) -> None:
        """
        Connects this device to Android micro USB recharger.
        :return: None
        """
        pass


class Android(FormatAndroid):
    __slots__ = ['_connection']

    def __init__(self):
        """
        Default constructor.
        """
        self._connection = False

    def use_micro_usb(self):
        print('Android phone connected to micro USB recharger')
        self._connection = True

    def recharge(self):
        if not self._connection:
            print('Please connect to the recharger first')
            return
        print('Recharging Android phone via micro USB recharger')


class IPhoneToFormatAndroidAdapter(FormatAndroid):
    """
    Concrete IPhoneToFormatAndroidAdapter class that works as "Adapter".

    Note that in this implementations, we uses Object Adapter:
     - Since we cannot change the "Target" interface, in order to keep the
       original API, we create an "Adapter" class that implements the "Target"
       interface.
     - In order to make the "Target" interface and the "Adaptee" work together,
       in the "Adapter" class, we simply keep a referent to the "Adaptee"
       object, and delegate the request from the client to this "Adaptee"
       object.
    """
    __slots__ = ['_adaptee']

    def __init__(self, iphone: IPhone):
        """
        Constructor with parameter.
        :param iphone: iPhone
        """
        self._adaptee = iphone

    def use_micro_usb(self):
        # Perform the necessary conversion to make the two independent or
        # incompatible systems work together
        print('iPhone connected to micro USB recharger')

        # Delegate the request to the adaptee object
        self._adaptee.use_lightning()

    def recharge(self):
        # Delegate the request to the adaptee object
        self._adaptee.recharge()
