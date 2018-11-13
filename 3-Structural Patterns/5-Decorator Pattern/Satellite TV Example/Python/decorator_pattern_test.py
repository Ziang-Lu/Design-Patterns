#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Application that actually uses Decorator Pattern.
"""

__author__ = 'Ziang Lu'

from satellite_tv import (
    SatelliteTVWithCartoonNetwork, SatelliteTVWithDiscovery,
    SatelliteTVWithEspn, SkyTV
)


def main():
    tv1 = SatelliteTVWithCartoonNetwork(SatelliteTVWithEspn(SkyTV()))
    tv1.show(50)
    tv1.show(150)
    tv1.show(250)
    tv1.show(350)
    print(f'Total cost: ${tv1.get_subscription_cost()}')

    print()

    tv2 = SatelliteTVWithCartoonNetwork(
        SatelliteTVWithDiscovery(SatelliteTVWithEspn(SkyTV()))
    )
    tv2.show(50)
    tv2.show(150)
    tv2.show(250)
    tv2.show(350)
    print(f'Total cost: ${tv2.get_subscription_cost()}')


if __name__ == '__main__':
    main()

# Output:
# Enjoy the news!
# Enjoy the football game!
# You have not subscribed yet. Please subscribe.
# Enjoy the Mickey Mouse!
# Cost of the normal package: $100
# Cost of ESPN channels: $8
# Cost of Cartoon Network channels: $5
# Total cost: $113
#
# Enjoy the news!
# Enjoy the football game!
# Enjoy the boring documentary.
# Enjoy the Mickey Mouse!
# Cost of the normal package: $100
# Cost of ESPN channels: $8
# Cost of Discovery channels: $10
# Cost of Cartoon Network channels: $5
# Total cost: $123
