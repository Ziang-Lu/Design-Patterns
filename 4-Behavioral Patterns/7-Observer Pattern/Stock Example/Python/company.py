#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Company module.
"""

from enum import Enum


class Company(Enum):
    """
    Company enumeration.
    """
    Google = 1
    Apple = 2


def process_company_name(company: Company) -> str:
    """
    Processes the given company and returns the company name.
    :param company: Company
    :return: str
    """
    company_str = str(company)
    dot = company_str.find('.')
    return company_str[dot + 1:]