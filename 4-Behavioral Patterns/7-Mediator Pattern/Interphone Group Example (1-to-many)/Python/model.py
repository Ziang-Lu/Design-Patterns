#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Model module.
"""

__author__ = 'Ziang Lu'

from abc import ABC


class InterphoneGroup(object):
    """
    InterphoneGroup class that works as "Mediator".
    A "Mediator" object acts as the communication center for "Colleague"
    objects by encapsulating the communication between "Colleague" objects in
    this "Mediator" object.
    """
    __slots__ = ['_members']

    def __init__(self):
        """
        Default constructor.
        """
        self._members = []

    def register(self, user) -> None:
        """
        Registers the given user.
        :param user: User
        :return: None
        """
        self._members.append(user)

    def publish_message(self, sender, msg: str) -> None:
        for member in self._members:
            if member is not sender:
                member.receive_message(sender_name=sender.name, msg=msg)


class User(ABC):
    """
    Abstract User class that works as "Colleague".
    When a "Colleague" object needs to communicate to another "Colleague"
    object, it does not directly call on the other "Colleague" object; instead,
    it calls the "Mediator" object whose main duty is to control and coordinate
    the communication between "Colleague" objects.
    In this way, the communication complexity between the "Colleague" objects
    are greatly reduced.
    """
    __slots__ = ['_name', '_group']

    def __init__(self, name: str):
        """
        Constructor with parameter.
        :param name: str
        """
        self._name = name
        self._group = None

    @property
    def name(self) -> str:
        """
        Accessor of name.
        :return: str
        """
        return self._name

    def join_group(self, group: InterphoneGroup) -> None:
        """
        Joins the given interphone group.
        :param group: InterphoneGroup
        :return: None
        """
        self._group = group
        group.register(self)

    def send_message(self, msg: str) -> None:
        """
        Sends the given message to the group.
        :param msg: str
        :return: None
        """
        print(f'{self._name} sends a message: {msg}')
        self._group.publish_message(sender=self, msg=msg)

    def receive_message(self, sender_name: str, msg: str) -> None:
        """
        Receives the given message from the given sender.
        :param sender_name: str
        :param msg: str
        :return: None
        """
        print(f'{self._name} received a message from {sender_name}: {msg}')


class LeaderUser(User):
    """
    Concrete LeaderUser that works as "ConcreteColleague".
    """
    __slots__ = []

    def __init__(self, name: str):
        """
        Constructor with parameter.
        :param name: str
        """
        super().__init__(name)


class NormalUser(User):
    """
    Concrete NormalUser that works as "ConcreteColleague".
    """
    __slots__ = []

    def __init__(self, name: str):
        """
        Constructor with parameter.
        :param name: str
        """
        super().__init__(name)
