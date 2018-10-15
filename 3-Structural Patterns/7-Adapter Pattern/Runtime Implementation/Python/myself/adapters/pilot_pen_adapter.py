#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Pilot pen adapters module.
"""

__author__ = 'Ziang Lu'

from friend import PilotPen
from myself.adapters.adapter import Adapter
from myself.assignment_work import Pen


class _PilotPenAsPen(Pen):
    """
    Concrete PilotPenAsPen class that works as "Adapter".

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

    def __init__(self, pilot_pen: PilotPen):
        """
        Constructor with parameter.
        :param pilot_pen: PilotPen
        """
        self._adaptee = pilot_pen

    def write(self, text):
        self._adaptee.mark(text)


class PilotPenAdapter(Adapter):
    """
    Concrete PilotPenAdapter class.
    This class adapts a PilotPen object to a Pen object, where PilotPen and Pen
    are otherwise independent or incompatible systems.
    """
    __slots__ = []

    def adapt(self, pilot_pen: PilotPen) -> _PilotPenAsPen:
        return _PilotPenAsPen(pilot_pen)
