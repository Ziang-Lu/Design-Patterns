#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Remote company side (server-side) module.
"""

__author__ = 'Ziang Lu'

from datetime import datetime

import Pyro4


@Pyro4.expose  # Expose this class to remote method calls
class ReportGeneratorImpl:
    """
    ReportGeneratorImpl class that works as "RealSubject".
    This class resides in a remote machine (thus a remote network). Thus, an
    instance of this class is referred to as a "remote object", which is the
    object that the client want to call methods on.

    Since Pyro will add a few Pyro-specific attributes to a remote object, we
    better not restrict "__slots__" of this class.
    """

    def generate_daily_report(self) -> str:
        """
        Generates and returns a daily report.
        Since the returned object will be transmitted back to the client over
        networking, the type of this returned object must be serializable.
        :return: str
        """
        print('\n[SERVER] Generating a daily report...', end='')
        s = '\n***** Daily Report *****\n'
        s += str(datetime.now())
        print('done')
        return s


def setup_server():
    # 1. Create the server (Pyro daemon)
    # In order to nicely free the resources of the Pyro daemon when the request
    # loop is terminated, we can use it as a context manager.
    with Pyro4.Daemon(port=5000) as daemon:
        print('[SERVER] Server created.')

        # 2. Register the remote class on the server (Pyro daemon)
        uri = daemon.register(ReportGeneratorImpl, objectId='report_generator')
        # If we pass in a class directly, the returned URI will be the URI of
        # that registered class; for each session (proxy connection), Pyro will
        # automatically instantiate that class.
        print(f'[SERVER] Registered a remote ReportGeneratorImpl class with '
              f'URI [{uri}] on the Pyro daemon')

        # 3. Start the server (Pyro daemon)
        daemon.requestLoop()


if __name__ == '__main__':
    setup_server()

# Output:
# [SERVER] Server created.
# [SERVER] Registered a remote ReportGeneratorImpl object with URI [PYRO:report_generator@localhost:5000] on the Pyro deamon
#
# [SERVER] Generating a daily report...done
