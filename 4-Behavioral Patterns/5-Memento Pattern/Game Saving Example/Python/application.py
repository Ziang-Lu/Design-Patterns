#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Game module that works as "Caretaker".
This module is responsible for keeping a collection of "Memento", but never
examines or operates on the contents of a "Memento".
"""

__author__ = 'Ziang Lu'

import random
from datetime import datetime

from player import IMemento, Player

memo_map = {}  # Stored mapping between dates and the corresponding mementos


def _get_memento(date: datetime) -> IMemento:
    """
    Private helper function to get the memento associated with the given date.
    :param date: datetime object
    :return: IMemento
    """
    return memo_map[date]


def _add_memento(date: datetime, memo: IMemento) -> None:
    """
    Private helper function to store the given memento associated with the given
    date.
    :param date: datetime
    :param memo: IMemento
    :return: None
    """
    memo_map[date] = memo


def main():
    # Create a player of level 7
    player = Player(level=7, life=0.95)
    print(f'Player status: {player}')

    # Enter Checkpoint-8
    print()
    print('Entering Checkpoint-8:')

    # Save the state of the player before entering Checkpoint-8
    before_check_8 = datetime.now()
    memo = player.create_memento()
    _add_memento(before_check_8, memo)

    trial = 1
    while True:
        print()
        if random.random() < 0.8:
            player.fail()
            print(f'Trial #{trial} failed. Player status: {player}')

            # If failed to pass Checkpoint-8, restore the player to the state
            # before entering this checkpoint, and keep attempting
            player.restore(_get_memento(before_check_8))
            trial += 1
        else:
            player.succeed()
            print(f'Trial #{trial} succeeded. Player status: {player}')

            # If succeeded to pass Checkpoint-8, go straight to the next
            # checkpoint
            break


if __name__ == '__main__':
    main()

# Output:
# Player status: Player[level=7, life=0.95]
#
# Entering Checkpoint-8:
# Created a memento for Player: Memento [player_level=7, player_life=0.95]
#
# Trial #1 failed. Player status: Player[level=7, life=0.095]
# Player restoring to Memento [player_level=7, player_life=0.95]...
#
# Trial #2 failed. Player status: Player[level=7, life=0.095]
# Player restoring to Memento [player_level=7, player_life=0.95]...
#
# Trial #3 failed. Player status: Player[level=7, life=0.095]
# Player restoring to Memento [player_level=7, player_life=0.95]...
#
# Trial #4 succeeded. Player status: Player[level=8, life=1.0]
