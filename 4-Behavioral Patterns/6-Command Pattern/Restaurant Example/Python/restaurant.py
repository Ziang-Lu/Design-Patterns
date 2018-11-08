#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Restaurant module.
"""

__author__ = 'Ziang Lu'

from abc import ABC, abstractmethod
from typing import Set


class Command(ABC):
    """
    Abstract Command class that works as "Command".
    This abstract class represents a request, and defines only one execute()
    method, which executes this command.
    """
    __slots__ = []

    @abstractmethod
    def execute(self) -> None:
        """
        Executes this command.
        We let the correct receiver in a "ConcreteCommand" perform some actions
        and thus handle the request.
        :return: None
        """
        pass


class Cook(object):
    """
    Cook class that works as the "Receiver" for "Order" command.
    """
    __slots__ = []

    def cook(self, items: Set[str]) -> None:
        """
        Cooks the given items.
        :param items: set{str}
        :return: None
        """
        for item in items:
            print(f'Cook [Receiver] is cooking {item}.')


class Order(Command):
    """
    Concrete Order class that works as "ConcreteCommand".
    This class contains a reference to a "Receiver", which is responsible for,
    in the execute() method, perform some actions and thus handle the request.
    """
    __slots__ = ['_cook', '_items']

    def __init__(self, cook: Cook):
        """
        Constructor with parameter.
        :param cook: Cook
        """
        self._cook = cook
        # Reference to the "Receiver", which is responsible for, in the
        # execute() method, perform some actions and thus handle the request.
        self._items = set()
        print('A new order [Command] has been created.')

    def add_item(self, item: str) -> None:
        """
        Adds the given item to this order.
        :param item: str
        :return: None
        """
        self._items.add(item)
        print(f'{item} has been added to the order.')

    def execute(self):
        # Let the cook [Receiver] handle this order [Command]
        self._cook.cook(self._items)


class Cleaner(object):
    """
    Cleaner class that works as the "Receiver" for "CleanCommand" command.
    """
    __slots__ = []

    def clean_table(self) -> None:
        """
        Cleans up the table.
        :return: None
        """
        print('Cleaner [Receiver] is cleaning up the table.')


class CleanCommand(Command):
    """
    Concrete CleanCommand class that works as "ConcreteCommand".
    This class contains a reference to a "Receiver", which is responsible for,
    in the execute() method, perform some actions and thus handle the request.
    """
    __slots__ = ['_cleaner']

    def __init__(self, cleaner: Cleaner):
        """
        Constructor with parameter.
        :param cleaner: Cleaner
        """
        self._cleaner = cleaner
        # Reference to the "Receiver", which is responsible for, in the
        # execute() method, perform some actions and thus handle the request.
        print('A new clean command [Command] has been created.')

    def execute(self):
        # Let the cleaner [Receiver] handle this clean command [Command]
        self._cleaner.clean_table()


class Waiter(object):
    """
    Waiter class that works as "Invoker".
    This class is responsible for executing the different "Command"s.
    """
    __slots__ = []

    def execute_command(self, command: Command) -> None:
        """
        Executes the given command.
        The "Invoker" does not know how to handle the request, but simply invoke
        command.execute() method, and let the internal correct "Receiver" handle
        the request.
        :param command: Command
        :return: None
        """
        print('Waiter [Invoker] has received the command [Command] and start '
              'executing the command [Command] ...')
        command.execute()
