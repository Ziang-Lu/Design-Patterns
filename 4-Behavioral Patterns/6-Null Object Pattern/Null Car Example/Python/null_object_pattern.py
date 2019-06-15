#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Application module.
"""

__author__ = 'Ziang Lu'

from car import Car, CarFactory


def _drive_car(desired_max_speed: int, car: Car) -> None:
    """
    Private helper method to drive the given car to the given desired max speed.
    :param desired_max_speed: int
    :param car: Car
    :return: None
    """
    while not car.exceeding_speed(desired_max_speed):
        car.speed_up()


def main():
    desired_max_speed = int(input('Enter the desired max speed: '))
    # Assumption: desired_max_speed > 0
    car = CarFactory.get_car(desired_max_speed)

    # Normal way: Verify that car in fact is a Car instance instead of a null
    # reference before proceeding
    # if car:
    #     _drive_car(desired_max_speed, car)

    # By using Null Object Pattern, there is no need to verify that car is in
    # fact a Car instance. We can just go ahead and call methods on car.
    _drive_car(desired_max_speed, car)


if __name__ == '__main__':
    main()

# Input: 80
# Output:
# Enter the desired max speed: 80
# Creating a Fast Car
# Speeding up... Current speed: 10
# Speeding up... Current speed: 20
# Speeding up... Current speed: 30
# Speeding up... Current speed: 40
# Speeding up... Current speed: 50
# Speeding up... Current speed: 60
# Speeding up... Current speed: 70
# Speeding up... Current speed: 80
# Speeding up... Current speed: 90
#
# Input: 150
# Output:
# Null Car encountered
