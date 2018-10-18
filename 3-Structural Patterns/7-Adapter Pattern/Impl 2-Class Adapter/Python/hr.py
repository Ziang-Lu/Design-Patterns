#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Application that actually uses Class Adapter of Adapter Pattern.
"""

__author__ = 'Ziang Lu'

from abc import ABC, abstractmethod
from typing import List

from third_party_billing import Employee, ThirdPartyBillingSystem


class CompanyBillingSystem(ABC):
    """
    Abstract CompanyBillingSystem class that works as "Target".

    By comparing the signatures of process_employees_salary() method and the
    ThirdPartyBillingSystem.process_salary() method, we can find that this
    interface and the ThirdPartyBillingSystem are independent or incompatible
    systems.
    """
    __slots__ = []

    @abstractmethod
    def process_employees_salary(self, employees_info: List[List[str]]) -> None:
        """
        Calculates the salary of the given employees, and credit it to their
        corresponding bank account.
        :param employees_info: list[list[str]]
        :return: None
        """
        pass


class BillingSystemAdapter(CompanyBillingSystem, ThirdPartyBillingSystem):
    """
    Concrete BillingSystemAdapter class that works as "Adapter".

    Note that in this implementation, we use Object Adapter:
    - Since we cannot change the "Target" interface, in order to keep the
      original API, we create an "Adapter" class that implements the "Target"
      interface.
    - In order to make the "Target" interface and the "Adaptee" work together,
      we let "Adapter" class inherit the "Adaptee" class, and thus inheriting
      the methods in the "Adaptee" class, so that it can forward the request
      from the client to the correct "Adaptee" class method.
    """

    @staticmethod
    def _employee_string_array_to_list(
        employees_info: List[List[str]]
    ) -> List[Employee]:
        """
        Private static helper function to convert String array of employee
        information to list of Employee objects.
        :param employees_info: list[list[str]]
        :return: list[Employee]
        """
        employees = []
        for employee_info in employees_info:
            id_ = int(employee_info[0])
            name = employee_info[1]
            designation = employee_info[2]
            employees.append(Employee(id_, name, designation))
        return employees

    @classmethod
    def get_instance(cls):
        """
        Gets the singleton instance.
        :return: BillingSystemAdapter
        """
        return cls.__new__(cls)

    def __new__(cls, *args, **kwargs):
        if not hasattr(cls, '_instance'):
            cls._instance = super().__new__(cls)
        return cls._instance

    def process_employees_salary(self, employees_info):
        # Perform the necessary conversion to make the two independent or
        # incompatible systems work together
        employees = self._employee_string_array_to_list(employees_info)
        print('\nAdapter finished format conversion of employee information:')
        print(employees)

        # Forward the request to the correct "Adaptee" class method
        self.process_salary(employees)


def _get_employee_info() -> List[List[str]]:
    """
    Private helper function to get the employee information.
    :return: list[list[str]]
    """
    return [
        ['100', 'Dave', 'Team Leader'],
        ['101', 'Ram', 'Developer'],
        ['102', 'Raj', 'Developer'],
        ['103', 'Rahul', 'Tester'],
    ]


def main():
    company_billing_system = BillingSystemAdapter()
    print('Human Resource Department is trying to process salary for the '
          'company employees.')
    company_billing_system.process_employees_salary(_get_employee_info())


if __name__ == '__main__':
    main()

# Output:
# Human Resource Department is trying to process salary for the company employees.
#
# Adapter finished format conversion of employee information:
# [Employee[id=100, name=Dave, designation=Team Leader], Employee[id=101, name=Ram, designation=Developer], Employee[id=102, name=Raj, designation=Developer], Employee[id=103, name=Rahul, designation=Tester]]
#
# Employee[id=100, name=Dave, designation=Team Leader]
# $12,000 credited to Dave's account
#
# Employee[id=101, name=Ram, designation=Developer]
# $8,000 credited to Ram's account
#
# Employee[id=102, name=Raj, designation=Developer]
# $8,000 credited to Raj's account
#
# Employee[id=103, name=Rahul, designation=Tester]
# $5,000 credited to Rahul's account
