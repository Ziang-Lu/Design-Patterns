package remote_company;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
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
        System.out.print("\n[REMOTE] Generating a daily report...");
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
            // 1. Create and run the RMI Registry on localhost, listening on port 5000
            Registry registry = LocateRegistry.createRegistry(5000);

            // 2. Register the remote object in the RMI Registry
            registry.rebind("report_generator", new ReportGeneratorImpl());

            // At the same time, the corresponding remote proxy class, which also implements ReportGenerator interface,
            // is automatically created dynamically at runtime, and a stub object is instantiated in the RMI Registry.
            // i.e., Implicitly in registry.bind() method, we have something like:
            // ReportGeneratorImpl_Stub stub = UnicastRemoteObject.exportObject(remote, somePort);

            System.out.println("[REMOTE] Registered a remote ReportGeneratorImpl object, and a corresponding stub " +
                    "object is created");
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*
         * Output:
         * [REMOTE] Registered a remote ReportGeneratorImpl object, and a corresponding stub object is created
         *
         * [REMOTE] Generating a daily report...done
         */
    }

}
