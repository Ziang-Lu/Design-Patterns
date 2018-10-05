#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
StorageRoom module that works as "Caretaker".
This module is responsible for keeping a collection of "Memento", but never
examines or operates on the contents of a "Memento".
"""

__author__ = 'Ziang Lu'

from living_room import IMemento, LedTV, LivingRoom, Sofa


class StorageRoom(object):
    __slots__ = ['_memo_map']

    def __init__(self):
        self._memo_map = {}
        # Stored mapping between tags and the corresponding mementos

    def get_memento(self, tag: str) -> IMemento:
        """
        get the memento associated with the given tag.
        :param tag: str
        :return: IMemento
        """
        return self._memo_map[tag]

    def add_memento(self, tag: str, memo: IMemento) -> None:
        """
        Stores the given memento associated with the given tag.
        :param tag: str
        :param memeo: IMemento
        :return: None
        """
        self._memo_map[tag] = memo


def main():
    living_room = LivingRoom()
    storage_room = StorageRoom()

    # Decorate the living room as classical style
    living_room.set_led_tv(LedTV(size=42, usb_support=False, price=800.0))
    living_room.set_sofa(Sofa(size=5, style='classical'))

    # Save the classical style of the living room in a memento
    classical = living_room.create_memento()
    classical_tag = 'Classical-Type Decoration'
    storage_room.add_memento(classical_tag, classical)
    # Decorate the living room as modern style
    living_room.set_led_tv(LedTV(size=46, usb_support=True, price=1000.0))
    living_room.set_sofa(Sofa(size=7, style='modern'))
    print(f'Living Room current state: {living_room}')

    # Restore the living room to the previous saved classical style
    print()
    print(f'Living Room restoring to {classical_tag}...')
    living_room.restore(storage_room.get_memento(classical_tag))
    print(f'Living Room current state: {living_room}')


if __name__ == '__main__':
    main()

# Output:
# Created a memento for Living Room: Memento [led_tv=LedTV[size=42, usb_support=False, price=800.0], sofa=Sofa[size=5, style=classical]]
# Living Room current state: LivingRoom[led_tv=LedTV[size=46, usb_support=True, price=1000.0], sofa=Sofa[size=7, style=modern]]
#
# Living Room restoring to Classical-Style Decoration...
# Living Room current state: LivingRoom[led_tv=LedTV[size=42, usb_support=False, price=800.0], sofa=Sofa[size=5, style=classical]]
