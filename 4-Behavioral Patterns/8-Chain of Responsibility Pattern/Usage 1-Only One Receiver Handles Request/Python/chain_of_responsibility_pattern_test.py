#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Application that actually uses Chain of Responsibility Pattern.
In this example, ONLY ONE receiver in the chain handles the request.
"""

__author__ = 'Ziang Lu'

from employee import (HumanResource, ManagementEmployee, ProjectLeader,
                      TeamLeader)


def _get_chain_of_responsibility() -> ManagementEmployee:
    """
    Private helper function to get the chain of responsibility.
    :return: ManagementEmployee
    """
    team_leader = TeamLeader()
    project_leader = ProjectLeader()
    team_leader.set_supervisor(project_leader)
    hr = HumanResource()
    team_leader.set_supervisor(hr)
    return team_leader


def main():
    team_leader = _get_chain_of_responsibility()

    team_leader.handle_developer_leave_request(developer='David',
                                               requested_leave_days=9)

    print()
    team_leader.handle_developer_leave_request(developer='John',
                                               requested_leave_days=18)

    print()
    team_leader.handle_developer_leave_request(developer='Steve',
                                               requested_leave_days=30)

    print()
    team_leader.handle_developer_leave_request(developer='Rohan',
                                               requested_leave_days=50)


if __name__ == '__main__':
    main()

# Output:
# TeamLeader approves David for a 9-day leave.
#
# TeamLeader cannot approve a 18-day leave. The leave request is handled to HumanResource.
# HumanResource approves John for a 18-day leave.
#
# TeamLeader cannot approve a 30-day leave. The leave request is handled to HumanResource.
# HumanResource approves Steve for a 30-day leave.
#
# TeamLeader cannot approve a 50-day leave. The leave request is handled to HumanResource.
# HumanResource cannot approve a 50-day leave. No more supervisor. The leave request will be rejected.
