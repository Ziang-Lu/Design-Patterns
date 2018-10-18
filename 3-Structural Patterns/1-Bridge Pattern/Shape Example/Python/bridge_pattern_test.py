#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Application that actually uses Bridge Pattern.
"""

__author__ = 'Ziang Lu'

from color_implementor import BlueImplementor, RedImplementor
from shape import Circle, Rectangle


def main():
    rectangle = Rectangle(center_x=0.0, center_y=0.0, width=10.0, height=5.0)
    rectangle.draw()
    circle = Circle(x=0.0, y=0.0, radius=7.0)
    circle.draw()

    color = input("Enter the color to fill: 'red' or 'blue': ")
    if color.lower() == 'red':
        color_impl = RedImplementor.get_instance()
    elif color.lower() == 'blue':
        color_impl = BlueImplementor.get_instance()
    else:
        return
    rectangle.set_color_implementor(color_impl)
    rectangle.fill_color()
    circle.set_color_implementor(color_impl)
    circle.fill_color()


if __name__ == '__main__':
    main()

# Output:
# Rectangle[center_x=0.0, center_y=0.0, width=10.0, height=5.0] has been drawn without any color.
# Circle[x=0.0, y=0.0, radius=7.0] has been drawn without any color.
# Enter the color to fill: 'red' or 'blue': red
# Rectangle[center_x=0.0, center_y=0.0, width=10.0, height=5.0] is filled with red color using RedImplementor.
# Circle[x=0.0, y=0.0, radius=7.0] is filled with red color using RedImplementor.
