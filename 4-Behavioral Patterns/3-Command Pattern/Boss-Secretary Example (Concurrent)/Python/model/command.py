#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Command module.
"""

__author__ = 'Ziang Lu'

import threading
from abc import ABC, abstractmethod
from functools import total_ordering

from model.receiver import DailyReportGenerator, EmailBox, Printer


@total_ordering
class Command(ABC):
    """
    Abstract Command class that works as "Command".
    This abstract class represents a request, and defines only one execute()
    method, which executes this command.
    """
    __slots__ = ['_priority']

    def __init__(self, priority: int):
        """
        Constructor with parameter.
        :param priority: int
        """
        self._priority = priority

    @property
    def priority(self) -> int:
        """
        Accessor of priority.
        :return: int
        """
        return self._priority

    @abstractmethod
    def execute(self) -> None:
        """
        Executes this command.
        :return: None
        """
        pass

    def __lt__(self, other):
        return self._priority < other.priority


class EmailSomeone(Command):
    """
    Concrete EmailSomeone class that works as "ConcreteCommand".
    This command emails someone using a email box.

    This class contains a reference to a "Receiver", which is responsible for,
    in the execute() method, perform some actions and thus handle the request.
    """
    __slots__ = ['_email_box', '_recipient_email', '_msg_to_email']

    def __init__(self, email_box: EmailBox, recipient_mail: str, msg: str,
                 priority: int):
        """
        Constructor with parameter.
        :param email_box: EmailBox
        :param recipient_mail: str
        :param msg: str
        :param priority: int
        """
        super().__init__(priority)
        self._email_box = email_box
        self._recipient_email = recipient_mail
        self._msg_to_email = msg
        print(f'{threading.current_thread().name} An email-someone command '
              f'[Command] has been created')

    def execute(self):
        # Let the email box [Receiver] handle this email-someone command
        # [Command]
        self._email_box.send_email(self._recipient_email, self._msg_to_email)


class GenerateDailyReport(Command):
    """
    Concrete GenerateDailyReport class that works as "ConcreteCommand".
    This command generates a daily report using a report generator.

    This class contains a reference to a "Receiver", which is responsible for,
    in the execute() method, perform some actions and thus handle the request.
    """
    __slots__ = ['_report_generator']

    def __init__(self, report_generator: DailyReportGenerator, priority: int):
        """
        Constructor with parameter.
        :param report_generator: DailyReportGenerator
        :param priority: int
        """
        super().__init__(priority)
        self._report_generator = report_generator
        print(f'{threading.current_thread().name} A generate-daily-report '
              f'command [Command] has been created')

    def execute(self):
        # Let the report generator [Receiver] handle this generate-daily-report
        # command [Command]
        self._report_generator.generate_daily_report()


class PrintDoc(Command):
    """
    Concrete PrintDoc class that works as "ConcreteCommand".
    This command prints a document using a printer.

    This class contains a reference to a "Receiver", which is responsible for,
    in the execute() method, perform some actions and thus handle the request.
    """
    __slots__ = ['_printer', '_doc_to_print']

    def __init__(self, printer: Printer, doc: str, priority: int):
        """
        Constructor with parameter.
        :param printer: Printer
        :param doc: str
        :param priority: int
        """
        super().__init__(priority)
        self._printer = printer
        self._doc_to_print = doc
        print(f'{threading.current_thread().name} A print-document [Command] '
              f'has been created')

    def execute(self):
        # Let the printer [Receiver] handle this print-document command
        # [Command]
        self._printer.print_doc(self._doc_to_print)


class CopyDoc(Command):
    """
    Concrete CopyDoc class that works as "ConcreteCommand".
    This command copies a document using a printer.

    This class contains a reference to a "Receiver", which is responsible for,
    in the execute() method, perform some actions and thus handle the request.
    """
    __slots__ = ['_printer', '_doc_to_copy']

    def __init__(self, printer: Printer, doc: str, priority: int):
        """
        Constructor with parameter.
        :param printer: Printer
        :param doc: str
        :param priority: int
        """
        super().__init__(priority)
        self._printer = printer
        self._doc_to_copy = doc
        print(f'{threading.current_thread().name} A copy-document [Command] has'
              f' been created')

    def execute(self):
        # Let the printer [Receiver] handle this copy-document command [Command]
        self._printer.copy_doc(self._doc_to_copy)
