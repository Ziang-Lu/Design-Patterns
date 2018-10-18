#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Tape adapters module.
"""

__author__ = 'Ziang Lu'

from friend import Tape
from myself.adapters.adapter import Adapter
from myself.assignment_work import Eraser


class _TapeAsEraser(Eraser):
    """
    Concrete TapeAsEraser class that works as "Adapter".

    Note that in this implementations, we uses Object Adapter:
     - Since we cannot change the "Target" interface, in order to keep the
       original API, we create an "Adapter" class that implements the "Target"
       interface.
     - In order to make the "Target" interface and the "Adaptee" work together,
       in the "Adapter" class, we simply keep a referent to the "Adaptee"
       object, and delegate the request from the client to this "Adaptee"
       object.
    """
    __slots__ = ['_adaptee']

    def __init__(self, tape: Tape):
        """
        Constructor with parameter.
        :param tape: Tape
        """
        self._adaptee = tape

    def erase(self, text):
        self._adaptee.stick_out(text)


class TapeAdapter(Adapter):
    """
    Concrete TapeAdapter class.
    This class adapts a Tape object to an Eraser object, where Tape and Eraser
    are otherwise independent or incompatible systems.
    """
    __slots__ = []

    def adapt(self, tape: Tape) -> _TapeAsEraser:
        return _TapeAsEraser(tape)
