#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Invoker module.
"""

from queue import PriorityQueue
from threading import Thread, current_thread


class Secretary(Thread):
    """
    Secretary class that works as "Invoker".
    This class is responsible for executing the different "Command"s.
    The "Invoker" does not know how to handle the request, but simply invoke
    command.execute() method, and let the internal correct "Receive" handle the
    request.
    """
    __slots__ = ['_my_boss', '_tasks']

    def __init__(self, boss, tasks: PriorityQueue, thread_name: str):
        """
        Constructor with parameter.
        :param tasks: PriorityQueue
        :param thread_name: str
        """
        super().__init__(name=thread_name)
        self._my_boss = boss
        self._tasks = tasks
        # Command priority queue (PQ) shared by the "Invoker" and the "Client".
        # The "Client" will keep adding commands to this PQ, and the "Invoker"
        # will keep fetching commands from this PQ and execute them.

    def run(self):
        while not self._my_boss.has_finished_assign_tasks() or \
                not self._tasks.empty():
            task = self._tasks.get()
            print(f'{current_thread().name} Secretary [Invoker] has fetched '
                  f'{type(task).__name__} [Command] from the task priority '
                  f'queue, and starts executing the command...')
            task.execute()
