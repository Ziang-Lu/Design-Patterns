#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Third-party billing system module.
"""

__author__ = 'Ziang Lu'

from typing import List


class Employee(object):
    __slots__ = ['_id', '_name', '_designation']

    def __init__(self, id_: int, name: str, designation: str):
        """
        Constructor with parameter.
        :param id_: int
        :param name: str
        :param designation: str
        """
        self._id = id_
        self._name = name
        self._designation = designation

    @property
    def name(self) -> str:
        """
        Accessor of name
        :return: str
        """
        return self._name

    @property
    def designation(self) -> str:
        """
        Accessor of designation.
        :return: str
        """
        return self._designation

    def __repr__(self):
        return f'Employee[id={self._id}, name={self._name}, ' \
            f'designation={self._designation}]'


class ThirdPartyBillingSystem(object):
    """
    ThirdPartyBillingSystem class that works as "Adaptee".

    By comparing the signatures of process_salary() method and the
    CompanyBillingSystem.process_employees_salary() method, we can find that
    this interface and the ThirdPartyBillingSystem are independent or
    incompatible systems.
    """
    __slots__ = []

    def process_salary(self, employees: List[Employee]) -> None:
        """
        Calculates the salary of the given employees, and credit it to their
        corresponding bank account.
        :param employees: list[Employee]
        :return: None
        """
        for employee in employees:
            print('\n' + str(employee))
            designation = employee.designation
            salary = 0
            if designation.lower() == 'Team Leader'.lower():
                salary = 12000
            elif designation.lower() == 'Developer'.lower():
                salary = 8000
            elif designation.lower() == 'Tester'.lower():
                salary = 5000
            print(f"${salary:,} credited to {employee.name}'s account")
