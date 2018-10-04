#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Application that actually uses Bridge Pattern.
"""

__author__ = 'Ziang Lu'

from color_implementor import BlueImplementor, RedImplementor
from shape import Circle, Rectangle


def main():
    rectangle = Rectangle()
    rectangle.draw()
    circle = Circle()
    circle.draw()

    color = input("Enter the color to fill: 'red' or 'blue': ")
    if color.lower() == 'red':
        color_implementor = RedImplementor()
    elif color.lower() == 'blue':
        color_implementor = BlueImplementor()
    else:
        return
    rectangle.set_color_implementor(color_implementor)
    rectangle.fill_color()
    circle.set_color_implementor(color_implementor)
    circle.fill_color()


if __name__ == '__main__':
    main()

# Output:
# Rectangle has been drawn without any color.
# Circle has been drawn without any color.
# Enter the color to fill: 'red' or 'blue': red
# Rectangle is filled with red color using RedImplementor.
# Circle is filled with red color using RedImplementor.
