#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Invoker module.
"""

import heapq
from threading import Condition, Thread, current_thread

# Global condition
shared_condition = Condition()


class Secretary(Thread):
    """
    Secretary class that works as "Invoker".
    This class is responsible for executing the different "Command"s.
    The "Invoker" does not know how to handle the request, but simply invoke
    command.execute() method, and let the internal correct "Receive" handle the
    request.
    """
    __slots__ = ['_my_boss', '_tasks']

    def __init__(self, boss, tasks: list, thread_name: str):
        """
        Constructor with parameter.
        :param tasks: list
        :param thread_name: str
        """
        super().__init__(name=thread_name)
        self._my_boss = boss
        self._tasks = tasks
        # Command priority queue (PQ) shared by the "Invoker" and the "Client".
        # The "Client" will keep adding commands to this PQ, and the "Invoker"
        # will keep fetching commands from this PQ and execute them.

    def run(self):
        while not self._my_boss.has_finished_assign_tasks or not self._tasks:
            task = None
            # Synchronize on the global Condition
            if shared_condition.acquire():
                while not self._tasks:
                    # Wait for a new command to be added to the PQ
                    shared_condition.wait()
                # Fetch a command from the PQ, and execute it
                task = heapq.heappop(self._tasks)
                print(f'{current_thread().name} Secretary [Invoker] has fetched'
                      f' {type(task).__name__} [Command] from the task queue, '
                      f'and starts executing the command...')
                shared_condition.release()
            task.execute()