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
    american1.follow(trump)
    american2.follow(trump)

    print()
    trump.write_tweet('A wonderful day with my family!')

    print()
    american1.unfollow(trump)
    american2.unfollow(trump)


if __name__ == '__main__':
    main()

# Output:
# US Citizen 1: Starting to follow Donald Trump
# US Citizen 2: Starting to follow Donald Trump
#
# Donald Trump: I wrote a new tweet: A wonderful day with my family!
# US Citizen 2: I got an update from Donald Trump about a new tweet: A wonderful day with my family!
# US Citizen 1: I got an update from Donald Trump about a new tweet: A wonderful day with my family!
#
# US Citizen 1: Stops to follow Donald Trump
# US Citizen 2: Stops to follow Donald Trump
