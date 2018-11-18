#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Remote company side (server-side) module.
"""

from datetime import datetime

import Pyro4


@Pyro4.expose  # Expose this class to remote method calls
class ReportGeneratorImpl:
    """
    ReportGeneratorImpl class that works as "RealSubject".
    This class resides in a remote machine (thus a remote network). Thus, an
    instance of this class is referred to as a "remote object", which is the
    object that the client want to call methods on.
    """
    __slots__ = []

    def generate_daily_report(self) -> str:
        """
        Generates and returns a daily report.
        Since the returned object will be transmitted back to the client over
        networking, the type of this returned object must be serializable.
        :return: str
        """
        print('\n[REMOTE] Generating a daily report...', end='')
        s = '\n***** Daily Report *****\n'
        s += str(datetime.now())
        print('done')
        return s


def setup_server():
    # 2. Create the server (Pyro daemon)
    with Pyro4.Daemon() as daemon:
        print('[SERVER] Server started.')

        # 3. Register the remote class on the server (Pyro daemon)
        uri = daemon.register(ReportGeneratorImpl)
        # If we pass in a class directly, the returned URI will be the URI of
        # that registered class; for each session (proxy connection), Pyro will
        # automatically instantiate that class.
        print(f'[SERVER] Registered a remote ReportGeneratorImpl class with '
              f'URI [{uri}] on the Pyro daemon')

        # 4. Also register the remote class in the name server
        ns = Pyro4.locateNS(port=5000)
        ns.register('report_generator', uri)
        print(f'[NAME SERVER] Registered a URI [{uri}] with name '
              f'"report_generator" in the name server')

        # 5. Start the server (Pyro daemon)
        daemon.requestLoop()


if __name__ == '__main__':
    setup_server()

# Output:
# [SERVER] Server started.
# [SERVER] Registered a remote ReportGeneratorImpl class with URI [PYRO:obj_31050e224ba34ef28a1227c5ad77fb69@localhost:55017] on the Pyro daemon
# [NAME SERVER] Registered a URI [PYRO:obj_31050e224ba34ef28a1227c5ad77fb69@localhost:55017] with name "report_generator" in the name server
#
# [REMOTE] Generating a daily report...done
