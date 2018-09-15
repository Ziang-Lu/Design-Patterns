#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Builder module.
"""

__author__ = 'Ziang Lu'

from abc import ABC, abstractmethod

from robot import Robot, RobotArms, RobotHead, RobotLegs, RobotTorso


class RobotBuilder(ABC):
    """
    Abstract RobotBuilder class that works as an abstract factory and defines
    the construction process for a robot, i.e., how to build a robot by creating
    and assembling all of its parts.
    """
    __slots__ = ['_robot']

    def __init__(self):
        """
        Default constructor.
        """
        self._robot = Robot()

    @abstractmethod
    def build_robot_head(self) -> None:
        """
        Builds a robot's head.
        :return: None
        """
        pass

    @abstractmethod
    def build_robot_torso(self) -> None:
        """
        Builds a robot's torso.
        :return: None
        """
        pass

    @abstractmethod
    def build_robot_arms(self) -> None:
        """
        Builds a robot's arms.
        :return: None
        """
        pass

    @abstractmethod
    def build_robot_legs(self) -> None:
        """
        Builds a robot's legs.
        :return: None
        """
        pass

    def get_robot(self) -> Robot:
        """
        Returns a finished robot.
        :return: Robot
        """
        return self._robot


class OldRobotBuilder(RobotBuilder):
    """
    Concrete OldRobotBuilder class that works as a concrete factory, a
    blueprint,to build an old-school type of robot.
    """
    __slots__ = []

    def build_robot_head(self) -> None:
        self._robot.set_head(RobotHead('Tin Head'))

    def build_robot_torso(self) -> None:
        self._robot.set_torso(RobotTorso('Tin Torso'))

    def build_robot_arms(self) -> None:
        self._robot.set_arms(RobotArms('Blowtorch Arms'))

    def build_robot_legs(self) -> None:
        self._robot.set_legs(RobotLegs('Roller Skates'))


class NewRobotBuilder(RobotBuilder):
    """
    Concrete NewRobotBuilder class that works as a concrete factory, a blueprint
    to build an new-school type of robot.
    """
    __slots__ = []

    def build_robot_head(self) -> None:
        self._robot.set_head(RobotHead('Vibranium Head'))

    def build_robot_torso(self) -> None:
        self._robot.set_torso(RobotTorso('Vibranium Torso'))

    def build_robot_arms(self) -> None:
        self._robot.set_arms(RobotArms('Artificial Flesh Arms'))

    def build_robot_legs(self) -> None:
        self._robot.set_legs(RobotLegs('Jet-Propelled Legs'))


class RobotEngineer(object):
    """
    RobotEngineer class that works as a director and owns a robot builder
    (working as a factory) to make and return robots.
    """
    __slots__ = ['_robot_builder']

    def __init__(self, robot_builder: RobotBuilder):
        """
        Constructor with parameter.
        :param robot_builder: RobotBuilder
        """
        self._robot_builder = robot_builder

    def make_robot(self) -> None:
        """
        Makes a robot via the robot builder.
        :return: None
        """
        self._robot_builder.build_robot_head()
        self._robot_builder.build_robot_torso()
        self._robot_builder.build_robot_arms()
        self._robot_builder.build_robot_legs()

    def get_robot(self) -> Robot:
        """
        Returns a finished robot from the robot builder.
        :return: Robot
        """
        return self._robot_builder.get_robot()
