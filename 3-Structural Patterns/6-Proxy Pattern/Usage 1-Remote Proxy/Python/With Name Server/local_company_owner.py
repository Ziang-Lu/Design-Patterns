#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Local company owner side (client-side) module.
"""

import argparse

import Pyro4


def client_main(ns_port: int, name: str):
    # 6. Get the name server on localhost, listening on the given port number,
    # ns = Pyro4.locateNS(port=ns_port)
    # 7. Look up the name in the name server for the corresponding URI
    # uri = ns.lookup(name)
    # print(f'[CLIENT] Found the corresponding URI for name "{name}"')

    # 8. Create a proxy object, look up the URI for the corresponding remote
    # object, and establish a proxy connection (session)
    # report_generator = Pyro4.Proxy(uri)
    # If the URI is for a remote class, Pyro will instantiate a remote object on
    # the server-side, and then establish a proxy connection (session).

    # The above three steps can be done as follows as a shortcut:
    report_generator = Pyro4.Proxy(f'PYRONAME:{name}@localhost:{ns_port}')
    print('[CLIENT] Created a proxy object for ReportGeneratorImpl, and '
          'established a proxy connection')

    # 9. Invoke methods on the proxy object, as if it is invoking the remote
    # object
    print(report_generator.generate_daily_report())
    print(f'From {type(report_generator).__name__}')


if __name__ == '__main__':
    parser = argparse.ArgumentParser()

    parser.add_argument('--ns_port', type=int,
                        help='Port number that the name server is listening on')
    parser.add_argument(
        '--name',
        help='Name that identifies the desired object in the name server'
    )

    args = parser.parse_args()

    client_main(ns_port=args.ns_port, name=args.name)

# Output:
# [CLIENT] Created a proxy object for ReportGeneratorImpl, and established a proxy connection
#
# ***** Daily Report *****
# 2018-11-06 17:50:03.482846
# From Proxy
