#!usr/bin/env python3
# -*- coding: utf -*-

"""
Application module.
"""

__author__ = 'Ziang Lu'

from isp import CompanyInternetProxy, InternetServiceProvider


class Browser:
    """
    Browser class that actually uses Proxy Pattern.
    """
    __slots__ = []

    _BROWSER_IP = '1.1.1.1'

    @staticmethod
    def _get_company_internet() -> InternetServiceProvider:
        """
        Private helper method to get the company Internet, which is an ISP
        proxy.
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
        response = company_internet.get_resource(url, self._BROWSER_IP)
        print(f'Browser received a response: {response}')


def main():
    browser = Browser()
    browser.send_request()

    # Input: www.google.com
    # Output:
    # Browser sending request to the ISP for www.google.com
    # [2018-09-24 17:00:05.929140] Request for - www.google.com from IP: 1.1.1.1
    # [2018-09-24 17:00:05.929186] Request for - www.google.com from IP: 2.2.2.2
    # Browser received a response: [Contents in www.google.com]

    # Input: www.gaming.com
    # Output:
    # Browser sending request to the ISP for www.gaming.com
    # [2018-09-24 17:00:28.853518] Request for - www.gaming.com from IP: 1.1.1.1
    # Browser received a response: This URL is blocked as per company policy


if __name__ == '__main__':
    main()
