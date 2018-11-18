#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Application that actually uses Flyweight Pattern.
"""

__author__ = 'Ziang Lu'

from color import Color
from flyweight.cirlcle import SharedCircle, UnsharedCircle
from flyweight.rect import SharedRectangle, UnsharedRectangle


class FlyweightShapeFactory:
    """
    FlyweightShapeFactory class that actually uses Flyweight Pattern.
    Flyweight Pattern stores already existing similar objects
    ("ConcreteFlyweight") in a cache, so that they can easily be used (shared),
    and creates a new object only when no matching object is found.

    This class is implemented as a singleton class.
    """

    @classmethod
    def get_instance(cls):
        """
        Gets the singleton instance.
        :return: FlyweightShapeFactory
        """
        return cls.__new__(cls)

    def __new__(cls, *args, **kwargs):
        if not hasattr(cls, '_instance'):
            cls._instance = super().__new__(cls)
            cls._instance.__init__()
        return cls._instance

    def __init__(self):
        """
        Default constructor.
        """
        self._flyweight_shapes = {}

    def get_flyweight_shape(self, shape_type: str):
        """
        Gets the flyweight shape of the given type.
        :param shape_type: str
        :return: FlyweightShape
        """
        if shape_type not in self._flyweight_shapes:
            if shape_type.lower() == 'circle':
                self._flyweight_shapes['circle'] = SharedCircle.get_instance()
            elif shape_type.lower() == 'rectangle':
                self._flyweight_shapes['rectangle'] = SharedRectangle.get_instance()
        return self._flyweight_shapes[shape_type]


def main():
    shape_factory = FlyweightShapeFactory.get_instance()

    # In this application, we need to create a large number of objects of
    # similar nature, which would have consumed a large, unaccepted amount of
    # memory and decrease the performance.
    #
    # By using Flyweight Pattern, we first get the shared "ConcreteFlyweight"
    # from the "FlyweightFactory", and then customize it to get the
    # "UnsharedConcreteFlyweight" we desire.
    # In this way, the number of physically created objects is greatly reduced,
    # and thus the load on memory is reduced and the  performance is improved.

    # We were supposed to get 90000 green Circle objects, but here we just get 5
    # for better display.
    for _ in range(5):
        # First get the SharedCircle from the FlyweightShapeFactory
        shared_circle = shape_factory.get_flyweight_shape('circle')

        # Customize this SharedCircle to get the UnsharedCircle we desire
        unshared_circle = UnsharedCircle(shared_circle)
        unshared_circle.set_radius(9.0)
        unshared_circle.draw(Color.GREEN)

    # We were supposed to get 90000 purple Circle objects, but here we just get
    # 5 for better display.
    for _ in range(5):
        # First get the SharedCircle from the FlyweightShapeFactory
        shared_circle = shape_factory.get_flyweight_shape('circle')

        # Customize this SharedCircle to get the UnsharedCircle we desire
        unshared_circle = UnsharedCircle(shared_circle)
        unshared_circle.set_radius(9.0)
        unshared_circle.draw(Color.PURPLE)

    # We were supposed to get 80000 orange Circle objects, but here we just get
    # 4 for better display.
    for _ in range(4):
        # First get the SharedCircle from the FlyweightShapeFactory
        shared_circle = shape_factory.get_flyweight_shape('circle')

        # Customize this SharedCircle to get the UnsharedCircle we desire
        unshared_circle = UnsharedCircle(shared_circle)
        unshared_circle.set_radius(8.0)
        unshared_circle.draw(Color.ORANGE)

    # We were supposed to get 70000 black Circle objects, but here we just get 3
    # for better display.
    for _ in range(3):
        # First get the SharedCircle from the FlyweightShapeFactory
        shared_circle = shape_factory.get_flyweight_shape('circle')

        # Customize this SharedCircle to get the UnsharedCircle we desire
        unshared_circle = UnsharedCircle(shared_circle)
        unshared_circle.set_radius(7.0)
        unshared_circle.draw(Color.BLACK)

    print()

    # First get the SharedRectangle from the FlyweightShapeFactory
    shared_rect = shape_factory.get_flyweight_shape('rectangle')

    # Customize this SharedRectangle to get the UnsharedRectangle we desire
    unshared_rect = UnsharedRectangle(shared_rect)
    unshared_rect.set_width(8.0)
    unshared_rect.set_height(6.0)
    unshared_rect.draw(Color.RED)


if __name__ == '__main__':
    main()

# Output:
# Creating a Shared Circle without color: SharedCircle [x=0.0, y=0.0]
# Circle has been drawn with Color.GREEN: UnsharedCircle [x=0.0, y=0.0, radius=9.0, color=Color.GREEN]
# Circle has been drawn with Color.GREEN: UnsharedCircle [x=0.0, y=0.0, radius=9.0, color=Color.GREEN]
# Circle has been drawn with Color.GREEN: UnsharedCircle [x=0.0, y=0.0, radius=9.0, color=Color.GREEN]
# Circle has been drawn with Color.GREEN: UnsharedCircle [x=0.0, y=0.0, radius=9.0, color=Color.GREEN]
# Circle has been drawn with Color.GREEN: UnsharedCircle [x=0.0, y=0.0, radius=9.0, color=Color.GREEN]
# Circle has been drawn with Color.PURPLE: UnsharedCircle [x=0.0, y=0.0, radius=9.0, color=Color.PURPLE]
# Circle has been drawn with Color.PURPLE: UnsharedCircle [x=0.0, y=0.0, radius=9.0, color=Color.PURPLE]
# Circle has been drawn with Color.PURPLE: UnsharedCircle [x=0.0, y=0.0, radius=9.0, color=Color.PURPLE]
# Circle has been drawn with Color.PURPLE: UnsharedCircle [x=0.0, y=0.0, radius=9.0, color=Color.PURPLE]
# Circle has been drawn with Color.PURPLE: UnsharedCircle [x=0.0, y=0.0, radius=9.0, color=Color.PURPLE]
# Circle has been drawn with Color.ORANGE: UnsharedCircle [x=0.0, y=0.0, radius=8.0, color=Color.ORANGE]
# Circle has been drawn with Color.ORANGE: UnsharedCircle [x=0.0, y=0.0, radius=8.0, color=Color.ORANGE]
# Circle has been drawn with Color.ORANGE: UnsharedCircle [x=0.0, y=0.0, radius=8.0, color=Color.ORANGE]
# Circle has been drawn with Color.ORANGE: UnsharedCircle [x=0.0, y=0.0, radius=8.0, color=Color.ORANGE]
# Circle has been drawn with Color.BLACK: UnsharedCircle [x=0.0, y=0.0, radius=7.0, color=Color.BLACK]
# Circle has been drawn with Color.BLACK: UnsharedCircle [x=0.0, y=0.0, radius=7.0, color=Color.BLACK]
# Circle has been drawn with Color.BLACK: UnsharedCircle [x=0.0, y=0.0, radius=7.0, color=Color.BLACK]
#
# Creating a Shared Rectangle without color: SharedRectangle [left_bottom_x=0.0, left_bottom_y=0.0]
# Rectangle has been drawn with Color.RED: UnsharedRectangle [left_bottom_x=0.0, left_bottom_y=0.0, width=8.0, height=6.0, color=Color.RED]
