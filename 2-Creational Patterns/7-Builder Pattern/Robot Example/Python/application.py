#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Application that actually makes use of Builder Pattern to create robots.
"""

__author__ = 'Ziang Lu'

from builder import NewRobotBuilder, OldRobotBuilder, RobotEngineer


def main():
    engineer = RobotEngineer()

    old_robot = engineer.make_robot(OldRobotBuilder())
    print('Robot successfully built.')
    print(old_robot)

    new_robot = engineer.make_robot(NewRobotBuilder())
    print('Robot successfully built.')
    print(new_robot)


if __name__ == '__main__':
    main()

# Output:
# Robot successfully built.
# Robot [head=Tin Head, torso=Tin Torso, arms=Blowtorch Arms, legs=Roller Skates]
# Robot successfully built.
# Robot [head=Vibranium Head, torso=Vibranium Torso, arms=Artificial Flesh Arms, legs=Jet-Propelled Legs]
