#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Logging module.
"""

__author__ = 'Ziang Lu'


from enum import Enum

from logger import DebugLogger, ErrorLogger, InfoLogger, WarningLogger


class LogLevel(Enum):
    """
    Log level enumeration.
    """
    INFO = 1
    DEBUG = 2
    WARNING = 3
    ERROR = 4


class LoggerManager:
    __slots__ = ['_first_logger', '_logging_level']

    def __init__(self):
        """
        Default constructor.
        """
        self._first_logger = InfoLogger.get_instance(
            DebugLogger.get_instance(
                WarningLogger.get_instance(ErrorLogger.get_instance())
            )
        )

    def set_level(self, level: LogLevel) -> None:
        """
        Mutator of logging_level.
        :param level: LogLevel
        :return: None
        """
        self._logging_level = level

    def log_message(self, msg: str, level: LogLevel=None) -> None:
        """
        Logs the given message of the given level,
        :param msg: str
        :param level: LogLevel
        :return: None
        """
        if not level:
            level = self._logging_level
        self._first_logger.handle_log_request(msg, level)
