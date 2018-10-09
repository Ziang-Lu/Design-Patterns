#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Application that actually uses Mediator Pattern.
"""

__author__ = 'Ziang Lu'

from model import InterphoneGroup, LeaderUser, NormalUser


def main():
    steve = LeaderUser('Steve Rogers')
    tony = LeaderUser('Tony Stark')
    thor = NormalUser('Thor')
    bruce = NormalUser('Bruce Banner')
    nat = NormalUser('Nathasha Romanoff')
    clint = NormalUser('Clint Barton')

    avengers = InterphoneGroup()
    steve.join_group(avengers)
    tony.join_group(avengers)
    thor.join_group(avengers)
    bruce.join_group(avengers)
    nat.join_group(avengers)
    clint.join_group(avengers)

    tony.send_to_all('Incoming enemy!')

    print()
    steve.send_to_leaders('We need a plan of attack.')

    print()
    clint.send_message(recipient='Thor', msg='Please give me a ride.')


if __name__ == '__main__':
    main()

# Output:
# Tony Stark sends a public message: Incoming enemy!
# Steve Rogers received a message from Tony Stark: Incoming enemy!
# Thor received a message from Tony Stark: Incoming enemy!
# Bruce Banner received a message from Tony Stark: Incoming enemy!
# Nathasha Romanoff received a message from Tony Stark: Incoming enemy!
# Clint Barton received a message from Tony Stark: Incoming enemy!
#
# Steve Rogers sends a message to all the leaders: We need a plan of attack.
# Tony Stark received a message from Steve Rogers: We need a plan of attack.
#
# Clint Barton sends a message to Thor: Please give me a ride.
# Thor received a message from Clint Barton: Please give me a ride.
