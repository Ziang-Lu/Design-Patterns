#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Model module.
"""

__author__ = 'Ziang Lu'

from abc import ABC, abstractmethod


class Choice(ABC):
    """
    Abstract Choice class that works as "Component".
    Note that this implementation uses Design-for-Type-Safety, i.e., defining
    child-related operations only in "Composite"
    """
    __slots__ = []

    @abstractmethod
    def print_choice_msg(self) -> None:
        """
        Prints a prompt message of this choice.
        """
        pass


class Room(Choice):
    """
    Room class that works as "Composite".
    The "Composite" models nodes with children in the hierarchical structure.
    However, since both "Composite" and "Leaf" inherit from the common super
    class "Component", "Composite" does not need to keep track of its children's
    actual type, but only need to keep track of a collection of the abstract
    "Component" as its contents.
    Without the abstract "Component" super class abstraction, "Component" would
    have to maintain different lists for each kind of element in its contents,
    and would need to provide separate method for each kind of element.

    Note that since for "Composite", we are forwarding the request from the
    client to its sub-components, we are actually in some sense using Delegation
    Pattern here
    """
    __slots__ = ['_id', '_choices']

    def __init__(self, id_: int):
        """
        Constructor with parameter.
        :param id_: int
        """
        self._id = id_
        self._choices = [None]  # Add a dummy object

    def print_choice_msg(self):
        print(f'Enter Room #{self._id}')

    def print_next_choices(self) -> None:
        """
        Prints the next choices in this room.
        :return: None
        """
        print(f'Now you are in Room #{self._id}')
        print('You have the following choices:')
        for option in range(1, len(self._choices)):
            print(f'Option {option}:')
            self._choices[option].print_choice_msg()

    def get_choice(self, option: int) -> Choice:
        """
        Returns the choice in this room with the give option.
        :param option: int
        :return: Choice
        """
        return self._choices[option - 1]

    def get_num_of_choices(self) -> int:
        """
        Returns the number of choices in this room.
        :return: int
        """
        return len(self._choices)

    def add_choice(self, choice: Choice) -> None:
        """
        Adds the given choice to this room.
        :param choice: Choice
        :return: None
        """
        self._choices.append(choice)


class EndingChoice(Choice):
    """
    Abstract EndingChoice class.
    """
    __slots__ = []

    @abstractmethod
    def print_outcome(self) -> None:
        """
        Prints the outcome of this ending choice.
        :return: None
        """
        pass


class Treasure(EndingChoice):
    """
    Treasure class working as one kind of "Leaf".
    """
    __slots__ = ['_prize']

    def __init__(self, prize: int):
        """
        Constructor with parameter.
        :param prize: int
        """
        self._prize = prize

    def print_choice_msg(self):
        print('Claim your treasure!')

    def print_outcome(self):
        print(f'Your prize is {self._prize} coins.')


class Monster(EndingChoice):
    """
    Monster class working as one kind of "Leaf".
    """
    __slots__ = ['_treasure']

    def __init__(self):
        """
        Default constructor.
        """
        self._treasure = None

    def print_choice_msg(self):
        print('Fight a monster!')

    def print_outcome(self):
        if self._treasure:
            print("Ah! You killed the monster!")
            self._treasure.print_outcome()
        else:
            print('Ha! The monster killed you!')

    def set_treasure(self, treasure: Treasure) -> None:
        """
        Mutator of treasure.
        :param treasure: Treasure
        :return: None
        """
        self._treasure = treasure
