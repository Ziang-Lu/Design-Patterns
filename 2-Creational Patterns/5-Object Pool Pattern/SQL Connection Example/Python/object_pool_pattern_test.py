#!usr/bin/enc python3
# -*- coding: utf-8 -*-

"""
Application that actually uses Object Pool Pattern.
By using Object Pool Pattern, the load on memory is reduced and the performance
is improved..
"""

__author__ = 'Ziang Lu'

import threading

from sql_connection import SQLConnection


def func(thread_name: str) -> None:
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
        thread_name = f'Thread-{i}'
        th = threading.Thread(target=func, args=(thread_name,),
                              name=thread_name)
        th.start()


if __name__ == '__main__':
    main()
