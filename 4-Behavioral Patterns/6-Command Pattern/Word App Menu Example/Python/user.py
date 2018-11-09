#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
User module that actually uses Command Pattern.
"""

__author__ = 'Ziang Lu'

from word_app_menu import Menu, WordDocument


def main():
    doc = WordDocument('Sample File.txt')  # Receiver

    menu = Menu()  # Invoker

    # Set the Word document [Receiver] for the commands [Command]
    print()
    menu.set_command_doc(doc)

    print()
    menu.click_open()
    menu.click_save()
    menu.click_close()

    print()
    doc.print_command_history()

    doc2 = WordDocument('Sample File 2.txt')  # Receiver

    # Set the Word document [Receiver] for the commands [Command]
    print()
    menu.set_command_doc(doc2)

    print()
    menu.click_open()
    menu.click_save()
    menu.click_close()

    print()
    doc2.print_command_history()


if __name__ == '__main__':
    main()

# Output:
# An open command [Command] has been created.
# A save command [Command] has been created.
# A close command [Command] has been created.
#
# Setting a Word document [Receiver] for open command [Command] as Sample File.txt.
# Setting a Word document [Receiver] for save command [Command] as Sample File.txt.
# Setting a Word document [Receiver] for close command [Command] as Sample File.txt.
#
# Menu [Invoker] starts executing the open command [Command]...
# Sample File.txt has been opened.
# Menu [Invoker] starts executing the save command [Command]...
# Sample File.txt has been saved.
# Menu [Invoker] starts executing the close command [Command]...
# Sample File.txt has been saved.
#
# Command history on Sample File.txt:
# <word_app_menu.OpenCommand object at 0x11207d498>
# <word_app_menu.SaveCommand object at 0x11207d558>
# <word_app_menu.CloseCommand object at 0x11207d4c8>
#
# Setting a Word document [Receiver] for open command [Command] as Sample File 2.txt.
# Setting a Word document [Receiver] for save command [Command] as Sample File 2.txt.
# Setting a Word document [Receiver] for close command [Command] as Sample File 2.txt.
#
# Menu [Invoker] starts executing the open command [Command]...
# Sample File 2.txt has been opened.
# Menu [Invoker] starts executing the save command [Command]...
# Sample File 2.txt has been saved.
# Menu [Invoker] starts executing the close command [Command]...
# Sample File 2.txt has been saved.
#
# Command history on Sample File 2.txt:
# <word_app_menu.OpenCommand object at 0x11207d498>
# <word_app_menu.SaveCommand object at 0x11207d558>
# <word_app_menu.CloseCommand object at 0x11207d4c8>
