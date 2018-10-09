#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Application that actually uses Mediator Pattern.
"""

__author__ = 'Ziang Lu'

from model import InterphoneGroup, LeaderUser, NormalUser


def main():
    steve = LeaderUser('Steve')
    tony = LeaderUser('Tony')
    bruce = NormalUser('Bruce')

    group = InterphoneGroup()
    steve.join_group(group)
    tony.join_group(group)
    bruce.join_group(group)

    tony.send_message('Incoming enemy!')


if __name__ == '__main__':
    main()

# Output:
# Tony sends a message: Incoming enemy!
# Steve received a message from Tony: Incoming enemy!
# Bruce received a message from Tony: Incoming enemy!
