#!usr/bin/env python3
# -*- coding: utf-*-

"""
Text editor application module.
"""

__author__ = 'Ziang Lu'

from text_editor import Memento, TextEditor


class TextEditorApp:
    """
    TextEditorApp class that works as "Caretaker" that actually uses Memento
    Pattern.
    This class is responsible for keeping a collection of "Memento", but never
    examines or operates on the contents of a "Memento".
    """
    __slots__ = ['_text_editor', '_memento_list', '_prev_state_ptr']

    def __init__(self):
        """
        Default constructor.
        """
        self._text_editor = TextEditor()
        self._memento_list = []
        self._prev_state_ptr = -1

    def write(self, text: str) -> None:
        """
        Writes the given text to the text editor.
        :param text: str
        :return: None
        """
        self._text_editor.text = text
        print(f"After writing '{text}': {self._text_editor}")

    def save(self) -> None:
        """
        Saves the current state of the text editor.
        :return: None
        """
        self._add_memento(self._text_editor.create_memento())
        self._prev_state_ptr = len(self._memento_list) - 1

    def _add_memento(self, memo: Memento) -> None:
        """
        Private helper function to store the given memento.
        :param memo: Memento
        :return: None
        """
        self._memento_list.append(memo)

    def undo(self) -> None:
        """
        Undo the most recent change in the text editor.
        :return: None
        """
        print('Undo operation...')
        if self._text_editor.text !=\
                self._memento_list[self._prev_state_ptr].text:
            last_saved_state = self._memento_list[self._prev_state_ptr]
            self._text_editor.restore(last_saved_state)
            print(self._text_editor)
        elif self._prev_state_ptr <= 0:
            print('No more undo operation available!')
        else:
            self._prev_state_ptr -= 1
            prev_state = self._get_memento(self._prev_state_ptr)
            self._text_editor.restore(prev_state)
            print(self._text_editor)

    def _get_memento(self, idx: int) -> Memento:
        """
        Private helper function to get the memento at the given index.
        :param idx: int
        :return: Memento
        """
        return self._memento_list[idx]

    def redo(self) -> None:
        """
        Redoes the most recent change in the text editor.
        :return: None
        """
        print('Redo operation...')
        if self._prev_state_ptr >= len(self._memento_list) - 1:
            print('No more redo operation available!')
            return
        self._prev_state_ptr += 1
        next_state = self._get_memento(self._prev_state_ptr)
        self._text_editor.restore(next_state)
        print(self._text_editor)
