#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
User interface module.
"""

__author__ = 'Ziang Lu'

from model import EndingChoice, Monster, Room, Treasure


class MonsterMazeGame(object):
    """
    MonsterMazeGame class that actually uses Composite Pattern.
    """

    def __init__(self, start: Room):
        """
        Constructor with parameter.
        :param start: Room
        """
        self._curr = start
        self._game_over = False

    def play_game(self) -> None:
        """
        Plays the game (main control loop).
        :return: None
        """
        self._print_instructions()
        while True:
            input_ = input().strip()
            self._handle_input(input_)
            if self._game_over:
                break
            self._curr.print_next_choices()
        print('The end.')

    def _print_instructions(self) -> None:
        """
        Private helper function to print the instructions.
        :return: None
        """
        print(
            "Welcome to Monster Maze, a dangerous 'choose your own path' game!"
        )
        print('You will travel through the maze by selecting a choice out of '
              'every set of options.')
        print('Once you made a choice, there is no way back!')
        print("Enter 'Q' to quit the game at any time.")
        print('Good luck!')

        self._curr.print_next_choices()

    def _handle_input(self, input_: str) -> None:
        """
        Private helper function to handle the given input.
        :param input_: str
        :return: None
        """
        if input_:
            try:
                num = int(input_)
                if num > 0:
                    self._handle_option(num)
            except ValueError:
                self._handle_state_change()

    def _handle_option(self, option: int) -> None:
        """
        Helper function to handle the given option in the current room.
        :param option: int
        :return: None
        """
        if option <= 0 or option >= self._curr.get_num_of_choices():
            print('You have entered an invalid input. Please try again.')
            return
        choice = self._curr.get_choice(option)
        if isinstance(choice, EndingChoice):
            choice.print_outcome()
            self._game_over = True
            return
        self._curr = choice

    def _handle_state_change(self, input_: str) -> None:
        """
        Helper function to handle state change according to the given input.
        :param input_: str
        :return: None
        """
        if input_ == 'Q':
            self._game_over = True
        else:
            print('You have entered an invalid input. Please try again.')


def main():
    r1 = Room(id_=1)
    r2 = Room(id_=2)
    r3 = Room(id_=3)
    r4 = Room(id_=4)
    r5 = Room(id_=5)
    r6 = Room(id_=6)

    m1 = Monster()
    m2 = Monster()

    t = Treasure(prize=100)

    r1.add_choice(r2)
    r1.add_choice(r4)

    r2.add_choice(r3)
    r2.add_choice(r6)

    r3.add_choice(r4)
    r3.add_choice(m1)
    m1.set_treasure(t)
    r3.add_choice(t)

    r4.add_choice(r5)
    r5.add_choice(m2)

    r6.add_choice(t)

    game = MonsterMazeGame(start=r1)
    game.play_game()


if __name__ == '__main__':
    main()
