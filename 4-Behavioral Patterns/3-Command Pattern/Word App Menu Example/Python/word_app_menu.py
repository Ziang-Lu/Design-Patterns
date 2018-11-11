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
    __slots__ = ['_filename']

    def __init__(self, filename: str):
        """
        Constructor with parameter.
        :param filename: str
        """
        self._filename = filename

    @property
    def filename(self) -> str:
        return self._filename

    def open(self) -> None:
        """
        Opens this Word document.
        :return: None
        """
        print(f'{self._filename} has been opened.')

    def save(self) -> None:
        """
        Opens this Word document.
        :return: None
        """
        print(f'{self._filename} has been saved.')

    def close(self) -> None:
        """
        Closes this Word document.
        :return: None
        """
        print(f'{self._filename} has been saved.')


class WordDocumentCommand(ABC):
    """
    Abstract WordDocumentCommand class that works as "Command".
    This abstract class represents a request, and defines only one execute()
    method, which executes this command; this abstract class also contains a
    reference to a "Receiver", which is responsible for, in the execute()
    method, perform some actions and thus handle the request.
    """
    __slots__ = ['_doc']

    def __init__(self):
        """
        Default constructor.
        """
        self._doc = None

    def set_doc(self, doc: WordDocument) -> None:
        """
        Mutator of doc.
        :param doc: WordDocument
        :return: None
        """
        self._doc = doc

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
    This command opens a Word document.
    """
    __slots__ = []

    def __init__(self):
        """
        Default constructor.
        """
        super().__init__()
        print('An open command [Command] has been created.')

    def set_doc(self, doc):
        print(f'Setting a Word document [Receiver] for open command [Command] '
              f'as {doc.filename}.')
        super().set_doc(doc)

    def execute(self):
        # Let the Word document [Receiver] handle this open command [Command]
        self._doc.open()


class SaveCommand(WordDocumentCommand):
    """
    Concrete SaveCommand class that works as "ConcreteCommand".
    This command saves a Word document.
    """
    __slots__ = []

    def __init__(self):
        """
        Default constructor.
        """
        super().__init__()
        print('A save command [Command] has been created.')

    def set_doc(self, doc):
        print(f'Setting a Word document [Receiver] for save command [Command] '
              f'as {doc.filename}.')
        super().set_doc(doc)

    def execute(self):
        # Let the Word document [Receiver] handle this save command [Command]
        self._doc.save()


class CloseCommand(WordDocumentCommand):
    """
    Concrete CloseCommand class that works as "ConcreteCommand".
    This command closes a Word document.
    """
    __slots__ = []

    def __init__(self):
        """
        Default constructor.
        """
        super().__init__()
        print('A close command [Command] has been created.')

    def set_doc(self, doc):
        print(f'Setting a Word document [Receiver] for close command [Command] '
              f'as {doc.filename}.')
        super().set_doc(doc)

    def execute(self):
        # Let the Word document [Receiver] handle this close command [Command]
        self._doc.close()


class Menu(object):
    """
    Menu class that works as "Invoker".
    This class is responsible for executing the different "Command"s.
    The "Invoker" does not know how to handle the request, but simply invoke
    command.execute() method, and let the internal correct "Receive" handle the
    request.
    """
    __slots__ = ['_commands', '_command_history']

    def __init__(self):
        """
        Default constructor.
        """
        self._commands = {
            'open': OpenCommand(),
            'save': SaveCommand(),
            'close': CloseCommand()
        }
        self._command_history = []

    def set_command_doc(self, doc: WordDocument) -> None:
        """
        Sets the Word document for the commands.
        :param doc: WordDocument
        :return:
        """
        for command in self._commands.values():
            command.set_doc(doc)

    def click(self, button: str) -> None:
        """
        User clicks the given button on this menu.
        :param button: str
        :return: None
        """
        if button in self._commands:
            print(f'Menu [Invoker] starts executing the {button} command '
                  f'[Command]...')
            # self._commands[button].execute()
            command = self._commands[button]
            command.execute()
            self._command_history.append(command)

    def print_command_history(self) -> None:
        """
        Prints the command history.
        :return: None
        """
        print('Command history')
        for command in self._command_history:
            print(command)
