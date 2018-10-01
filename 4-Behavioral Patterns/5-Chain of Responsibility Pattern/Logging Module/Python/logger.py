#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Logger module.
"""

__author__ = 'Ziang Lu'

from abc import ABC, abstractmethod

from logging import LogLevel


class Logger(ABC):
    """
    Abstract Logger class that works as "Handler".

    In order to let different "ConcreteHandler" be able to process the same
    request, we need them to have similar API.
    Therefore, we simply let this step be done via letting different
    "ConcreteHandler" share a common super class "Handler", in which we define
    the API to process a request.
    """
    __slots__ = ['_next_logger']

    @staticmethod
    def _process_log_level(level: LogLevel) -> str:
        level_str = str(level)
        dot = level_str.find('.')
        return level_str[dot + 1:]

    def __init__(self, logger):
        """
        Constructor with parameter.
        :param logger: Logger
        """
        self._next_logger = logger

    @abstractmethod
    def _my_level(self) -> LogLevel:
        pass

    def handle_log_request(self, msg: str, level: LogLevel) -> None:
        """
        Handles the log request of the given level.
        :param msg: str
        :param level: LogLevel
        :return: None
        """
        if level >= self._my_level():
            # This receiver handles the request.
            self._log_message(msg, level)

            if self._next_logger:
                # Pass the request to the next receiver in the chain of
                # responsibility
                self._next_logger.handle_log_request(msg, level)

    def _log_message(self, msg: str, level: LogLevel) -> None:
        """
        Private helper function to log the given message of the given level.
        :param msg: str
        :param level: LogLevel
        :return: None
        """
        print(f'{type(self).__name__}: logging a '
              f'{self._process_log_level(level)} message: {msg}')


class InfoLogger(Logger):
    """
    InfoLogger that works as "ConcreteHandler".
    This class is implemented as a singleton class.
    """

    @classmethod
    def get_instance(cls, logger: Logger):
        """
        Gets the singleton instance.
        :param logger: Logger
        :return: InfoLogger
        """
        return cls.__new__(cls, logger)

    def __new__(cls, *args, **kwargs):
        if not hasattr(cls, '_instance'):
            cls._instance = super().__new__(cls)
            cls._instance.__init__(*args)
        return cls._instance

    def __init__(self, logger: Logger):
        """
        Constructor with parameter.
        :param logger: Logger
        """
        super().__init__(logger)

    def _my_level(self):
        return LogLevel.INFO


class DebugLogger(Logger):
    """
    DebugLogger that works as "ConcreteHandler".
    This class is implemented as a singleton class.
    """

    @classmethod
    def get_instance(cls, logger: Logger):
        """
        Gets the singleton instance.
        :param logger: Logger
        :return: DebugLogger
        """
        return cls.__new__(cls, logger)

    def __new__(cls, *args, **kwargs):
        if not hasattr(cls, '_instance'):
            cls._instance = super().__new__(cls)
            cls._instance.__init__(*args)
        return cls._instance

    def __init__(self, logger: Logger):
        """
        Constructor with parameter.
        :param logger: Logger
        """
        super().__init__(logger)

    def _my_level(self):
        return LogLevel.DEBUG


class WarningLogger(Logger):
    """
    WarningLogger that works as "ConcreteHandler".
    This class is implemented as a singleton class.
    """

    @classmethod
    def get_instance(cls, logger: Logger):
        """
        Gets the singleton instance.
        :param logger: Logger
        :return: WarningLogger
        """
        return cls.__new__(cls, logger)

    def __new__(cls, *args, **kwargs):
        if not hasattr(cls, '_instance'):
            cls._instance = super().__new__(cls)
            cls._instance.__init__(*args)
        return cls._instance

    def __init__(self, logger: Logger):
        """
        Constructor with parameter.
        :param logger: Logger
        """
        super().__init__(logger)

    def _my_level(self):
        return LogLevel.WARNING


class ErrorLogger(Logger):
    """
    ErrorLogger that works as "ConcreteHandler".
    This class is implemented as a singleton class.
    """

    @classmethod
    def get_instance(cls):
        """
        Gets the singleton instance.
        :return: ErrorLogger
        """
        return cls.__new__(cls)

    def __new__(cls, *args, **kwargs):
        if not hasattr(cls, '_instance'):
            cls._instance = super().__new__(cls)
        return cls._instance

    def __init__(self,):
        """
        Default constructor.
        """
        super().__init__(None)

    def _my_level(self):
        return LogLevel.ERROR
