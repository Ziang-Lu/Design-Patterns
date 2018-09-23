#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Application that actually uses Proxy Pattern.
"""

__author__ = 'Ziang Lu'

from folder import FolderProxy
from user import User


def main():
    print('A CEO tries to perform a read/write operation on a shared folder.')
    folder_proxy = FolderProxy()
    folder_proxy.perform_read_or_write_operation(
        user=User('John', 'John123', 'CEO')
    )
    print()
    print('A developer tries to perform a read/write operation on a shared '
          'folder.')
    folder_proxy.perform_read_or_write_operation(
        user=User('Raj', 'Raj123', 'Developer')
    )


if __name__ == '__main__':
    main()

# Output:
# A CEO tries to perform a read/write operation on a shared folder.
# FolderProxy: 'FolderProxy will forward the request to the real SharedFolder object.'
# In SharedFolder: CEO is performing read/write operation.
#
# A developer tries to perform a read/write operation on a shared folder.
# FolderProxy: 'You don't have permission to the shared folder.'
