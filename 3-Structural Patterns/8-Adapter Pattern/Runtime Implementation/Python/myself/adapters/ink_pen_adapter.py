#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Ink pen adapters module.
"""

__author__ = 'Ziang Lu'

from friend import InkPen
from myself.adapters.adapter import Adapter
from myself.assignment_work import Pen


class _InkPenAsPen(Pen):
    """
    Concrete InkPenAsPen class that works as "Adapter".

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

    def __init__(self, ink_pen: InkPen):
        """
        Constructor with parameter.
        :param ink_pen: InkPen
        """
        self._adaptee = ink_pen

    def write(self, text):
        self._adaptee.ink(text)


class InkPenAdapter(Adapter):
    """
    Concrete InkPenToPenAdapter class.
    This class adapts an InkPen object to a Pen object, where InkPen and Pen are
    otherwise independent or incompatible systems.
    """
    __slots__ = []

    def adapt(self, ink_pen: InkPen) -> _InkPenAsPen:
        return _InkPenAsPen(ink_pen)
