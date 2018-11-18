#!usr/bin/env python3
# -*- coding: utf-8 -*-

__author__ = 'Ziang Lu'

"""
Module for Facade Pattern models.
"""

from typing import List


class CPU:
    """
    Simple CPU representation as a sub-component of a computer.
    """
    __slots__ = []

    def freeze(self) -> None:
        """
        Freezes this CPU.
        :return: None
        """
        print('Freezing CPU...')

    def jump(self, position: int) -> None:
        """
        Jumps to the given position.
        :param position: int
        :return: None
        """
        print(f'CPU jumped to {position:X} and ready to execute instructions.')

    def execute(self) -> None:
        """
        Execute instructions.
        :return: None
        """
        print('CPU executing instructions...')


class Memory:
    """
    Simple memory representation as a sub-component of a computer.
    """
    __slots__ = []

    def load_data(self, data: List[bytes], position: int) -> None:
        """
        Loads the given data tot he given position in memory.
        :param data: list[bytes]
        :param position: int
        :return: None
        """
        print(f'Successfully loaded {len(data)}B data @{position:X} in memory')


class HardDrive:
    """
    Simple hard drive representation as a sub-component of a computer.
    """

    def read_data(self, lba: int, size: int) -> List[bytes]:
        """
        Reads the given size of data from the given LBA in the hard drive.
        :param lba: int
        :param size: int
        :return: list[bytes]
        """
        read_data = [b'0'] * size
        print(f'Reading {size}B data from the hard drive @{lba:X}')
        return read_data


class ComputerFacade:
    """
    Facade class for computer that serves as a front-facing interface masking
    more complex sub-components to simplify the usage for client and minimize
    the dependencies between the client and the sub-components.
    """
    __slots__ = ['_cpu', '_memory', '_hard_drive']

    _BOOT_ADDRESS = 0xABCD
    _BOOT_SECTOR = 1
    _SECTOR_SIZE = 1024

    def __init__(self):
        """
        Default constructor.
        """
        self._cpu = CPU()
        self._memory = Memory()
        self._hard_drive = HardDrive()

    def start(self) -> None:
        """
        Starts this computer.
        :return: None
        """
        self._cpu.freeze()
        self._memory.load_data(
            self._hard_drive.read_data(self._BOOT_SECTOR, self._SECTOR_SIZE),
            self._BOOT_ADDRESS
        )
        self._cpu.jump(self._BOOT_ADDRESS)
        self._cpu.execute()
