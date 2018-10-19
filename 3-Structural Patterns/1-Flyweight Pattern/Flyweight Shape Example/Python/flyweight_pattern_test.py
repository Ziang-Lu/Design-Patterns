#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Application that actually uses Flyweight Pattern.
"""

__author__ = 'Ziang Lu'

from color import Color
from flyweight import FlyweightShapeFactory


def main():
    shape_factory = FlyweightShapeFactory.get_instance()

    # In this application, we need to create a large number of objects of
    # similar nature, which would have consumed a large amount of memory and
    # decrease the performance.
    #
    # By using Flyweight Pattern, we first get the shared  "ConcreteFlyweight"
    # from the "FlyweightFactory", and then customize it to get the
    # "UnsharedConcreteFlyweight" we desire.
    # In this way, the load on memory is reduced and the  performance is
    # improved.

    for _ in range(5):
        # First get the SharedCircle from the FlyweightShapeFactory
        circle = shape_factory.get_flyweight_shape('circle')

        # Customize this SharedCircle to get the UnsharedCircle we desire
        circle.set_radius(9.0)
        circle.draw(Color.GREEN)

    for _ in range(5):
        # First get the SharedCircle from the FlyweightShapeFactory
        circle = shape_factory.get_flyweight_shape('circle')

        # Customize this SharedCircle to get the UnsharedCircle we desire
        circle.set_radius(9.0)
        circle.draw(Color.PURPLE)

    for _ in range(4):
        # First get the SharedCircle from the FlyweightShapeFactory
        circle = shape_factory.get_flyweight_shape('circle')

        # Customize this SharedCircle to get the UnsharedCircle we desire
        circle.set_radius(8.0)
        circle.draw(Color.ORANGE)

    for _ in range(3):
        # First get the SharedCircle from the FlyweightShapeFactory
        circle = shape_factory.get_flyweight_shape('circle')

        # Customize this SharedCircle to get the UnsharedCircle we desire
        circle.set_radius(7.0)
        circle.draw(Color.BLACK)

    print()

    # First get the SharedRectangle from the FlyweightShapeFactory
    rectangle = shape_factory.get_flyweight_shape('rectangle')

    # Customize this SharedRectangle to get the UnsharedRectangle we desire
    rectangle.set_width(8.0)
    rectangle.set_height(6.0)
    rectangle.draw(Color.RED)


if __name__ == '__main__':
    main()

# Output:
# Creating a Shared Circle without color: Circle@-0x7fffffffef6727ea [x=0.0, y=0.0, radius=5.0, color=None]
# Circle has been drawn with GREEN: Circle@-0x7fffffffef6727ea [x=0.0, y=0.0, radius=9.0, color=GREEN]
# Circle has been drawn with GREEN: Circle@-0x7fffffffef6727ea [x=0.0, y=0.0, radius=9.0, color=GREEN]
# Circle has been drawn with GREEN: Circle@-0x7fffffffef6727ea [x=0.0, y=0.0, radius=9.0, color=GREEN]
# Circle has been drawn with GREEN: Circle@-0x7fffffffef6727ea [x=0.0, y=0.0, radius=9.0, color=GREEN]
# Circle has been drawn with GREEN: Circle@-0x7fffffffef6727ea [x=0.0, y=0.0, radius=9.0, color=GREEN]
# Circle has been drawn with PURPLE: Circle@-0x7fffffffef6727ea [x=0.0, y=0.0, radius=9.0, color=PURPLE]
# Circle has been drawn with PURPLE: Circle@-0x7fffffffef6727ea [x=0.0, y=0.0, radius=9.0, color=PURPLE]
# Circle has been drawn with PURPLE: Circle@-0x7fffffffef6727ea [x=0.0, y=0.0, radius=9.0, color=PURPLE]
# Circle has been drawn with PURPLE: Circle@-0x7fffffffef6727ea [x=0.0, y=0.0, radius=9.0, color=PURPLE]
# Circle has been drawn with PURPLE: Circle@-0x7fffffffef6727ea [x=0.0, y=0.0, radius=9.0, color=PURPLE]
# Circle has been drawn with ORANGE: Circle@-0x7fffffffef6727ea [x=0.0, y=0.0, radius=8.0, color=ORANGE]
# Circle has been drawn with ORANGE: Circle@-0x7fffffffef6727ea [x=0.0, y=0.0, radius=8.0, color=ORANGE]
# Circle has been drawn with ORANGE: Circle@-0x7fffffffef6727ea [x=0.0, y=0.0, radius=8.0, color=ORANGE]
# Circle has been drawn with ORANGE: Circle@-0x7fffffffef6727ea [x=0.0, y=0.0, radius=8.0, color=ORANGE]
# Circle has been drawn with BLACK: Circle@-0x7fffffffef6727ea [x=0.0, y=0.0, radius=7.0, color=BLACK]
# Circle has been drawn with BLACK: Circle@-0x7fffffffef6727ea [x=0.0, y=0.0, radius=7.0, color=BLACK]
# Circle has been drawn with BLACK: Circle@-0x7fffffffef6727ea [x=0.0, y=0.0, radius=7.0, color=BLACK]
#
# Creating a Shared Rectangle without color: Rectangle@-0x7fffffffefe60811 [left_bottom_x=0.0, left_bottom_y=0.0, width=4.0, height=3.0, color=None]
# Rectangle has been drawn with RED: Rectangle@-0x7fffffffefe60811 [left_bottom_x=0.0, left_bottom_y=0.0, width=8.0, height=6.0, color=RED]

# From the hash code, we can see that the same SharedCircle and SharedRectangle
# objects are being reused.
