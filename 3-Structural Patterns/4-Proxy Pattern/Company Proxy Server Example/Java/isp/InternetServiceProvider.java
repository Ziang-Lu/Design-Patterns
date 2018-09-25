package isp;

import java.util.Calendar;

/**
 * Abstract InternetServiceProvider class that works as "Subject".
 *
 * In order to let the "Proxy" controls the access to its hiding "RealSubject"
 * behind the scene, the "Proxy" needs to provide similar API as the
 * "RealSubject".
 * Therefore, we simply let this step be done via letting "RealSubject" and
 * "Proxy" share a common super class "Subject", in which we define only the
 * methods that we want the "Proxy" to provide access to.
 *
 * @author Ziang Lu
 */
public abstract class InternetServiceProvider {

    /**
     * Returns the contents in the given URL.
     * @param url given URL
     * @param ip IP address of the requester
     * @return contents in the given URL
     */
    public abstract String getResource(String url, String ip);

    /**
     * Protected helper method to log the request for the given URL from the
     * given IP address.
     * @param url requested URL
     * @param ip IP address of the requester
     */
    protected void logRequest(String url, String ip) {
        System.out.println("[" + Calendar.getInstance().getTime() + "] Request for - " + url + " from IP: " + ip);
    }

}
