#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Application that actually uses Publish-Subscribe Pattern for messaging.
"""

__author__ = 'Ziang Lu'

from model import Client, PubSubServer


def main():
    server = PubSubServer()
    cli1 = Client('Chris', server)
    cli1.subscribe('news')
    cli2 = Client('Tony', server)
    cli2.subscribe('news')
    cli3 = Client('Someone', server)

    print()
    cli3.publish('news', "It's a good day!")


if __name__ == '__main__':
    main()


# Output:
# Chris starts subscribing to channel-[news]
# Tony starts subscribing to channel-[news]
#
# Someone publishes message 'It's a good day!' to channel-[news]
# Chris receives message It's a good day! from channel-[news]
# Tony receives message It's a good day! from channel-[news]
