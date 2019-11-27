#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Application that actually uses Observer Pattern with multi-threading.
"""

__author__ = 'Ziang Lu'

import random
import time
from threading import Thread, current_thread

from company import Company, process_company_name
from observer import StockHolder
from subject import StockCenter


def get_the_stock(stock_center: StockCenter, company: Company,
                  interval: int) -> None:
    """
    Thread function monitoring the changing price for the given company.
    :param stock_center: StockCenter
    :param company: Company
    :param interval: int
    :return: None
    """
    for _ in range(3):
        time.sleep(interval)

        changed_percent = random.random() * 0.06 - 0.03
        new_price = stock_center.get_price(company) * (1 + changed_percent)
        print(f'{current_thread().name} New price for '
              f'{process_company_name(company)}: {new_price:.2f}')
        stock_center.set_price(company, new_price)


def main():
    stock_center = StockCenter()
    google_holder = StockHolder(Company.Google)
    google_holder.follow(stock_center)
    apple_holder = StockHolder(Company.Apple)
    apple_holder.follow(stock_center)

    Thread(
        name='[Thread-Google Price Changing]', target=get_the_stock,
        args=(stock_center, Company.Google, 2)
    ).start()
    Thread(
        name='[Thread-Apple Price Changing]', target=get_the_stock,
        args=(stock_center, Company.Apple, 2)
    ).start()


if __name__ == '__main__':
    main()

# Output:
# [Thread-Google Price Changing] New price for Google: 97.32
# [Thread-Apple Price Changing] New price for Apple: 78.20
# [Thread-Google Price Changing] StockHolder (ID: 1) got an update on Google Price: 97.32
# [Thread-Apple Price Changing] StockHolder (ID: 2) got an update on Apple Price: 78.20
# [Thread-Google Price Changing] New price for Google: 98.93
# [Thread-Apple Price Changing] New price for Apple: 76.70
# [Thread-Google Price Changing] StockHolder (ID: 1) got an update on Google Price: 98.93
# [Thread-Apple Price Changing] StockHolder (ID: 2) got an update on Apple Price: 76.70
# [Thread-Google Price Changing] New price for Google: 96.17
# [Thread-Apple Price Changing] New price for Apple: 77.16
# [Thread-Google Price Changing] StockHolder (ID: 1) got an update on Google Price: 96.17
# [Thread-Apple Price Changing] StockHolder (ID: 2) got an update on Apple Price: 77.16
