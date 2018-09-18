#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Shape module.
"""

__author__ = 'Ziang Lu'

from shape import (
    BlueShapeDecorator, Circle, Rectangle, RedShapeDecorator,
    YellowOutlineShapeDecorator
)


def main():
    rectangle = BlueShapeDecorator(Rectangle())
    rectangle.draw()

    print()

    circle = YellowOutlineShapeDecorator(RedShapeDecorator(Circle()))
    circle.draw()


if __name__ == '__main__':
    main()

# Output:
# Shape: Rectangle has been drawn.
# Color: Blue has been applied to Shape: Rectangle.
#
# Shape: Circle has been drawn.
# Color: Red has been applied to Shape: Circle.
# Outline: Yellow has been applied to Shape: Circle
