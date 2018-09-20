#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Application that actually uses the concrete factories and abstract products.
"""

__author__ = 'Ziang Lu'

from factory_creator import FancyDocumentCreator, ModernDocumentCreator


def main():
    # Get instances from a fancy creator

    fancy_creator = FancyDocumentCreator.get_instance()

    # Let the factory to produce abstract products through the factory methods
    letter = fancy_creator.create_letter()
    print(letter)
    resume = fancy_creator.create_resume()
    print(resume)

    # Get instances from a modern creator

    modern_creator = ModernDocumentCreator.get_instance()
    letter = modern_creator.create_letter()
    print(letter)
    resume = modern_creator.create_resume()
    print(resume)


if __name__ == '__main__':
    main()

# Output:
# This is a FANCY LETTER.
# This is a FANCY RESUME.
# This is a MODERN LETTER.
# This is a MODERN RESUME.
