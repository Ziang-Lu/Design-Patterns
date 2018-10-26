#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Robot module.
"""

__author__ = 'Ziang Lu'


class RobotHead(object):
    __slots__ = ['_type']

    def __init__(self, type_: str):
        """
        Constructor with parameter.
        :param type_: str
        """
        self._type = type_

    @property
    def type(self) -> str:
        """
        Accessor of type.
        :return: str
        """
        return self._type


class RobotTorso(object):
    __slots__ = ['_type']

    def __init__(self, type_: str):
        """
        Constructor with parameter.
        :param type_: str
        """
        self._type = type_

    @property
    def type(self) -> str:
        """
        Accessor of type.
        :return: str
        """
        return self._type


class RobotArms(object):
    __slots__ = ['_type']

    def __init__(self, type_: str):
        """
        Constructor with parameter.
        :param type_: str
        """
        self._type = type_

    @property
    def type(self) -> str:
        """
        Accessor of type.
        :return: str
        """
        return self._type


class RobotLegs(object):
    __slots__ = ['_type']

    def __init__(self, type_: str):
        """
        Constructor with parameter.
        :param type_: str
        """
        self._type = type_

    @property
    def type(self) -> str:
        """
        Accessor of type.
        :return: str
        """
        return self._type


class Robot(object):
    """
    Concrete Robot class.
    """
    __slots__ = ['_head', '_torso', '_arms', '_legs']

    def __init__(self):
        """
        Default constructor.
        """
        self._head = None
        self._torso = None
        self._arms = None
        self._legs = None

    def set_head(self, head: RobotHead) -> None:
        """
        Mutator of head.
        :param head: RobotHead
        :return: None
        """
        self._head = head

    def set_torso(self, torso: RobotTorso) -> None:
        """
        Mutator of torso.
        :param torso: RobotTorso
        :return: None
        """
        self._torso = torso

    def set_arms(self, arms: RobotArms) -> None:
        """
        Mutator of arms.
        :param arms: RobotArms
        :return: None
        """
        self._arms = arms

    def set_legs(self, legs: RobotLegs) -> None:
        """
        Mutator of legs.
        :param legs: RobotLegs
        :return: None
        """
        self._legs = legs

    def __repr__(self):
        return f'Robot [head={self._head.type}, torso={self._torso.type}, ' \
               f'arms={self._arms.type}, legs={self._legs.type}]'
