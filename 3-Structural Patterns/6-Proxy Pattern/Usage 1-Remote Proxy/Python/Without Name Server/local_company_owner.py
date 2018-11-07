#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Local company owner side (client-side) module.
"""

__author__ = 'Ziang Lu'

import argparse

import Pyro4


def client_main(hostname: str, port: int, object_id: str):
    uri = f'PYRO:{object_id}@{hostname}:{port}'

    # 4. Create a proxy object, look up the URI on the server, and establish a
    # proxy connection (session)
    report_generator = Pyro4.Proxy(uri)
    # If the URI is for a remote class, Pyro will instantiate a remote object on
    # the server-side, and then establish a proxy connection (session).
    print('[CLIENT] Created a proxy object for ReportGeneratorImpl, and '
          'established a proxy connection')

    # 5. Invoke methods on the proxy object, as if it is invoking the remote
    # object
    print(report_generator.generate_daily_report())
    print(f'From {type(report_generator).__name__}')


if __name__ == '__main__':
    parser = argparse.ArgumentParser()

    parser.add_argument(
        '--hostname', help='Hostname that the desired remote object resides in'
    )
    parser.add_argument('--port', type=int,
                        help='Port number that the remote host is listening on')
    parser.add_argument(
        '--object_id',
        help='Object ID that identifies the desired object in the remote host'
    )

    args = parser.parse_args()

    client_main(hostname=args.hostname, port=args.port,
                object_id=args.object_id)

# Output:
# [CLIENT] Created a proxy object for ReportGeneratorImpl, and established a proxy connection
#
# ***** Daily Report *****
# 2018-11-05 23:33:53.666541
# From Proxy
