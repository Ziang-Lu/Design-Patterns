#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Application that actually uses Composite Pattern.
"""

__author__ = 'Ziang Lu'

from model import Circle, GraphicComposite, Rectangle


def main():
    composite1 = GraphicComposite('Composite-1')
    composite1.add_graphic(Rectangle('Rectangle-1'))
    composite1.add_graphic(Rectangle('Rectangle-2'))
    composite1.add_graphic(Circle('Circle-1'))

    composite2 = GraphicComposite('Composite-2')
    composite2.add_graphic(Rectangle('Rectangle-3'))
    composite2.add_graphic(Circle('Circle-2'))

    composite = GraphicComposite('Overall Composite')
    composite.add_graphic(composite1)
    composite.add_graphic(composite2)

    composite.draw()
    print()
    composite1.translate(x=10, y=5)
    print()
    composite2.resize(times=1.4)


if __name__ == '__main__':
    main()

# Output:
# Drawing Overall Composite as follows:
# Drawing Composite-1 as follows:
# Drawing Rectangle-1
# Drawing Rectangle-2
# Drawing Circle-1
# Drawing Composite-2 as follows:
# Drawing Rectangle-3
# Drawing Circle-2
#
# Translating Composite-1 as follows:
# Translating Rectangle-1 by x=10, y=5
# Translating Rectangle-2 by x=10, y=5
# Translating Circle-1 by x=10, y=5
#
# Resizing Composite-2 as follows:
# Resizing Rectangle-3 by 1.4 times
# Resizing Circle-2 by 1.4 times
