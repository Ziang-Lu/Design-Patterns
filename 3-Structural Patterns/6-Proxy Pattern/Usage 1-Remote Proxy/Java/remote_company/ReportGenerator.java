package remote_company;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Abstract ReportGenerator interface that works as "Subject", or in this case,
 * a "remote interface".
 * The Remote interface serves to identify interfaces whose methods may be
 * invoked from a non-local virtual machine. Only those methods specified in a
 * "remote interface", an interface that extends Remote, like this one, are
 * available remotely.
 *
 * @author Ziang Lu
 */
public interface ReportGenerator extends Remote {

    /**
     * Generates and returns a daily report.
     * Since the returned object will be transmitted back to the client over
     * networking, the type of this returned object must be serializable.
     * @return generated daily report of type String
     * @throws RemoteException any exception during a RMI
     */
    String generateDailyReport() throws RemoteException;

}
