#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Application that actually uses Chain of Responsibility Pattern.
In this example, ONLY ONE receiver object in the chain handles the request.
"""

__author__ = 'Ziang Lu'

from employee import HumanResource, ProjectLeader, TeamLeader


def main():
    team_leader = TeamLeader()
    project_leader = ProjectLeader()
    team_leader.set_supervisor(project_leader)
    hr = HumanResource()
    team_leader.set_supervisor(hr)

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
