#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
User module.
"""

__author__ = 'Ziang Lu'


class User(object):
    __slots__ = ['_username', '_password', '_designation']

    def __init__(self, username: str, password: str, designation: str):
        """
        Constructor with parameter.
        :param username: str
        :param password: str
        :param designation: str
        """
        self._username = username
        self._password = password
        self._designation = designation

    @property
    def designation(self) -> str:
        """
        Accessor of designation.
        :return: str
        """
        return self._designation
