#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Company module.
"""

__author__ = 'Ziang Lu'

from enum import Enum, auto


class Company(Enum):
    """
    Company enumeration.
    """
    Google = auto()
    Apple = auto()


def process_company_name(company: Company) -> str:
    """
    Processes the given company and returns the company name.
    :param company: Company
    :return: str
    """
    company_str = str(company)
    dot = company_str.find('.')
    return company_str[dot + 1:]
