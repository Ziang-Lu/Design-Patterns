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
    __slots__ = ['_all_members', '_leaders']

    def __init__(self):
        """
        Default constructor.
        """
        self._all_members = {}
        self._leaders = []

    def register(self, user) -> None:
        """
        Registers the given user.
        :param user: User
        :return: None
        """
        self._all_members[user.name] = user
        if type(user).__name__ == 'LeaderUser':
            self._leaders.append(user)

    def publish_message(self, sender, msg: str) -> None:
        """
        Publishes the given message from the given sender.
        :param sender: User
        :param msg: str
        :return: None
        """
        for member in self._all_members.values():
            if member is not sender:  # The sender himself should not receive the message.
                member.receive_message(sender_name=sender.name, msg=msg)

    def publish_message_to_leaders(self, sender, msg: str) -> None:
        """
        Publishes the given message from the given sender to all the leaders.
        :param sender: User
        :param msg: str
        :return: None
        """
        for leader in self._leaders:
            if leader is not sender:  # The sender himself should not receive the message.
                leader.receive_message(sender_name=sender.name, msg=msg)

    def private_message(self, sender, recipient_name: str, msg: str) -> None:
        """
        Sends the given message from the given sender to the given recipient.
        :param sender: User
        :param recipient_name: str
        :param msg: str
        :return: None
        """
        recipient = self._all_members[recipient_name]
        recipient.receive_message(sender_name=sender.name, msg=msg)


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

    def send_to_all(self, msg: str) -> None:
        """
        Sends the given message to all members in the group.
        :param msg: str
        :return: None
        """
        print(f'{self._name} sends a public message: {msg}')
        self._group.publish_message(sender=self, msg=msg)

    def send_to_leaders(self, msg: str) -> None:
        """
        Sends the given message to all the leaders in the group.
        :param msg: str
        :return: None
        """
        print(f'{self._name} sends a message to all the leaders: {msg}')
        self._group.publish_message_to_leaders(sender=self, msg=msg)

    def send_message(self, recipient: str, msg: str) -> None:
        """
        Sends the given message to the given recipient.
        :param recipient: str
        :param msg: str
        :return: None
        """
        print(f'{self._name} sends a message to {recipient}: {msg}')
        self._group.private_message(sender=self, recipient_name=recipient, msg=msg)

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
