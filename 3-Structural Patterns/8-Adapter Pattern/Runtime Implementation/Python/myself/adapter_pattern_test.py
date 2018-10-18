#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Application that actually uses Adapter Pattern runtime implementation.
"""

__author__ = 'Ziang Lu'

from friend import CorrectionTape, InkPen, PilotPen, Tape
from myself.adapters.adapter import AdapterFactory
from myself.adapters.correction_tape_adapter import CorrectionTapeAdapter
from myself.adapters.ink_pen_adapter import InkPenAdapter
from myself.adapters.pilot_pen_adapter import PilotPenAdapter
from myself.adapters.tape_adapter import TapeAdapter
from myself.assignment_work import AssignmentWork, Eraser, Pen


def main():
    assignment = AssignmentWork()

    # Get the adapters factory, and register the adapters in the factory
    adapter_factory = AdapterFactory.get_instance()
    adapter_factory.register_adapter(from_=InkPen, to=Pen,
                                     adapter=InkPenAdapter)
    adapter_factory.register_adapter(from_=PilotPen, to=Pen,
                                     adapter=PilotPenAdapter)
    adapter_factory.register_adapter(from_=CorrectionTape, to=Eraser,
                                     adapter=CorrectionTapeAdapter)
    adapter_factory.register_adapter(from_=Tape, to=Eraser, adapter=TapeAdapter)

    # AT RUNTIME looks up and get the adapters which is able to adapt an InkPen
    # object to a Pen object
    ink_pen_adapter = adapter_factory.get_adapter_from_to(from_=InkPen, to=Pen)
    # Adapts an InkPen object from a friend to a Pen object
    ink_pen_as_pen = ink_pen_adapter.adapt(ink_pen=InkPen())

    assignment.set_pen(pen=ink_pen_as_pen)

    # AT RUNTIME looks up and get the adapters which is able to adapt a
    # CorrectionTape object to an Eraser object
    correction_tape_adapter = adapter_factory.get_adapter_from_to(
        from_=CorrectionTape, to=Eraser
    )
    correction_tape_as_eraser = correction_tape_adapter.adapt(CorrectionTape())

    assignment.set_eraser(eraser=correction_tape_as_eraser)

    assignment.do_assignment('This is the first line.')
    assignment.erase_content('Erase redundant contents')


if __name__ == '__main__':
    main()

# Output:
# 'This is the first line.' is written in Ink Pen.
# 'Erase redundant contents' is dashed out by Correction Tape.
