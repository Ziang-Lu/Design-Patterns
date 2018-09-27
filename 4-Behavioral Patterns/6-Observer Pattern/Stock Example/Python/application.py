#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Application that actually uses Observer Pattern with multi-threading.
"""

__author__ = 'Ziang Lu'

import random
import threading
import time

from company import Company, process_company_name
from observer import StockHolder
from subject import StockCenter

# Lock
lock = threading.Lock()


def get_the_stock(stock_center: StockCenter, company: Company,
                  interval: int) -> None:
    """
    Simulates a thread monitoring the changing price for the given company.
    :param stock_center: StockCenter
    :param company: Company
    :param interval: int
    :return: None
    """
    for _ in range(3):
        time.sleep(interval)

        lock.acquire()
        try:
            changed_percent = random.random() * 0.06 - 0.03
            new_price = stock_center.get_price(company) * (1 + changed_percent)
            print(f'New price for {process_company_name(company)}: '
                  f'{new_price:.2f}')
            stock_center.set_price(company, new_price)
        finally:
            lock.release()  # Ensure that the lock must be released


def main():
    stock_center = StockCenter()
    google_holder = StockHolder(Company.Google)
    google_holder.follow(stock_center)
    apple_holder = StockHolder(Company.Apple)
    apple_holder.follow(stock_center)

    threading.Thread(
        target=get_the_stock, args=(stock_center, Company.Google, 2)
    ).start()
    threading.Thread(
        target=get_the_stock, args=(stock_center, Company.Apple, 2)
    ).start()


if __name__ == '__main__':
    main()

# Output:
# New price for Google: 98.42
# StockHolder (ID: 1) got an update on Google Price: 98.42
# New price for Apple: 77.77
# StockHolder (ID: 2) got an update on Apple Price: 77.77
# New price for Google: 95.72
# StockHolder (ID: 1) got an update on Google Price: 95.72
# New price for Apple: 76.55
# StockHolder (ID: 2) got an update on Apple Price: 76.55
# New price for Google: 94.08
# StockHolder (ID: 1) got an update on Google Price: 94.08
# New price for Apple: 77.77
# StockHolder (ID: 2) got an update on Apple Price: 77.77
