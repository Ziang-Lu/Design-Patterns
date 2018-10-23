#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
School module.
"""

__author__ = 'Ziang Lu'

from abc import ABC, abstractmethod
from enum import Enum, auto

from visitor import ChildSpecialistDoctor, Leader, SchoolVisitor


class Visitable(ABC):
    """
    Abstract Visitable class that works as "Element/Visitable".
    This class represents an element in the object structure, and can be visited
    by a "Visitor", so that the "Visitor" can perform algorithm (handle
    operation) on this "Element".
    """
    __slots__ = []

    @abstractmethod
    def accept(self, visitor: SchoolVisitor) -> None:
        """
        Accepts the given visitor and lets it perform algorithm (handle
        operation) on this "Element".
        In this way, we can change the executing algorithm (operation) on this
        "Element" by simply varying the visitor object.
        :param visitor: SchoolVisitor
        :return: None
        """
        pass


class Employee(Visitable):
    """
    Concrete Employee class that works as "ConcreteElement".
    
    Note that Employee class can be totally unrelated to Child class, except
    that they are both Visitable, and can accept a SchoolVisitor 
    """
    __slots__ = ['_name']

    def __init__(self, name: str):
        """
        Constructor with parameter.
        :param name: str
        """
        self._name = name

    @property
    def name(self) -> str:
        """
        Accessor of name.
        :return: name
        """
        return self._name

    def accept(self, visitor):
        visitor.visit_employee(self)


class Child(Visitable):
    """
    Concrete Child class that works as "ConcreteElement".

    Note that Child class can be totally unrelated to Employee class, except
    that they are both Visitable, and can accept a SchoolVisitor
    """
    __slots__ = ['_name', '_health_status']

    def __init__(self, name: str):
        """
        Constructor with parameter.
        :param name: str
        """
        self._name = name
        self._health_status = 'Good'

    @property
    def name(self) -> str:
        """
        Accessor of name.
        :return: str
        """
        return self._name

    def set_health_status(self, health_status: str) -> None:
        """
        Mutator of health_status.
        :param health_status: str
        :return: None
        """
        self._health_status = health_status

    def accept(self, visitor):
        visitor.visit_child(self)


class School(object):
    """
    School class that actually uses Visitor Pattern.
    The Visitor Pattern separates an algorithm (an operation) from the object
    structure it operates on, and the executing algorithm (operation) is
    encapsulated in a visitor object.
    In this way, we can change the executing algorithm (operation) on each
    element in the object structure by simply varying the visitor object,
    without needing to modify the object structure itself.
    """
    __slots__ = ['_employees', '_children']

    def __init__(self):
        """
        Default constructor.
        """
        self._employees = []  # Employees in this school
        # This works as one object structure, whose elements can be visited by a
        # "Visitor", so that the "Visitor" can perform algorithm (handle
        # operation) on each element.
        self._children = []  # Children in this school
        # This works as another object structure, whose elements can be visited
        # by a "Visitor", so that the "Visitor" can perform algorithm (handle
        # operation) on each element.

    def add_employee(self, name: str) -> None:
        """
        Adds a new employee to this school.
        :param name: str
        :return: None
        """
        self._employees.append(Employee(name))

    def add_child(self, name: str) -> None:
        """
        Adds a new child to this school.
        :param name: str
        :return: None
        """
        self._children.append(Child(name))

    def examine_by(self, leader: Leader) -> None:
        """
        Examines by the given leader.
        :param leader: Leader
        :return: None
        """
        print("Leader comes to examine the school's work.")

        # The given leader is able to visit each employee/child in the
        # employees/children objects structure, and perform desired algorithm
        # (handle operation) on that employee/child.

        for employee in self._employees:
            employee.accept(visitor=leader)

        for child in self._children:
            child.accept(visitor=leader)

    def perform_health_check(self) -> None:
        """
        Performs health check for the children in this school.
        :return: None
        """
        print('The school will perform health check for the children.')
        # Create a doctor that is able to visit each child in the children
        # objects structure, and perform desired algorithm (handle operation) on
        # that child
        doctor = ChildSpecialistDoctor()
        for child in self._children:
            child.accept(visitor=doctor)
