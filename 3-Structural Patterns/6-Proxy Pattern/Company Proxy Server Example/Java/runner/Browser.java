package runner;

import isp.CompanyInternetProxy;
import isp.InternetServiceProvider;

import java.util.Scanner;

/**
 * Browser class that actually uses Proxy Pattern.
 *
 * @author Ziang Lu
 */
public class Browser {

    /**
     * IP address of the browser.
     */
    private static final String BROWSER_IP = "1.1.1.1";

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
        System.out.print("Enter the site URL: ");
        Scanner scanner = new Scanner(System.in);
        String url = "";
        if (scanner.hasNextLine()) {
            url = scanner.nextLine();
        }

        System.out.println("Browser sending request to the ISP for " + url);
        InternetServiceProvider companyInternet = getCompanyInternet();
        String response = companyInternet.getResource(url, BROWSER_IP);
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
         * [Mon Sep 24 16:02:23 PDT 2018] Request for - www.google.com from IP: 1.1.1.1
         * [Mon Sep 24 16:02:23 PDT 2018] Request for - www.google.com from IP: 2.2.2.2
         * Browser received a response: [Contents in www.google.com]
         */

        // Input: www.gaming.com
        /*
         * Output:
         * Browser sending request to the ISP for www.gaming.com
         * [Mon Sep 24 16:02:47 PDT 2018] Request for - www.gaming.com from IP: 1.1.1.1
         * Browser received a response: This URL is blocked as per company policy
         */
    }

}
