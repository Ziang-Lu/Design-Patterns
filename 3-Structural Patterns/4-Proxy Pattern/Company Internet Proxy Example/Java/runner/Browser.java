package runner;

import isp.InternetServiceProvider;
import isp.CompanyInternetProxy;

import java.util.Scanner;

/**
 * Browser class that actually uses Proxy Pattern.
 *
 * @author Ziang Lu
 */
public class Browser {

    /**
     * Private static helper method to get the company Internet, which is an ISP
     * proxy.
     * @return company Internet which is a proxy
     */
    private static InternetServiceProvider getCompanyInternet() {
        return new CompanyInternetProxy();
    }

    /**
     * Sends a request for the user-input URL.
     */
    public void sendRequest() {
        Scanner scanner = new Scanner(System.in);
        String url = "";
        if (scanner.hasNextLine()) {
            url = scanner.nextLine();
        }

        System.out.println("Browser sending request to the ISP for " + url);
        InternetServiceProvider companyInternet = getCompanyInternet();
        String response = companyInternet.getResource(url);
        System.out.println("Browser received a response: " + response);
    }

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        Browser browser = new Browser();
        browser.sendRequest();

        // Input: www.google.com
        /*
         * Output:
         * Browser sending request to the ISP for www.google.com
         * [Sun Sep 23 21:42:42 PDT 2018] Request for - www.google.com
         * Browser received a response: [Contents in www.google.com]
         */

        // Input: www.fancygaming.com
        /*
         * Output:
         * Browser sending request to the ISP for www.fancygaming.com
         * [Sun Sep 23 21:43:56 PDT 2018] Request for - www.fancygaming.com
         * Browser received a response: This URL is blocked as per company policy
         */
    }

}
