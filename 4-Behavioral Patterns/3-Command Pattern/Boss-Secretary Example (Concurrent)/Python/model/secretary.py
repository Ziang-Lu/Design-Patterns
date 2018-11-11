#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Invoker module.
"""

from threading import Condition, Thread
from collections import deque

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
    __slots__ = ['task_queue', '_stop_thread']

    def __init__(self):
        """
        Default constructor.
        """
        super().__init__()
        self.task_queue = deque()
        # Command queue shared by the "Invoker" and the "Client".
        # The "Client" will keep adding commands to this queue, and the
        # "Invoker" will keep fetching commands from this queue and execute
        # them.
        self._stop_thread = False

    def stop_thread(self) -> None:
        """
        Stops the secretary thread.
        :return:
        """
        self._stop_thread = True

    def run(self):
        while not self._stop_thread:
            # print('1')
            # Synchronize on the global Condition
            if shared_condition.acquire():
                # print('2')
                while not self.task_queue:
                    # Wait for a new command to be added to the queue
                    # print('3')
                    shared_condition.wait()
                # Fetch a command from the queue, and execute it
                task = self.task_queue.popleft()
                print(f'Secretary [Invoker] has fetched '
                      f'{type(task).__name__} from the task queue, and '
                      f'starts executing the command...')
                task.execute()
                # print('4')
                shared_condition.release()
