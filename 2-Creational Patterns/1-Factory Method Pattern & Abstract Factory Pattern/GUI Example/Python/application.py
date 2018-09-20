#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Application that actually use the concrete factories.
"""

__author__ = 'Ziang Lu'

from factory import GuiFactory, OsxFactory, WinFactory


class Renderer(object):
    """
    Renderer class for a specific operating system.
    Note that a renderer knows nothing about which concrete type of GuiFactory
    to use, and thus which concrete type of MyButton product to create
    """
    __slots__ = ['_gui_factory']

    def __init__(self, gui_factory: GuiFactory):
        """
        Constructor with parameter.
        :param gui_factory: GuiFactory
        """
        self._gui_factory = gui_factory

    def render(self) -> None:
        """
        Renders the application by creating an abstract button from the abstract
        factory and painting the button.
        :return: None
        """
        button = self._gui_factory.create_button()
        button.paint()


def main():
    osx_factory = OsxFactory.get_instance()
    osx_renderer = Renderer(osx_factory)
    osx_renderer.render()

    win_factory = WinFactory.get_instance()
    win_renderer = Renderer(win_factory)
    win_renderer.render()


if __name__ == '__main__':
    main()

# Output:
# This is a MaxOSX button.
# This is a Windows button.
