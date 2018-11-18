#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Receiver module.
"""

__author__ = 'Ziang Lu'

import random
import threading
import time
from datetime import datetime


class DailyReportGenerator:
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
        print(f'{threading.current_thread().name} <Daily Report Generator> is '
              f'generating a daily report...')
        time.sleep(random.randint(1, 9))
        print('***** Daily Report *****')
        print(datetime.now().isoformat(sep=' ', timespec='seconds'))
        print('************************')


class EmailBox:
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
        time.sleep(random.randint(1, 9))
        print(f"{threading.current_thread().name} <Email Box> has sent '{msg}' "
              f"to {recipient_email}")


class Printer:
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
        time.sleep(random.randint(1, 9))
        print(f'{threading.current_thread().name} <Printer> has printed {doc}.')

    def copy_doc(self, doc: str) -> None:
        """
        Copies the given document.
        :param doc: str
        :return: None
        """
        time.sleep(random.randint(1, 9))
        print(f'{threading.current_thread().name} <Printer> has copied {doc}')
