#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Management employee module.
"""

__author__ = 'Ziang Lu'


from abc import ABC, abstractmethod


class ManagementEmployee(ABC):
    """
    Abstract ManagementEmployee class that works as "Handler".

    In order to let different "ConcreteHandler" be able to process the same
    request, we need them to have similar API.
    Therefore, we simply let this step be done via letting different
    "ConcreteHandler" share a common super class "Handler", in which we define
    the API to process a request.
    """
    __slots__ = ['_supervisor']

    def __init__(self):
        """
        Default constructor.
        """
        self._supervisor = None  # Supervisor of this management employee.
        # This works as the next receiver (handler) in the chain of
        # responsibility: if this receiver cannot handle the request, then it
        # passes the request to the next receiver in the chain of
        # responsibility.

    def set_supervisor(self, employee) -> None:
        """
        Mutator of supervisor.
        :param employee: ManagementEmployee
        :return: None
        """
        self._supervisor = employee

    @abstractmethod
    def _get_max_approvable_leave_days(self) -> int:
        """
        Gets the max number of leave days this management employee can approve.
        :return: int
        """
        pass

    def handle_developer_leave_request(self, developer: str,
                                       requested_leave_days: int) -> bool:
        """
        Handles the leave request from the given developer for the given number
        of days.
        :param developer: str
        :param requested_leave_days: int
        :return: bool
        """
        if requested_leave_days <= self._get_max_approvable_leave_days():
            # This receiver can handle the request.
            # Stop here and return.
            self._approve_leave_request(developer, requested_leave_days)
            return True
        else:
            # Pass the request to the next receiver in the chain of
            # responsibility
            print(f'{type(self).__name__} cannot approve a '
                  f'{requested_leave_days}-day leave.', end=' ')
            if self._supervisor:
                print(f'The leave request is handled to '
                      f'{type(self._supervisor).__name__}.')
                return self._supervisor.handle_developer_leave_request(
                    developer, requested_leave_days)
            else:
                print('No more supervisor. The leave request will be rejected.')
                return False

    def _approve_leave_request(self, name: str,
                               requested_leave_days: int) -> None:
        """
        Private helper method to approve the leave request from the given
        employee for the given number of days.
        :param name: str
        :param requested_leave_days: int
        :return: None
        """
        print(f'{type(self).__name__} approves {name} for a '
              f'{requested_leave_days}-day leave.')


class TeamLeader(ManagementEmployee):
    """
    TeamLeader class that works as "ConcreteHandler".
    """
    __slots__ = []

    def _get_max_approvable_leave_days(self):
        # Team Leader can only approve a leave request up to 10 days.
        return 10


class ProjectLeader(ManagementEmployee):
    """
    ProjectLeader class that works as "ConcreteHandler".
    """
    __slots__ = []

    def _get_max_approvable_leave_days(self):
        # Project Leader can only approve a leave request up to 20 days.
        return 20


class HumanResource(ManagementEmployee):
    """
    HumanResource class that works as "ConcreteHandler".
    """
    __slots__ = []

    def _get_max_approvable_leave_days(self):
        # Human Resource can only approve a leave request up to 30 days.
        return 30
