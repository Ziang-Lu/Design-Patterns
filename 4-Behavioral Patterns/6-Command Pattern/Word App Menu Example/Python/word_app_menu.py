#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Word Application menu module.
"""

__author__ = 'Ziang Lu'

from abc import ABC, abstractmethod


class WordDocument(object):
    """
    WordDocument class that works as the "Receiver" for "WordDocumentCommand".
    """
    __slots__ = ['_filename', '_command_history']

    def __init__(self, filename: str):
        self._filename = filename
        self._command_history = []

    @property
    def filename(self) -> str:
        return self._filename

    def open(self, open_command) -> None:
        """
        Opens this Word document.
        :param open_command: OpenCommand
        :return: None
        """
        print(f'{self._filename} has been opened.')
        self._command_history.append(open_command)

    def save(self, save_command) -> None:
        """
        Opens this Word document.
        :param save_command: SaveCommand
        :return: None
        """
        print(f'{self._filename} has been saved.')
        self._command_history.append(save_command)

    def close(self, close_command) -> None:
        """
        Closes this Word document.
        :param close_command: CloseCommand
        :return: None
        """
        print(f'{self._filename} has been saved.')
        self._command_history.append(close_command)

    def print_command_history(self) -> None:
        """
        Prints the command history on this Word document.
        :return: None
        """
        print(f'Command history on {self._filename}:')
        for command in self._command_history:
            print(command)


class WordDocumentCommand(ABC):
    """
    Abstract WordDocumentCommand class that works as "Command".
    This abstract class represents a request, and defines only one execute()
    method, which executes this command; this abstract also contains a reference
    to a "Receiver", which is responsible for, in the execute() method, perform
    some actions and thus handle the request.
    """
    __slots__ = ['_doc']

    def __init__(self):
        """
        Default constructor.
        """
        self._doc = None

    @abstractmethod
    def execute(self) -> None:
        """
        Executes this command.
        We let the receiver perform some actions and thus handle the request.
        :return: None
        """
        pass


class OpenCommand(WordDocumentCommand):
    """
    Concrete OpenCommand class that works as "ConcreteCommand".
    """
    __slots__ = []

    def __init__(self):
        """
        Default constructor.
        """
        super().__init__()
        print('An open command [Command] has been created.')

    def set_doc(self, doc: WordDocument) -> None:
        """
        Mutator of doc.
        :param doc: WordDocument
        :return: None
        """
        print(f'Setting a Word document [Receiver] for open command [Command] '
              f'as {doc.filename}.')
        self._doc = doc

    def execute(self):
        # Let the Word document [Receiver] handle this open command [Command]
        self._doc.open(self)


class SaveCommand(WordDocumentCommand):
    """
    Concrete SaveCommand class that works as "ConcreteCommand".
    """
    __slots__ = []

    def __init__(self):
        """
        Default constructor.
        """
        super().__init__()
        print('A save command [Command] has been created.')

    def set_doc(self, doc: WordDocument) -> None:
        """
        Mutator of doc.
        :param doc: WordDocument
        :return: None
        """
        print(f'Setting a Word document [Receiver] for save command [Command] '
              f'as {doc.filename}.')
        self._doc = doc

    def execute(self):
        # Let the Word document [Receiver] handle this save command [Command]
        self._doc.save(self)


class CloseCommand(WordDocumentCommand):
    """
    Concrete CloseCommand class that works as "ConcreteCommand".
    """
    __slots__ = []

    def __init__(self):
        """
        Default constructor.
        """
        super().__init__()
        print('A close command [Command] has been created.')

    def set_doc(self, doc: WordDocument) -> None:
        """
        Mutator of doc.
        :param doc: WordDocument
        :return: None
        """
        print(f'Setting a Word document [Receiver] for close command [Command] '
              f'as {doc.filename}.')
        self._doc = doc

    def execute(self):
        # Let the Word document [Receiver] handle this close command [Command]
        self._doc.close(self)


class Menu(object):
    """
    Menu class that works as "Invoker".
    This class is responsible for executing the different "Command"s.
    The "Invoker" does not know how to handle the request, but simply invoke
    command.execute() method, and let the internal correct "Receive" handle the
    request.
    """
    __slots__ = ['_open_command', '_save_command', '_close_command']

    def __init__(self):
        """
        Default constructor.
        """
        self._open_command = OpenCommand()
        self._save_command = SaveCommand()
        self._close_command = CloseCommand()

    def set_command_doc(self, doc: WordDocument):
        """
        Sets the Word document for the commands.
        :param doc:
        :return:
        """
        self._open_command.set_doc(doc)
        self._save_command.set_doc(doc)
        self._close_command.set_doc(doc)

    def click_open(self) -> None:
        """
        User clicks "open" button on this menu.
        :return: None
        """
        print(f'Menu [Invoker] starts executing the open command [Command]...')
        self._open_command.execute()

    def click_save(self) -> None:
        """
        User clicks "save" button on this menu.
        :return: None
        """
        print(f'Menu [Invoker] starts executing the save command [Command]...')
        self._save_command.execute()

    def click_close(self) -> None:
        """
        User clicks "close" button on this menu.
        :return: None
        """
        print(f'Menu [Invoker] starts executing the close command [Command]...')
        self._close_command.execute()
