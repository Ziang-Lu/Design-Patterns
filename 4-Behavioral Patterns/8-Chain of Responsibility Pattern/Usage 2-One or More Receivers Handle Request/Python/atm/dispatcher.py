#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Dollar dispatcher module.
"""

__author__ = 'Ziang Lu'


from abc import ABC, abstractmethod


class DollarDispatcher(ABC):
    """
    Abstract DollarDispatcher class that works as "Handler".

    In order to let different "ConcreteHandler" be able to process the same
    request, we need them to have similar API.
    Therefore, we simply let this step be done via letting different
    "ConcreteHandler" share a common super class "Handler", in which we define
    the API to process a request.
    """
    __slots__ = ['_next_dispatcher']

    def __init__(self, next_dispatcher):
        """
        Constructor with parameter.
        :param next_dispatcher: DollarDispatcher
        """
        self._next_dispatcher = next_dispatcher
        # This works as the next receiver (handler) in the chain of
        # responsibility: if this receiver cannot handle the request, then it
        # passes the request to the next receiver in the chain of
        # responsibility.

    @abstractmethod
    def _get_denomination(self) -> int:
        """
        Gets the denomination of this dispatcher.
        :return: int
        """
        pass

    def dispatch(self, requested_amount: int) -> None:
        """
        Dispatches notes according to the requested amount of money.
        :param requested_amount: int
        :return: None
        """
        # This receiver handles the request.
        denomination = self._get_denomination()
        num_of_notes = requested_amount // denomination
        if num_of_notes > 0:
            self._dispatch_dollar(denomination, num_of_notes)
        # Check whether the request needs further processing
        pending_amount = requested_amount % denomination
        if pending_amount > 0 and self._next_dispatcher:  # If yes
            # Pass the request to the next receiver in the chain of
            # responsibility
            print(f'After dispatched by {type(self).__name__}: {pending_amount}'
                  f' dollars pending to be dispatched')
            self._next_dispatcher.dispatch(pending_amount)

    def _dispatch_dollar(self, denomination: int, num_of_notes: int) -> None:
        """
        Private helper method to dispatch the given number of notes for the
        given denomination.
        :param denomination: int
        :param num_of_notes: int
        :return: None
        """
        print(f'{type(self).__name__} dispatching {num_of_notes} '
              f'{denomination}-dollar notes')


class HundredDispatcher(DollarDispatcher):
    """
    HundredDispatcher class that works as "ConcreteHandler".
    This class is implemented as a singleton class.
    """

    @classmethod
    def get_instance(cls, next_dispatcher: DollarDispatcher):
        """
        Gets the singleton instance.
        :param next_dispatcher: DollarDispatcher
        :return: HundredDispatcher
        """
        return cls.__new__(cls, next_dispatcher)

    def __new__(cls, *args, **kwargs):
        if not hasattr(cls, '_instance'):
            cls._instance = super().__new__(cls)
            cls._instance.__init__(*args)
        return cls._instance

    def __init__(self, next_dispatcher: DollarDispatcher):
        """
        Constructor with parameter.
        :param next_dispatcher: DollarDispatcher
        """
        super().__init__(next_dispatcher)

    def _get_denomination(self):
        return 100


class TwentyDispatcher(DollarDispatcher):
    """
    TwentyDispatcher class that works as "ConcreteHandler".
    This class is implemented as a singleton class.
    """

    @classmethod
    def get_instance(cls, next_dispatcher: DollarDispatcher):
        """
        Gets the singleton instance.
        :param next_dispatcher: DollarDispatcher
        :return: TwentyDispatcher
        """
        return cls.__new__(cls, next_dispatcher)

    def __new__(cls, *args, **kwargs):
        if not hasattr(cls, '_instance'):
            cls._instance = super().__new__(cls)
            cls._instance.__init__(*args)
        return cls._instance

    def __init__(self, next_dispatcher: DollarDispatcher):
        """
        Constructor with parameter.
        :param next_dispatcher: DollarDispatcher
        """
        super().__init__(next_dispatcher)

    def _get_denomination(self):
        return 20


class TenDispatcher(DollarDispatcher):
    """
    TenDispatcher class that works as "ConcreteHandler".
    This class is implemented as a singleton class.
    """

    @classmethod
    def get_instance(cls, next_dispatcher: DollarDispatcher):
        """
        Gets the singleton instance.
        :param next_dispatcher: DollarDispatcher
        :return: TenDispatcher
        """
        return cls.__new__(cls, next_dispatcher)

    def __new__(cls, *args, **kwargs):
        if not hasattr(cls, '_instance'):
            cls._instance = super().__new__(cls)
            cls._instance.__init__(*args)
        return cls._instance

    def __init__(self, next_dispatcher: DollarDispatcher):
        """
        Constructor with parameter.
        :param next_dispatcher: DollarDispatcher
        """
        super().__init__(next_dispatcher)

    def _get_denomination(self):
        return 10


class FiveDispatcher(DollarDispatcher):
    """
    FiveDispatcher class that works as "ConcreteHandler".
    This class is implemented as a singleton class.
    """

    @classmethod
    def get_instance(cls, next_dispatcher: DollarDispatcher):
        """
        Gets the singleton instance.
        :param next_dispatcher: DollarDispatcher
        :return: FiveDispatcher
        """
        return cls.__new__(cls, next_dispatcher)

    def __new__(cls, *args, **kwargs):
        if not hasattr(cls, '_instance'):
            cls._instance = super().__new__(cls)
            cls._instance.__init__(*args)
        return cls._instance

    def __init__(self, next_dispatcher: DollarDispatcher):
        """
        Constructor with parameter.
        :param next_dispatcher: DollarDispatcher
        """
        super().__init__(next_dispatcher)

    def _get_denomination(self):
        return 5


class OneDispatcher(DollarDispatcher):
    """
    OneDispatcher class that works as "ConcreteHandler".
    This class is implemented as a singleton class.
    """

    @classmethod
    def get_instance(cls):
        """
        Gets the singleton instance.
        :return: OneDispatcher
        """
        return cls.__new__(cls)

    def __new__(cls, *args, **kwargs):
        if not hasattr(cls, '_instance'):
            cls._instance = super().__new__(cls)
        return cls._instance

    def __init__(self):
        """
        Default constructor.
        """
        super().__init__(None)

    def _get_denomination(self):
        return 1
