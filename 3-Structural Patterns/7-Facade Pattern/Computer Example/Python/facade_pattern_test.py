#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Application that actually uses Facade Pattern.
Note that by using Facade Pattern, the application now doesn't necessarily need
to know the complex logic and implementation details in sub-components, but only
need to interact with the Facade.
"""

__author__ = 'Ziang Lu'

from computer import ComputerFacade


def main():
    computer = ComputerFacade()
    computer.start()


if __name__ == '__main__':
    main()

# Output:
# Reading 1024B data from the hard drive @1...
# Successfully loaded 1024B data @ABCD in memory
# CPU jumped to @ABCD and ready to execute instructions.
# CPU executing instructions
