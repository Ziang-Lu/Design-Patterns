#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Command module.
"""

__author__ = 'Ziang Lu'

from abc import ABC, abstractmethod

from model.receiver import DailyReportGenerator, EmailBox, Printer


class Command(ABC):
    """
    Abstract Command class that works as "Command".
    This abstract class represents a request, and defines only one execute()
    method, which executes this command.
    """
    __slots__ = []

    @abstractmethod
    def execute(self) -> None:
        """
        Executes this command.
        :return: None
        """
        pass


class EmailSomeone(Command):
    """
    Concrete EmailSomeone class that works as "ConcreteCommand".
    This command emails someone using a email box.

    This class contains a reference to a "Receiver", which is responsible for,
    in the execute() method, perform some actions and thus handle the request.
    """
    __slots__ = ['_email_box', '_recipient_email', '_msg_to_email']

    def __init__(self, email_box: EmailBox, recipient_mail: str, msg: str):
        """
        Constructor with parameter.
        :param email_box: EmailBox
        :param recipient_mail: str
        :param msg: str
        """
        self._email_box = email_box
        self._recipient_email = recipient_mail
        self._msg_to_email = msg
        print('An email-someone command [Command] has been created.')

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

    def __init__(self, report_generator: DailyReportGenerator):
        """
        Constructor with parameter.
        :param report_generator: DailyReportGenerator
        """
        self._report_generator = report_generator
        print('A generate-daily-report command [Command] has been created.')

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

    def __init__(self, printer: Printer, doc: str):
        """
        Constructor with parameter.
        :param printer: Printer
        :param doc: str
        """
        self._printer = printer
        self._doc_to_print = doc
        print('A print-document [Command] has been created.')

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

    def __init__(self, printer: Printer, doc: str):
        """
        Constructor with parameter.
        :param printer: Printer
        :param doc: str
        """
        self._printer = printer
        self._doc_to_copy = doc
        print('A copy-document [Command] has been created.')

    def execute(self):
        # Let the printer [Receiver] handle this copy-document command [Command]
        self._printer.copy_doc(self._doc_to_copy)
