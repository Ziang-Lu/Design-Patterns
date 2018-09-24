package isp;

import java.util.Calendar;

/**
 * CompanyInternetProxy class that works as "Proxy".
 *
 * Usually, a company will limit the sites that its employees can or cannot
 * access. For example, the employees are not allowed to access gaming sites
 * during work time.
 * This can be achieved by using Proxy Pattern: the company simply add a "Proxy"
 * (CompanyInternetProxy) between the browser and the real ISP, and all of the
 * requests to the real ISP must go through the "Proxy" first.
 * In the "Proxy", we can perform the filtering based on the requested site. In
 * this way, the company is able to limit the browser's access to sites with the
 * real ISP.
 *
 * @author Ziang Lu
 */
public class CompanyInternetProxy implements InternetServiceProvider {

    /**
     * Private static helper method to log the request for the given URL.
     * @param url given URL
     */
    private static void logRequest(String url) {
        System.out.println("[" + Calendar.getInstance().getTime() + "] Request for - " + url);
    }

    /**
     * Private static helper method to check whether the given URL is blocked by
     * this proxy.
     * @param url given URL
     * @return whether the given URL is blocked
     */
    private static boolean isBlocked(String url) {
        return url.contains("gaming");
    }

    /**
     * Real ISP to limit access to.
     */
    private Vodafone realIsp = new Vodafone();

    @Override
    public String getResource(String url) {
        // First log the request
        logRequest(url);
        // Perform the filtering based on the requested URL
        if (isBlocked(url)) {
            return "This URL is blocked as per company policy";
        }
        return realIsp.getResource(url);
    }

}
