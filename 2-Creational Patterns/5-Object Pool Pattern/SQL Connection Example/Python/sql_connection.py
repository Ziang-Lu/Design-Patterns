#!usr/bin/enc python3
# -*- coding: utf-8 -*-

"""
SQL Connection module.
"""

__author__ = 'Ziang Lu'

import threading
import time
from collections import deque
from threading import Condition
from typing import Union


class SQLConnectionImpl:
    """
    SQLConnectionImpl class that works as "Reusable".
    This class is expensive to instantiate, which means repeatedly allocating
    and freeing instances of this class individually would be too expensive
    operations, and thus decrease the performance.
    Therefore, we can put the instances of this class in a pool for later reuse.
    """
    __slots__ = ['_data']

    def __init__(self):
        """
        Default constructor.
        """
        # Sleep 1 second to simulate the expensive instantiation process
        time.sleep(1)
        self._data = None

    def set_data(self, data: Union[str, None]) -> None:
        """
        Sets the underling data to transmit.
        :param data: str
        :return: None
        """
        self._data = data

    def operate(self) -> None:
        """
        Operates this SQL connection implementation to transmit the underlying
        data.
        :return: None
        """
        print(f'SQL Connection Implementation operating {self._data} to SQL '
              f'Server')
        # Sleep 3 seconds the simulate the data transmission process
        time.sleep(3)


class SQLConnectionImplPool:
    """
    SQLConnectionImplPool class that works as "ReusablePool".
    "Reusable" class is expensive to instantiate, which means repeatedly
    allocating and freeing instances of this class individually would be too
    expensive operations, and thus decrease the performance.
    Therefore, we can use this class limits the number of instances created
    (poolSize) and manage them. In this way, we can share objects ("Reusable"
    objects) that are expensive to create.
    """
    _DEFAULT_POOL_SIZE = 10

    @classmethod
    def get_instance(cls):
        """
        Gets the singleton instance.
        :return: SQLConnectionImplPool
        """
        return cls.__new__(cls)

    def __new__(cls, *args, **kwargs):
        if not hasattr(cls, '_instance'):
            cls._instance = super().__new__(cls)
            cls._instance.__init__()
        return cls._instance

    @staticmethod
    def _clean_up(conn_impl: SQLConnectionImpl) -> None:
        """
        Private helper method to clean up the given connection implementation
        ("Reusable" object).
        :param conn_impl: SQLConnectionImpl
        :return: None
        """
        conn_impl.set_data(None)

    def __init__(self):
        """
        Default constructor.
        """
        self._pool_size = self._DEFAULT_POOL_SIZE
        self._num_of_created = 0
        self._available = deque()
        self._condition = Condition()

    def set_pool_size(self, new_pool_size: int) -> None:
        """
        Sets a new pool size.
        :param new_pool_size: int
        :return: None
        """
        if new_pool_size < self._num_of_created:
            print('Cannot set a pool size smaller than number of instances '
                  'already created')
            return
        self._pool_size = new_pool_size

    def acquire_connection_impl(self) -> SQLConnectionImpl:
        """
        Acquires a connection implementation ("Reusable" object) from this pool.
        :return: SQLConnectionImpl
        """
        # Synchronize on the condition
        if self._condition.acquire():
            conn_impl = None
            while not conn_impl:
                # Check if there is any "Reusable" object in the pool
                if self._available:
                    conn_impl = self._available.popleft()
                    self._condition.release()
                # Check whether the pool has reached its maximum size
                elif self._num_of_created < self._pool_size:
                    # Create a new "Reusable" object
                    conn_impl = SQLConnectionImpl()
                    self._num_of_created += 1
                    self._condition.release()
                else:
                    # Wait for a previously created, currently using by a
                    # previous client "Reusable" object to be released back to
                    # the pool, and then return that "Reusable" object
                    self._condition.wait()
            return conn_impl

    def release_connection_impl(self, conn_impl: SQLConnectionImpl) -> None:
        """
        Releases the given connection implementation ("Reusable" object) from
        this pool.
        :param conn_impl: SQLConnectionImpl
        :return: None
        """
        # Synchronize on the condition
        if self._condition.acquire():
            # Clean up the "Reusable" object
            self._clean_up(conn_impl)

            self._available.append(conn_impl)
            self._condition.notify_all()
            self._condition.release()


class SQLConnection:
    """
    SQLConnection class that works as "Client", and actually uses Object Pool
    Pattern.
    Object Pool Pattern uses a pool ("ReusablePool") to limit the number of
    instances created (poolSize) and manage them. In this way, we can share
    objects ("Reusable" objects) that are expensive to create.
    """

    _POOL = SQLConnectionImplPool.get_instance()

    @classmethod
    def set_pool_size(cls, new_pool_size: int) -> None:
        """
        Sets the connection pooling size.
        :param new_pool_size: int
        :return: None
        """
        cls._POOL.set_pool_size(new_pool_size)

    def __init__(self):
        """
        Default constructor.
        """
        self._conn_impl = self._open()

    def _open(self) -> SQLConnectionImpl:
        """
        Private helper method to open this SQL connection.
        This method will acquire a connection implementation from the connection
        pooling.
        :return: SQLConnectionImpl
        """
        return self._POOL.acquire_connection_impl()

    def operate(self, data: str) -> None:
        """
        Operates this SQL connection with the given data.
        :param data: str
        :return: None
        """
        if self._conn_impl:
            self._conn_impl.set_data(data)
            self._conn_impl.operate()

    def close(self) -> None:
        """
        Closes this SQL connection.
        This method will release a connection implementation back to the
        connection pooling.
        :return: None
        """
        if self._conn_impl:
            self._POOL.release_connection_impl(self._conn_impl)

            # Nullify the reference to the "Reusable" object
            self._conn_impl = None
