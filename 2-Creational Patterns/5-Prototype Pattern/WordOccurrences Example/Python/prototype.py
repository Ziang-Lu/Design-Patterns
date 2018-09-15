#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Prototype module.
"""

__author__ = 'Ziang Lu'


class WordOccurrences(object):
    """
    Class to buffer the positions of occurrences for a word within some text.

    Recall that one of the applicabilities of Prototype Pattern is:
    Avoid the inherent cost of creating a new object in the standard way (using
    the 'new' operator), when it us prohibitively expensive for a given
    application.

    This is exactly the case.
    The construction of one object is expensive since it performs expensive
    searching operations in the initialization process. Thus if we want to get a
    new instance with the same attributes using the standard way (using the
    'new') operator, we have to do the expensive searching operations again.
    Thus, we simply use Prototype Pattern, and clones a copy of the prototype
    every time we need a new instance.
    """
    __slots__ = ['_text', '_word', '_occurrences']

    def __init__(self, text: str, word: str):
        """
        Constructor with parameter.
        :param text: str
        :param word: str
        """
        self._text = text
        self._word = word
        self._occurrences = []

        idx = 0
        while idx < len(text):
            parse_end = min(idx + len(word), len(text))
            word_in_text = text[idx:parse_end]
            if word_in_text.lower() == word.lower():
                self._occurrences.append(idx)
                idx = parse_end
            else:
                idx += 1

    def get_nth_occurrence(self, n: int):
        """
        Returns the position of word's n-th occurrence in text (zero-based).
        :param n: int
        :return: int
        """
        # Check whether the input index is valid
        if n < 0 or n >= len(self._occurrences):
            return -1
        return self._occurrences[n]
