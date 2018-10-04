#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Folder module.
"""

__author__ = 'Ziang Lu'

from abc import ABC, abstractmethod

from user import User


class Folder(ABC):
    """
    Abstract Folder class that works as "Subject".

    In order to let the "Proxy" controls the access to its hiding "RealSubject"
    behind the scene, the "Proxy" needs to provide similar API as the
    "RealSubject".
    Therefore, we simply let this step be done via letting "RealSubject" and
    "Proxy" share a common super class "Subject", in which we define only the
    methods that we want the "Proxy" to provide access to.
    """
    __slots__ = []

    @abstractmethod
    def perform_read_or_write_operation(self, user: User) -> None:
        """
        The given user tries to perform a read/write operation on a shared
        folder.
        :param user: User
        :return: None
        """
        pass


class SharedFolder(Folder):
    """
    SharedFolder class that works as "RealSubject".
    """
    __slots__ = []

    def perform_read_or_write_operation(self, user):
        print(f'In SharedFolder: {user.designation} is performing read/write '
              f'operation.')


class FolderProxy(Folder):
    """
    FolderProxy class that works as "Proxy".
    A FolderProxy object acts as a proxy that controls the access to its hiding
    SharedFolder object behind the scene, performing protection-related
    operations. In this way, the "Proxy" will work on behalf of the
    "RealSubject", or the "Proxy" represents the "RealSubject".
    """
    __slots__ = ['_real_shared_folder']

    def __init__(self):
        """
        Default constructor.
        """
        self._real_shared_folder = SharedFolder()

    def perform_read_or_write_operation(self, user):
        # Before we forward the request to the real shared folder, perform
        # protection-related operations
        # In this case, this would be checking the designation of the user, and
        # see if the user has the permission to perform a read/write operation
        # on a shared folder
        if user.designation.lower() == 'CEO'.lower() or\
                user.designation.lower() == 'Manager'.lower():
            print("FolderProxy: 'FolderProxy will forward the request to the "
                  "real SharedFolder object.'")
            self._real_shared_folder.perform_read_or_write_operation(user)
        else:
            print("FolderProxy: 'You don't have permission to the shared "
                  "folder.'")
