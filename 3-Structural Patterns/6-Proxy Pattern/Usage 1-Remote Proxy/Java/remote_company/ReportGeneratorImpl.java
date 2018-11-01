package remote_company;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;

/**
 * Concrete ReportGeneratorImpl class that works as "RealSubject".
 * This class resides in a remote machine (a remote JVM, and thus a remote
 * network). Thus, an instance of this class is referred to as a "remote
 * object", which is the object that the client want to call methods on.
 *
 * This class needs some functionality related to being remote, so we let this
 * class extend UnicastRemoteObject and let that class do the work for us.
 *
 * @author Ziang Lu
 */
public class ReportGeneratorImpl extends UnicastRemoteObject implements ReportGenerator {

    /**
     * Default constructor.
     * @throws RemoteException if failed to export the newly created object
     */
    protected ReportGeneratorImpl() throws RemoteException {
        super();
    }

    @Override
    public String generateDailyReport() {
        System.out.print("[REMOTE] Generating a daily report...");
        StringBuilder s = new StringBuilder();
        s.append("***** Daily Report *****").append('\n');
        s.append(Calendar.getInstance().getTime().toString());
        System.out.println("done");
        return s.toString();
    }

    /**
     * Remote driver program.
     * @param args argument from command line
     */
    public static void main(String[] args) {
        try {
            // Register the remote object in the RMI Registry
//            Remote stub = UnicastRemoteObject.exportObject(new ReportGeneratorImpl(), 5000);
            Naming.bind("rmi://localhost:5000/report_generator", new ReportGeneratorImpl());
            // At the same time, a stub object corresponding to this remote object is created in the RMI Registry

            System.out.println("[REMOTE] Registered a remote ReportGeneratorImpl object, and a corresponding stub " +
                    "object is created");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
