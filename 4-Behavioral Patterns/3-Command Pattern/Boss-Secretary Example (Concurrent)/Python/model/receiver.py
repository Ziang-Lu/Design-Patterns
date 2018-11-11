#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Receiver module.
"""

__author__ = 'Ziang Lu'

from datetime import datetime


class DailyReportGenerator(object):
    """
    DailyReportGenerator class that works as "Receiver".

    This class is implemented as a singleton class.
    """

    @classmethod
    def get_instance(cls):
        """
        Gets the singleton instance.
        :return: DailyReportGenerator
        """
        return cls.__new__(cls)

    def __new__(cls, *args, **kwargs):
        if not hasattr(cls, '_instance'):
            cls._instance = super().__new__(cls)
        return cls._instance

    def generate_daily_report(self) -> None:
        """
        Generates a daily report.
        :return: None
        """
        print('<Daily Report Generator> is generating a daily report:')
        print('**********')
        print(datetime.now().isoformat(sep=' ', timespec='seconds'))
        print('**********')


class EmailBox(object):
    """
    EmailBox class that works as "Receiver".

    This class is implemented as a singleton class.
    """

    @classmethod
    def get_instance(cls):
        """
        Gets the singleton instance.
        :return: EmailBox
        """
        return cls.__new__(cls)

    def __new__(cls, *args, **kwargs):
        if not hasattr(cls, '_instance'):
            cls._instance = super().__new__(cls)
        return cls._instance

    def send_email(self, recipient_email: str, msg: str) -> None:
        """
        Sends the given message to the given recipient.
        :param recipient_email: str
        :param msg: str
        :return: None
        """
        print(f"<Email Box> is sending '{msg}' to {recipient_email}")


class Printer(object):
    """
    Printer class that works as "Receiver".
    """
    __slots__ = []

    def print_doc(self, doc: str) -> None:
        """
        Prints the given document.
        :param doc: str
        :return: None
        """
        print(f'<Printer> is printing {doc}.')

    def copy_doc(self, doc: str) -> None:
        """
        Copies the given document.
        :param doc: str
        :return: None
        """
        print(f'<Printer> is copying {doc}')
