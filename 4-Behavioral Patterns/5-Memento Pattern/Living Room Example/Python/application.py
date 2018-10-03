#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Application that actually uses Memento Pattern.
"""

__author__ = 'Ziang Lu'

from model import LedTV, LivingRoom, Sofa, StorageRoom


def main():
    living_room = LivingRoom()
    living_room.set_led_tv(LedTV(size=42, usb_support=False, price=800.0))
    living_room.set_sofa(Sofa(size=5))

    storage_room = StorageRoom()
    living_room.create_memento_and_store(storage_room, tag="42-inch TV")
    living_room.set_led_tv(LedTV(size=46, usb_support=True, price=1000.0))

    living_room.create_memento_and_store(storage_room, tag="46-inch TV")
    living_room.set_led_tv(LedTV(size=50, usb_support=True, price=1200.0))
    print(f'Living Room current state: {living_room}')

    print()
    living_room.restore_state(storage_room, "42-inch TV")
    print(f'Living Room current state: {living_room}')

    print()
    living_room.restore_state(storage_room, "46-inch TV")
    print(f'Living Room current state: {living_room}')


if __name__ == '__main__':
    main()

# Output:
# Created a memento for Living Room: Memento [led_tv=LedTV[size=42, usb_support=False, price=800.0], sofa=Sofa[size=5]]
# Created a memento for Living Room: Memento [led_tv=LedTV[size=46, usb_support=True, price=1000.0], sofa=Sofa[size=5]]
# Living Room current state: LivingRoom[led_tv=LedTV[size=50, usb_support=True, price=1200.0], sofa=Sofa[size=5]]
#
# Living Room restoring to 42-inch TV...
# Living Room current state: LivingRoom[led_tv=LedTV[size=42, usb_support=False, price=800.0], sofa=Sofa[size=5]]
#
# Living Room restoring to 46-inch TV...
# Living Room current state: LivingRoom[led_tv=LedTV[size=46, usb_support=True, price=1000.0], sofa=Sofa[size=5]]
