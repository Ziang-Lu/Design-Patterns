#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Factory module.
"""

__author__ = 'Ziang Lu'

from abc import ABC, abstractmethod

from product_document import (FancyLetter, FancyResume, Letter, ModernLetter,
                              ModernResume, Resume)


class DocumentCreator(ABC):
    """
    Abstract factory DocumentCreator class.
    """
    __slots__ = []

    @abstractmethod
    def create_letter(self) -> Letter:
        """
        Abstract factory method to make an abstract product Letter instance.
        However, the ability to determine which concrete type of Letter product
        to instantiate is deferred to concrete factories (subclasses).
        :return: Letter
        """
        pass

    @abstractmethod
    def create_resume(self) -> Resume:
        """
        Abstract factory method to make an abstract product Resume instance.
        However, the ability to determine which concrete type of Resume product
        to instantiate is deferred to concrete factories (subclasses).
        :return: Resume
        """
        pass


class FancyDocumentCreator(DocumentCreator):
    """
    Concrete factory FancyDocumentCreator class.
    This class is implemented as a singleton class.
    """

    @classmethod
    def get_instance(cls):
        """
        Gets the singleton instance.
        :return: FancyDocumentCreator
        """
        return cls.__new__(cls)

    def __new__(cls, *args, **kwargs):
        if not hasattr(cls, '_instance'):
            cls._instance = super().__new__(cls)
        return cls._instance

    def create_letter(self):
        return FancyLetter()

    def create_resume(self):
        return FancyResume()


class ModernDocumentCreator(DocumentCreator):
    """
    Concrete factory ModernDocumentCreator class.
    This class is implemented as a singleton class.
    """

    @classmethod
    def get_instance(cls):
        """
        Gets the singleton instance.
        :return: ModernDocumentCreator
        """
        return cls.__new__(cls)

    def __new__(cls, *args, **kwargs):
        if not hasattr(cls, '_instance'):
            cls._instance = super().__new__(cls)
        return cls._instance

    def create_letter(self):
        return ModernLetter()

    def create_resume(self):
        return ModernResume()
