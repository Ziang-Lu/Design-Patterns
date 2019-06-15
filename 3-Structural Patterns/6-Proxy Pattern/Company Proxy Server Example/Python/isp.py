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
    def get_resource(self, url: str, ip: str) -> str:
        """
        Returns the contents in the given URL.
        :param url: str
        :param ip: str
        :return: str
        """
        pass

    def _log_request(self, url: str, ip: str) -> None:
        """
        Protected helper method to log the request for the given URL from the
        given IP address.
        :param url: str
        :param ip: str
        :return: None
        """
        print(f'[{datetime.now()}] Request for - {url} from IP: {ip}')


class Vodafone(InternetServiceProvider):
    """
    Vodafone class that works as "RealSubject", which the real ISP.
    """
    __slots__ = []

    def get_resource(self, url, ip):
        # Note that the real ISP will only know the request comes from the
        # company proxy
        self._log_request(url, ip)
        return f'[Contents in {url}]'


class CompanyInternetProxy(InternetServiceProvider):
    """
    CompanyInternetProxy class that works as "Proxy", or a proxy server.

    Usually, a company will limit the sites that its employees can or cannot
    access. For example, the employees are not allowed to access gaming sites
    during work time.
    This can be achieved by using Proxy Pattern: the company simply add a
    "Proxy"(CompanyInternetProxy) between the browser and the real ISP, and all
    of the requests to the real ISP must go through the "Proxy" first.
    In the "Proxy", we can perform the filtering based on the requested site. In
    this way, the company is able to limit the browser's access to sites with
    the real ISP.

    In the company proxy, the proxy can also cache the responses of the
    requested sites for some time, so that next time another user under the same
    proxy requests the same site, CompanyProxyInternet will not forward the
    request again to the site, but simply return the response it previously
    cached.

    Meanwhile, the company proxy server can also make the actual user anonymous
    to the real ISP, e.g., by replacing the actual user's IP address with the
    company proxy's IP address, so that the real ISP will only know the request
    comes from the company proxy.
    """
    __slots__ = ['_real_isp']

    _PROXY_IP = '2.2.2.2'
    _cache = {}

    @staticmethod
    def _is_blocked(url: str) -> bool:
        """
        Private helper method to check whether the given URL is blocked by this
        proxy.
        :param url: str
        :return: bool
        """
        return 'gaming' in url

    def __init__(self):
        """
        Default constructor.
        """
        self._real_isp = Vodafone()

    def get_resource(self, url, ip):
        self._log_request(url, ip)
        # 1. Perform the filtering based on the requested URL
        if self._is_blocked(url):
            return 'This URL is blocked as per company policy'
        # 2. Check whether the response of the requested URL has already been
        # cached
        if url in self._cache:
            return self._cache[url]
        # 3. Forward the request to the real ISP, replacing the actual user's IP
        # address with the company proxy's IP address
        response = self._real_isp.get_resource(url, self._PROXY_IP)
        # Put the response in the cache
        self._cache[url] = response
        return response
