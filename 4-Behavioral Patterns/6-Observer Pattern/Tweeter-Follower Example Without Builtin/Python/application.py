#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Application that actually uses Observer Pattern.
"""

__author__ = 'Ziang Lu'

from observer import Follower
from subject import Tweeter


def main():
    trump = Tweeter('Donald Trump')
    american1 = Follower('US Citizen 1')
    american2 = Follower('US Citizen 2')
    trump.register(american1)
    trump.register(american2)

    trump.write_tweeter()


if __name__ == '__main__':
    main()

# Output:
# Donald Trump: I wrote a new tweet: A wonderful way with my family!
# US Citizen 2: I got an update from Donald Trump about a new tweet: A wonderful way with my family!
# US Citizen 1: I got an update from Donald Trump about a new tweet: A wonderful way with my family!
