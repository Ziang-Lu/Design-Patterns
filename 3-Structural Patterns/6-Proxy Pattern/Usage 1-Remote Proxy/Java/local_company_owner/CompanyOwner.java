package local_company_owner;

import remote_company.ReportGenerator;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Application that works as "Client".
 * This class resides in a local machine (a local JVM, and thus a local
 * network).
 *
 * @author Ziang Lu
 */
public class CompanyOwner {

    /**
     * Local driver program.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        try {
            // 3. Get the registry on localhost, listening on port 5000
            Registry registry = LocateRegistry.getRegistry(null, 5000);

            // 4. Look up the name, and get the stub object, which is a remote proxy
            ReportGenerator reportGenerator = (ReportGenerator) registry.lookup("report_generator");
            System.out.println("[LOCAL] Fetched a stub object for ReportGeneratorImpl\n");

            // 5. Invoke methods on this stub object, as if it is invoking the remote object
            System.out.println(reportGenerator.generateDailyReport());
            System.out.println("From " + reportGenerator.getClass().getSimpleName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*
         * Output:
         * [LOCAL] Fetched a stub object for ReportGeneratorImpl
         *
         * ***** Daily Report *****
         * Wed Oct 31 21:28:33 PDT 2018
         * From $Proxy0
         */
    }

}
