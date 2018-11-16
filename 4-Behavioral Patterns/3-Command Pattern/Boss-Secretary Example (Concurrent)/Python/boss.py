#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Client module.

Note that we could have some more variants, such as:
Create multiple threads:
- Separately but concurrently add commands to the command priority queue
- Separately but concurrently fetch command from the command priority queue, and
  then execute it
"""

import random
import time
from threading import Thread, current_thread

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
        '_my_email_box', '_report_generator', '_printer', 'tasks',
        '_finished_assign_tasks'
    ]

    def __init__(self, thread_name: str):
        """
        Constructor with parameter.
        :param thread_name: str
        """
        super().__init__(name=thread_name)
        self._my_email_box = EmailBox.get_instance()  # Receiver
        self._report_generator = DailyReportGenerator.get_instance()  # Receiver
        self._printer = Printer()  # Receiver
        self.tasks = []
        # Command priority queue (PQ) shared by the "Invoker" and the "Client".
        # The "Client" will keep adding commands to this PQ, and the "Invoker"
        # will keep fetching commands from this PQ and execute them.
        self._finished_assign_tasks = False

    def has_finished_assign_tasks(self) -> bool:
        """
        Accessor of finish_assign_tasks.
        :return: bool
        """
        return self._finished_assign_tasks

    def run(self):
        # For each command:
        # 1. Create a command and sets its receiver
        # 2. Add the command to the PQ shared by the client and the invoker
        # 3. Wait for the invoker to fetch the command from the PQ and executes
        #    it

        time.sleep(random.randint(1, 5))
        generate_daily_report = GenerateDailyReport(
            report_generator=self._report_generator, priority=5
        )
        self._add_task(generate_daily_report)

        time.sleep(random.randint(1, 5))
        copy_my_name_card = CopyDoc(printer=self._printer,
                                    doc='Name Card of boss', priority=2)
        self._add_task(copy_my_name_card)

        time.sleep(random.randint(1, 5))
        print_my_slides = PrintDoc(printer=self._printer, doc='My slides',
                                   priority=3)
        self._add_task(print_my_slides)

        time.sleep(random.randint(1, 5))
        email_steve = EmailSomeone(
            email_box=self._my_email_box,
            recipient_mail='steverogers@gmail.com',
            msg='I need a plan of attack.', priority=4
        )
        self._add_task(email_steve)

        time.sleep(random.randint(1, 5))
        email_tony = EmailSomeone(
            email_box=self._my_email_box, recipient_mail='tonystark@gmail.com',
            msg='Any new tech today?', priority=2
        )
        self._add_task(email_tony)

        self._finished_assign_tasks = True

    def _add_task(self, task: Command) -> None:
        """
        Private helper function to add the given command to the PQ.
        :param task: Command
        :return: None
        """
        if shared_condition.acquire():
            self.tasks.append(task)
            print(f'{current_thread().name} {type(task).__name__} [Command] has'
                  f' been added to the task queue')
            shared_condition.notifyAll()
            shared_condition.release()


def main():
    boss = Boss(thread_name='[Boss-Thread]')  # Client

    secretary = Secretary(boss=boss, tasks=boss.tasks,
                          thread_name='[Secretary-Thread]')  # Invoker

    secretary.start()
    boss.start()

    boss.join()
    secretary.join()


if __name__ == '__main__':
    main()

# Output:
# [Boss-Thread] A generate-daily-report command [Command] has been created
# [Boss-Thread] GenerateDailyReport [Command] has been added to the task queue
# [Secretary-Thread] Secretary [Invoker] has fetched GenerateDailyReport [Command] from the task queue, and starts executing the command...
# [Secretary-Thread] <Daily Report Generator> is generating a daily report...
# [Boss-Thread] A copy-document [Command] has been created
# [Boss-Thread] CopyDoc [Command] has been added to the task queue
# ***** Daily Report *****
# 2018-11-12 18:10:17
# ************************
# [Secretary-Thread] Secretary [Invoker] has fetched CopyDoc [Command] from the task queue, and starts executing the command...
# [Boss-Thread] A print-document [Command] has been created
# [Boss-Thread] PrintDoc [Command] has been added to the task queue
# [Boss-Thread] An email-someone command [Command] has been created
# [Boss-Thread] EmailSomeone [Command] has been added to the task queue
# [Boss-Thread] An email-someone command [Command] has been created
# [Boss-Thread] EmailSomeone [Command] has been added to the task queue
# [Secretary-Thread] <Printer> has copied Name Card of boss
# [Secretary-Thread] Secretary [Invoker] has fetched PrintDoc [Command] from the task queue, and starts executing the command...
# [Secretary-Thread] <Printer> has printed My slides.
# [Secretary-Thread] Secretary [Invoker] has fetched EmailSomeone [Command] from the task queue, and starts executing the command...
# [Secretary-Thread] <Email Box> has sent 'Any new tech today?' to tonystark@gmail.com
# [Secretary-Thread] Secretary [Invoker] has fetched EmailSomeone [Command] from the task queue, and starts executing the command...
# [Secretary-Thread] <Email Box> has sent 'I need a plan of attack.' to steverogers@gmail.com
