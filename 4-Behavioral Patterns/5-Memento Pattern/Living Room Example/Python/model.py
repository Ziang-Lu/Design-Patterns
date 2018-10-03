#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Model module.
"""

__author__ = 'Ziang Lu'


class LedTV(object):
    __slots__ = ['_size', '_usb_support', '_price']

    def __init__(self, size: int, usb_support: bool, price: float):
        """
        Constructor with parameter.
        :param size: int
        :param usb_support: bool
        :param price: float
        """
        self._size = size
        self._usb_support = usb_support
        self._price = price

    def __repr__(self):
        return f'LedTV[size={self._size}, usb_support={self._usb_support}, ' \
               f'price={self._price}]'


class Sofa(object):
    __slots__ = ['_size']

    def __init__(self, size: int):
        """
        Constructor with parameter.
        :param size: int
        """
        self._size = size

    def __repr__(self):
        return f'Sofa[size={self._size}]'


class Memento(object):
    """
    Memento class.
    This class holds a snapshot of the internal state of the "Originator".
    This is like a wrapper (a packing box) of the internal state of the
    "Originator".
    """
    __slots__ = ['_led_tv', '_sofa']

    def __init__(self, lev_tv: LedTV, sofa: Sofa):
        """
        Constructor with parameter.
        :param lev_tv: LedTV
        :param sofa: Sofa
        """
        self._led_tv = lev_tv
        self._sofa = sofa

    @property
    def led_tv(self) -> LedTV:
        """
        Accessor of led_tv.
        :return: LedTV
        """
        return self._led_tv

    @property
    def sofa(self) -> Sofa:
        """
        Accessor of sofa.
        :return: Sofa
        """
        return self._sofa

    def __repr__(self):
        return f'Memento [led_tv={self._led_tv}, sofa={self._sofa}]'


class StorageRoom(object):
    """
    StorageRoom class that works as "Caretaker".
    This class is responsible for keeping a collection of "Memento", but never
    examines or operates on the contents of a "Memento".
    """
    __slots__ = ['_mementos']

    def __init__(self):
        """
        Default constructor.
        """
        self._mementos = {}

    def get_memento(self, tag: str) -> Memento:
        """
        Gets the memento associated with the given tag from this storage room.
        :param tag: str
        :return: Memento
        """
        return self._mementos[tag]

    def add_memento(self, tag: str, memento: Memento) -> None:
        """
        Stores the given memento associated with the given tag in this storage
        room.
        :param tag: str
        :param memento: Memento
        :return: None
        """
        self._mementos[tag] = memento


class LivingRoom(object):
    """
    LivingRoom class that works as "Originator".
    """
    __slots__ = ['_led_tv', '_sofa']

    def __init__(self):
        """
        Default constructor.
        """
        self._led_tv = None
        self._sofa = None

    def set_led_tv(self, led_tv: LedTV) -> None:
        """
        Mutator of led_tv.
        :param led_tv: LedTV
        :return:
        """
        self._led_tv = led_tv

    def set_sofa(self, sofa: Sofa) -> None:
        """
        Mutator of sofa.
        :param sofa: Sofa
        :return:
        """
        self._sofa = sofa

    def create_memento_and_store(self, storage_room: StorageRoom,
                                 tag: str) -> None:
        """
        Creates a memento containing a snapshot of the internal state of this
        living room and stores it in the given storage room.
        :param storage_room: StorageRoom
        :param tag: str
        :return: None
        """
        memento = self._create_memento()
        print(f'Created a memento for Living Room: {memento}')
        storage_room.add_memento(tag, memento)

    def _create_memento(self) -> Memento:
        """
        Private helper function to create a memento containing a snapshot of the
        internal state of this living room.
        :return: Memento
        """
        return Memento(self._led_tv, self._sofa)

    def restore_state(self, storage_room: StorageRoom, tag: str) -> None:
        """
        Restores the internal state of this living room associated with the
        given tag from the given storage room.
        :param storage_room: StorageRoom
        :param tag: str
        :return: None
        """
        print(f'Living Room restoring to {tag}...')
        self._restore(storage_room.get_memento(tag))

    def _restore(self, memento: Memento) -> None:
        """
        Private helper function to restore the internal state of this living
        room from the given memento.
        :param memento: Memento
        :return: None
        """
        self._led_tv = memento.led_tv
        self._sofa = memento.sofa

    def __repr__(self):
        return f'LivingRoom[led_tv={self._led_tv}, sofa={self._sofa}]'
