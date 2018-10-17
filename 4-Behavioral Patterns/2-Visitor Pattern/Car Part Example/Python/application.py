#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Application module.
"""

__author__ = 'Ziang Lu'

from car import Car


def main():
    car = Car()

    car.print_car_parts()
    print()
    car.render_car_parts()
    print()
    car.upgrade_car_parts()


if __name__ == '__main__':
    main()

# Output:
# Preparing to print car parts...
# Car Part Printer prints an engine: Engine[color=Color.GRAY, horsepower=200]
# Car Part Printer prints a wheel: Wheel[color=Color.GRAY, level=1]
# Car Part Printer prints a wheel: Wheel[color=Color.GRAY, level=1]
# Car Part Printer prints a wheel: Wheel[color=Color.GRAY, level=1]
# Car Part Printer prints a wheel: Wheel[color=Color.GRAY, level=1]
# Car Part Printer prints a light: Light[color=Color.YELLOW, lightness=1]
# Car Part Printer prints a light: Light[color=Color.YELLOW, lightness=1]
#
# Preparing to render car parts...
# Car Part Renderer renders Engine with WHITE.
# Car Part Renderer renders Wheel with WHITE.
# Car Part Renderer renders Wheel with BLACK.
# Car Part Renderer renders Wheel with GRAY.
# Car Part Renderer renders Wheel with BLACK.
# Car Part Renderer renders Light with WHITE.
# Car Part Renderer renders Light with RED.
#
# Preparing to upgrade car parts...
# Car Part Upgrader upgrades an Engine to Engine[color=Color.WHITE, horsepower=250]
# Car Part Upgrader upgrades a Wheel to Wheel[color=Color.WHITE, level=2]
# Car Part Upgrader upgrades a Wheel to Wheel[color=Color.BLACK, level=2]
# Car Part Upgrader upgrades a Wheel to Wheel[color=Color.GRAY, level=2]
# Car Part Upgrader upgrades a Wheel to Wheel[color=Color.BLACK, level=2]
# Car Part Upgrader upgrades a Light to Light[color=Color.WHITE, lightness=2]
# Car Part Upgrader upgrades a Light to Light[color=Color.RED, lightness=2]
