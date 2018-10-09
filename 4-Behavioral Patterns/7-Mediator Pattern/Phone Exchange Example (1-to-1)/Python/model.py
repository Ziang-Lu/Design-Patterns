#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Model module.
"""

__author__ = 'Ziang Lu'

import random
from abc import ABC


class PhoneExchange(object):
    """
    PhoneExchange class that works as "Mediator".
    A "Mediator" object acts as the communication center for "ConcreteColleague"
    objects.
    """
    __slots__ = ['_directory']

    @staticmethod
    def _get_three_digit() -> str:
        """
        Static helper function to generate a three-digit string.
        :return: str
        """
        return str(random.randint(100, 999))

    @staticmethod
    def _get_four_digit() -> str:
        """
        Static helper function to generate a four-digit string.
        :return: str
        """
        return str(random.randint(1000, 9999))

    def __init__(self):
        """
        Default constructor.
        """
        self._directory = {}

    def register(self, customer) -> str:
        """
        Register the given phone customer and assigns a phone number to this
        customer.
        :param customer: PhoneCustomer
        :return: str
        """
        phone_number = self._get_phone_number()
        self._directory[phone_number] = customer
        return phone_number

    def _get_phone_number(self) -> str:
        """
        Private helper function to generate a phone number.
        :return: str
        """
        valid = False
        phone_number = None
        while not valid:
            phone_number = self._get_three_digit() + '-' + \
                self._get_three_digit() + '-' + self._get_four_digit()
            if phone_number not in self._directory:
                valid = True
        return phone_number

    def route(self, caller_number: str, recipient_number: str,
              msg: str) -> None:
        """
        Routes a call with the given message from the given caller to a
        recipient with the given number (if any).
        :param caller_number: str
        :param recipient_number: str
        :param msg: str
        :return: None
        """
        if recipient_number not in self._directory:
            print('Failed.')
            return
        print('Successful!')
        self._directory[recipient_number].receive_call(
            caller_number=caller_number, msg=msg
        )


class PhoneCustomer(ABC):
    """
    Abstract PhoneCustomer class that works as "Colleague".
    When a "Colleague" object needs to communicate to another "Colleague"
    object, it does not directly call on the other "Colleague" object; instead,
    it calls the "Mediator" object whose main duty is to route the message to
    the destination "Colleague" object.
    In this way, the communication complexity between the "Colleague" objects
    are greatly reduced.
    """
    __slots__ = ['_name', '_phone_number', '_phone_exchange']

    def __init__(self, name: str, phone_exchange: PhoneExchange) -> None:
        """
        Constructor with parameter.
        :param name: str
        :param phone_exchange: PhoneExchange
        """
        self._name = name
        self._phone_number = phone_exchange.register(self)
        self._phone_exchange = phone_exchange

    @property
    def phone_number(self) -> str:
        """
        Accessor of phone_number.
        :return: str
        """
        return self._phone_number

    def call(self, recipient_number: str, msg: str) -> None:
        """
        Calls the given recipient with the given message.
        :param recipient_number: str
        :param msg: str
        :return: None
        """
        print(f'{self._name} calling {recipient_number} with the message: {msg}'
              f' ...')
        self._phone_exchange.route(caller_number=self._phone_number,
                                   recipient_number=recipient_number, msg=msg)

    def receive_call(self, caller_number: str, msg: str) -> None:
        """
        Receives a call from the given number with the given message.
        :param caller_number: str
        :param msg: str
        :return: None
        """
        print(f'{self._name} received a call from {caller_number} with message:'
              f' {msg}')


class NormalPhoneCustomer(PhoneCustomer):
    """
    Concrete NormalPhoneCustomer class that works as "ConcreteColleague".
    Normal phone customers have limited number of calls per month.
    """
    __slots__ = []

    _CALLS_PER_MONTH = 50

    def __init__(self, name: str, phone_exchange: PhoneExchange):
        """
        Constructor with parameter.
        :param name: str
        :param phone_exchange: PhoneExchange
        """
        super().__init__(name, phone_exchange)

    def __repr__(self):
        return f'NormalPhoneCustomer[name={self._name}, ' \
               f'phone_number={self._phone_number} with ' \
               f'{self._CALLS_PER_MONTH} calls per month]'


class MemberPhoneCustomer(PhoneCustomer):
    """
    Concrete MemberPhoneCustomer class that works as "ConcreteColleague".
    Member phone customers have unlimited number of calls per month.
    """
    __slots__ = []

    def __init__(self, name: str, phone_exchange: PhoneExchange):
        """
        Constructor with parameter.
        :param name: str
        :param phone_exchange: PhoneExchange
        """
        super().__init__(name, phone_exchange)

    def __repr__(self):
        return f'MemberPhoneCustomer[name={self._name}, ' \
               f'phone_number={self._phone_number} with unlimited calls per ' \
               f'month'
