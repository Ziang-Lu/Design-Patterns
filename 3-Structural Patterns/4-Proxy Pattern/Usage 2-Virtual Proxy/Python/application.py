#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Application that actually uses Proxy Pattern.
"""

__author__ = 'Ziang Lu'

from image import ImageProxy


def main():
    image = ImageProxy('10MB_photo.jpg')

    print('First time calling display_method():')
    image.display_image()

    # Output:
    # First time calling display_method():
    # Loading 10MB_photo.jpg from disk... This may take around 3 seconds.
    # Displaying 10MB_photo.jpg

    print()

    print('Second time calling display_method():')
    image.display_image()

    # Output:
    # Second time calling display_method():
    # Displaying 10MB_photo.jpg


if __name__ == '__main__':
    main()
