#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Application module.
"""

from school import School
from visitor import Leader


def main():
    school = School()
    school.add_employee('Steve')
    school.add_employee('Tony')
    school.add_child('Bruce')
    school.add_child('Nathasha')
    school.add_child('Clint')

    school.perform_health_check()

    print()
    school.examine_by(Leader())


if __name__ == '__main__':
    main()

# Output:
# The school will perform health check for the children.
# Child Specialist Doctor is checking health status for Bruce...and found that {child.name} is in good health!
# Child Specialist Doctor is checking health status for Nathasha...and found that {child.name} is in good health!
# Child Specialist Doctor is checking health status for Clint...and found that {child.name} is NOT in good health. Please go to the hospital someday.
#
# Leader comes to examine the school's work.
# Leader examines Steve's work.
# Leader examines Tony's work.
# Leader kindly says hi to Bruce.
# Leader kindly says hi to Nathasha.
# Leader kindly says hi to Clint.
