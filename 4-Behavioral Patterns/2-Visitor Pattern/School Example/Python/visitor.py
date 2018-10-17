#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
School visitor module.
"""

__author__ = 'Ziang Lu'

import random
from abc import ABC, abstractmethod


class SchoolVisitor(ABC):
    """
    Abstract SchoolVisitor class that works as "Visitor".
    This class encapsulates the executing algorithm (operation) on elements in
    the object structure, and can visit each "Element" in the object structure,
    and perform desired algorithm (handle operation) on that "Element".
    """
    __slots__ = []

    @abstractmethod
    def visit_employee(self, employee) -> None:
        """
        Lets this school visitor visit the given employee, and perform desired
        algorithm (handle operation) on it.
        :param employee: Employee
        :return: None
        """
        pass

    @abstractmethod
    def visit_child(self, child) -> None:
        """
        Lets this school visitor visit the given child, and perform desired
        algorithm (handle operation) on it.
        :param child: Child
        :return: None
        """
        pass


class Leader(SchoolVisitor):
    """
    Concrete Leader class that works as "ConcreteVisitor".
    """
    __slots__ = []

    def visit_employee(self, employee):
        print(f"Leader examines {employee.name}'s work.")

    def visit_child(self, child):
        print(f"Leader kindly says hi to {child.name}.")


class ChildSpecialistDoctor(SchoolVisitor):
    """
    Concrete ChildSpecialistDoctor class that works as "ConcreteVisitor".
    """
    __slots__ = []

    def visit_employee(self, employee):
        # Do nothing
        pass

    def visit_child(self, child):
        print(f'Child Specialist Doctor is checking health status for '
              f'{child.name}...', end='')
        if random.choice([True, False]):
            print('and found that {child.name} is in good health!')
            child.set_health_status(health_status='Good')
        else:
            print('and found that {child.name} is NOT in good health. Please go'
                  ' to the hospital someday.')
            child.set_health_status(health_status='Bad')
