#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Correction tape adapters module.
"""

__author__ = 'Ziang Lu'

from friend import CorrectionTape
from myself.adapters.adapter import Adapter
from myself.assignment_work import Eraser


class _CorrectionTapeAsEraser(Eraser):
    """
    Concrete CorrectionTapeAsEraser class that works as "Adapter".

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

    def __init__(self, correction_tape: CorrectionTape):
        """
        Constructor with parameter.
        :param correction_tape: CorrectionTape
        """
        self._adaptee = correction_tape

    def erase(self, text):
        self._adaptee.dash_out(text)


class CorrectionTapeAdapter(Adapter):
    """
    Concrete CorrectionTapeAdapter class.
    This class adapts a CorrectionTape object to an Eraser object, where
    CorrectionTape and Eraser are otherwise independent or incompatible systems.
    """
    __slots__ = []

    def adapt(self, correction_tape: CorrectionTape) -> _CorrectionTapeAsEraser:
        return _CorrectionTapeAsEraser(correction_tape)
