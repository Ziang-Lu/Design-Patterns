#!usr/bin/env python3
# -*- coding: utf -*-

"""
Internet Service Provider (ISP) module.
"""

__author__ = 'Ziang Lu'

from abc import ABC, abstractmethod
from datetime import datetime


class InternetServiceProvider(ABC):
    """
    Abstract InternetServiceProvider class that works as "Subject".

    In order to let the "Proxy" controls the access to its hiding "RealSubject"
    behind the scene, the "Proxy" needs to provide similar API as the
    "RealSubject".
    Therefore, we simply let this step be done via letting "RealSubject" and
    "Proxy" share a common super class "Subject", in which we define only the
    methods that we want the "Proxy" to provide access to.
    """
    __slots__ = []

    @abstractmethod
    def get_resource(self, url: str) -> str:
        """
        Returns the contents in the given URL.
        :param url: str
        :return: str
        """
        pass


class Vodafone(InternetServiceProvider):
    """
    Vodafone class that works as "RealSubject", which the real ISP.
    """
    __slots__ = []

    def get_resource(self, url):
        return f'[Contents in {url}]'


class CompanyInternetProxy(InternetServiceProvider):
    """
    CompanyInternetProxy class that works as "Proxy".

    Usually, a company will limit the sites that its employees can or cannot
    access. For example, the employees are not allowed to access gaming sites
    during work time.
    This can be achieved by using Proxy Pattern: the company simply add a
    "Proxy" (CompanyInternetProxy) between the browser and the real ISP, and all
    of the request to the real ISP must go through the "Proxy" first.
    In this "Proxy", we can perform the filtering based on the requested site.
    In this way, the company is able to limit the browser's access to sites with
    the real ISP.
    """
    __slots__ = ['_real_isp']

    @staticmethod
    def _log_request(url: str) -> None:
        """
        Private static helper function to log the request for the given URL.
        :param url: str
        :return: None
        """
        print(f'[{datetime.now()}] Request for - {url}')

    @staticmethod
    def _is_blocked(url: str) -> bool:
        """
        Private static helper function to check whether the given URL is blocked
        by this proxy.
        :param url: str
        :return: bool
        """
        return 'gaming' in url

    def __init__(self):
        """
        Default constructor.
        """
        self._real_isp = Vodafone()

    def get_resource(self, url):
        # First log the request
        self._log_request(url)
        # Perform the filtering based on the requested URL
        if self._is_blocked(url):
            return 'This URL is blocked as per company policy'
        return self._real_isp.get_resource(url)
