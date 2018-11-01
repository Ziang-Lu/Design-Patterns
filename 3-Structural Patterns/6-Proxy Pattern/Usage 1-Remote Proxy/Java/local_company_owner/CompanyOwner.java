package local_company_owner;

import remote_company.ReportGenerator;

import java.rmi.Naming;

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
            // Look up the name, and get the stub object, which is a remote proxy
            ReportGenerator reportGenerator = (ReportGenerator) Naming.lookup("rmi://localhost:5000/report_generator");
            System.out.println("\n[LOCAL] Fetched a stub object for ReportGeneratorImpl\n");
            // Invoke methods on this stub object, as if it is invoking the remote object
            System.out.println(reportGenerator.generateDailyReport());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
