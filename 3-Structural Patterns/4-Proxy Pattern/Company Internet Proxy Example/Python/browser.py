#!usr/bin/env python3
# -*- coding: utf -*-

"""
Application module.
"""

__author__ = 'Ziang Lu'

from isp import CompanyInternetProxy, InternetServiceProvider


class Browser(object):
    """
    Browser class that actually uses Proxy Pattern.
    """
    __slots__ = []

    @staticmethod
    def _get_company_internet() -> InternetServiceProvider:
        """
        Private static helper function to get the company Internet, which is an
        ISP proxy.
        :return: InternetServiceProvider
        """
        return CompanyInternetProxy()

    def send_request(self) -> None:
        """
        Sends a request for the user-input URL.
        :return: None
        """
        url = input('Enter the site URL: ')

        print(f'Browser sending request to the ISP for {url}')
        company_internet = self._get_company_internet()
        response = company_internet.get_resource(url)
        print(f'Browser received a response: {response}')


def main():
    browser = Browser()
    browser.send_request()

    # Input: www.google.com
    # Output:
    # Browser sending request to the ISP for www.google.com
    # [2018-09-23 22:18:30.760738] Request for - www.google.com
    # Browser received a response: [Contents in www.google.com]

    # Input: www.fancygaming.com
    # Output:
    # Browser sending request to the ISP for www.fancygaming.com
    # [2018-09-23 22:18:56.092478] Request for - www.fancygaming.com
    # Browser received a response: This URL is blocked as per company policy


if __name__ == '__main__':
    main()
