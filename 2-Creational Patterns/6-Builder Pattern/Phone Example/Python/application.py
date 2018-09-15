#!usr/bin/env python3
# -*- coding: utf-8 -*-

__author__ = 'Ziang Lu'

"""
Application that actually makes use of Builder Pattern to create phones.
"""

from builder import PhoneBuilder


def main():
    phone_builder = PhoneBuilder()
    try:
        phone_builder = phone_builder.set_os('Android').set_ram(2).set_battery(3000)
        # Note that in this way, we don't need to explicitly create phones in a
        # complex way by specifying all the five parameters in the Phone()
        # constructor
        # Instead, we can make use of a phone builder to create and assemble the
        # parts of a phone, and can even omit some parameters, to create a phone
        phone = phone_builder.get_phone()
        print(phone)
    except ValueError:
        print('Not enough specification to create a phone.')


if __name__ == '__main__':
    main()

# Output:
# Phone [os=Android, processor=None, ram=2, scree_size=0.0, batter=2]
