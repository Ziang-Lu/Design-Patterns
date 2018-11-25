#!usr/bin/enc python3
# -*- coding: utf-8 -*-

"""
Application that actually uses Object Pool Pattern.
"""

__author__ = 'Ziang Lu'

import threading

from sql_connection import SQLConnection


def thread_func(thread_name: str) -> None:
    """
    Opens a SQL connection in a separate thread and operates on it.
    :param thread_name: str
    :return: None
    """
    connection = None
    try:
        connection = SQLConnection()
        connection.operate(f'[{thread_name} data]')
    finally:
        connection.close()


def main():
    for i in range(20):
        th_name = f'Thread-{i}'
        th = threading.Thread(target=thread_func, args=(th_name,), name=th_name)
        th.start()


if __name__ == '__main__':
    main()
