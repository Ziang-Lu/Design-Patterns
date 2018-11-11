#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Client module.
"""

import random
import time
from collections import deque
from threading import Thread

from model.command import (
    Command, CopyDoc, EmailSomeone, GenerateDailyReport, PrintDoc
)
from model.receiver import DailyReportGenerator, EmailBox, Printer
from model.secretary import Secretary, shared_condition


class Boss(Thread):
    """
    Boss class that works as "Client" and actually uses Command Pattern.
    """
    __slots__ = [
        '_my_email_box', '_report_generator', '_printer', '_task_queue'
    ]

    def __init__(self, task_queue: deque):
        """
        Constructor with parameter.
        :param task_queue: deque
        """
        super().__init__()
        self._my_email_box = EmailBox.get_instance()  # Receiver
        self._report_generator = DailyReportGenerator.get_instance()  # Receiver
        self._printer = Printer()  # Receiver
        self._task_queue = task_queue
        # Command queue shared by the "Invoker" and the "Client".
        # The "Client" will keep adding commands to this queue, and the
        # "Invoker" will keep fetching commands from this queue and execute
        # them.

    def run(self):
        # For each command:
        # 1. Create a command and sets its receiver
        # 2. Add the command to the queue shared by the client and the invoker
        # 3. Wait for the invoker to fetch the command from the queue and
        # executes it

        time.sleep(random.randint(1, 5))
        generate_daily_report = GenerateDailyReport(
            report_generator=self._report_generator
        )
        self._add_task(generate_daily_report)

        time.sleep(random.randint(1, 5))
        print()
        copy_my_name_card = CopyDoc(printer=self._printer,
                                    doc='Name Card of boss')
        self._add_task(copy_my_name_card)

        time.sleep(random.randint(1, 5))
        print()
        print_my_slides = PrintDoc(printer=self._printer, doc='My slides')
        self._add_task(print_my_slides)

        time.sleep(random.randint(1, 5))
        print()
        email_steve = EmailSomeone(
            email_box=self._my_email_box,
            recipient_mail='steverogers@gmail.com',
            msg='I need a plan of attack.'
        )
        self._add_task(email_steve)

        time.sleep(random.randint(1, 5))
        print()
        email_tony = EmailSomeone(
            email_box=self._my_email_box, recipient_mail='tonystark@gmail.com',
            msg='Any new tech today?'
        )
        self._add_task(email_tony)

    def _add_task(self, task: Command) -> None:
        """
        Private helper function to add the given command to the queue.
        :param task: Command
        :return: None
        """
        if shared_condition.acquire():
            self._task_queue.append(task)
            print(f'{type(task).__name__} has been added to the task queue.')
            shared_condition.notifyAll()
            shared_condition.release()


def main():
    secretary = Secretary()  # Invoker

    boss = Boss(task_queue=secretary.task_queue)  # Client

    secretary.start()
    boss.start()

    boss.join()

    secretary.stop_thread()


if __name__ == '__main__':
    main()

# Output:
# A generate-daily-report command [Command] has been created.
# GenerateDailyReport has been added to the task queue.
# Secretary [Invoker] has fetched GenerateDailyReport from the task queue, and starts executing the command...
# <Daily Report Generator> is generating a daily report:
# **********
# 2018-11-11 13:05:24
# **********
#
# A copy-document [Command] has been created.
# CopyDoc has been added to the task queue.
# Secretary [Invoker] has fetched CopyDoc from the task queue, and starts executing the command...
# <Printer> is copying Name Card of boss
#
# A print-document [Command] has been created.
# PrintDoc has been added to the task queue.
# Secretary [Invoker] has fetched PrintDoc from the task queue, and starts executing the command...
# <Printer> is printing My slides.
#
# An email-someone command [Command] has been created.
# EmailSomeone has been added to the task queue.
# Secretary [Invoker] has fetched EmailSomeone from the task queue, and starts executing the command...
# <Email Box> is sending 'I need a plan of attack.' to steverogers@gmail.com
#
# An email-someone command [Command] has been created.
# EmailSomeone has been added to the task queue.
# Secretary [Invoker] has fetched EmailSomeone from the task queue, and starts executing the command...
# <Email Box> is sending 'Any new tech today?' to tonystark@gmail.com
