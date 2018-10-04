#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
StorageRoom module that works as "Caretaker".
This module is responsible for keeping a collection of "Memento", but never
examines or operates on the contents of a "Memento".
"""

__author__ = 'Ziang Lu'

from living_room import IMemento, LedTV, LivingRoom, Sofa

memo_map = {}  # Stored mapping between tags and the corresponding mementos


def _get_memento(tag: str) -> IMemento:
    """
    Private helper function to get the memento associated with the given tag.
    :param tag: str
    :return: IMemento
    """
    return memo_map[tag]


def _add_memento(tag: str, memo: IMemento) -> None:
    """
    Private helper function to store the given memento associated with the given
    tag.
    :param tag: str
    :param memo: IMemento
    :return: None
    """
    memo_map[tag] = memo


def main():
    living_room = LivingRoom()

    # Decorate the living room as classical style
    living_room.set_led_tv(LedTV(size=42, usb_support=False, price=800.0))
    living_room.set_sofa(Sofa(size=5, style='classical'))

    # Save the classical style of the living room in a memento
    classical = living_room.create_memento()
    classical_tag = 'Classical-Type Decoration'
    _add_memento(classical_tag, classical)
    # Decorate the living room as modern style
    living_room.set_led_tv(LedTV(size=46, usb_support=True, price=1000.0))
    living_room.set_sofa(Sofa(size=7, style='modern'))
    print(f'Living Room current state: {living_room}')

    # Restore the living room to the previous saved classical style
    print()
    print(f'Living Room restoring to {classical_tag}...')
    living_room.restore(_get_memento(classical_tag))
    print(f'Living Room current state: {living_room}')


if __name__ == '__main__':
    main()

# Output:
# Created a memento for Living Room: Memento [led_tv=LedTV[size=42, usb_support=False, price=800.0], sofa=Sofa[size=5, style=classical]]
# Living Room current state: LivingRoom[led_tv=LedTV[size=46, usb_support=True, price=1000.0], sofa=Sofa[size=7, style=modern]]
#
# Living Room restoring to Classical-Style Decoration...
# Living Room current state: LivingRoom[led_tv=LedTV[size=42, usb_support=False, price=800.0], sofa=Sofa[size=5, style=classical]]
