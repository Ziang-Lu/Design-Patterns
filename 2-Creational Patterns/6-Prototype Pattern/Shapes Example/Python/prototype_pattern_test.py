#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Application that actually uses Prototype Pattern.
"""

__author__ = 'Ziang Lu'

import copy

from prototype import Circle, Rectangle, Shape, Square


class ShapeFactory:
    """
    ShapeFactory class that clones abstract shapes.
    """
    __slots__ = []

    _cached_shapes = {}

    @classmethod
    def load_cache(cls) -> None:
        """
        Loads the shape prototypes.
        This could be done by various queries. However for simplicity, we just
        create three shapes.
        :return: None
        """
        cls._cached_shapes['Rectangle'] = Rectangle()
        cls._cached_shapes['Square'] = Square()
        cls._cached_shapes['Circle'] = Circle()

    @classmethod
    def get_shape(cls, type_: str) -> Shape:
        """
        Clones from the shape prototype of the given type and stores it in its
        own location in memory.
        :param type_: str
        :return: Shape
        """
        if type_ not in cls._cached_shapes:
            return None
        prototype = cls._cached_shapes[type_]
        return copy.deepcopy(prototype)


def main():
    # Load the shape prototype
    ShapeFactory.load_cache()

    cloned_rectangle = ShapeFactory.get_shape('Rectangle')
    if cloned_rectangle:
        print(f'Shape: {cloned_rectangle.type}')
        cloned_rectangle.draw()
    cloned_square = ShapeFactory.get_shape('Square')
    if cloned_square:
        print(f'Shape: {cloned_square.type}')
        cloned_square.draw()
    cloned_circle = ShapeFactory.get_shape('Circle')
    if cloned_circle:
        print(f'Shape: {cloned_circle.type}')
        cloned_circle.draw()


if __name__ == '__main__':
    main()

# Output:
# Shape: Rectangle
# In Rectangle.draw() method
# Shape: Square
# In Square.draw() method
# Shape: Circle
# In Circle.draw() method
