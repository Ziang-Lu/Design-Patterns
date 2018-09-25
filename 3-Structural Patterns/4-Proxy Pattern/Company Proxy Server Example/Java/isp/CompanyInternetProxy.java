package isp;

import java.util.HashMap;
import java.util.Map;

/**
 * CompanyInternetProxy class that works as "Proxy", or a proxy server.
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
 * In the company proxy, the proxy can also cache the responses of the requested
 * sites for some time, so that next time another user under the same proxy
 * requests the same site, CompanyProxyInternet will not forward the request
 * again to the site, but simply return the response it previously cached.
 *
 * Meanwhile, the company proxy server can also make the actual user anonymous
 * to the real ISP, e.g., by replacing the actual user's IP address with the
 * company proxy's IP address, so that the real ISP will only know the request
 * comes from the company proxy.
 *
 * @author Ziang Lu
 */
public class CompanyInternetProxy extends InternetServiceProvider {

    /**
     * IP address of the company proxy server.
     */
    private static final String PROXY_IP = "2.2.2.2";

    /**
     * Cache of the responses.
     */
    private static Map<String, String> cache = new HashMap<>();

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
    public String getResource(String url, String ip) {
        logRequest(url, ip);
        // 1. Perform the filtering based on the requested URL
        if (isBlocked(url)) {
            return "This URL is blocked as per company policy";
        }
        // 2. Check whether the response of the requested URL has already been cached
        if (cache.containsKey(url)) {
            return cache.get(url);
        }
        // 3. Forward the request to the real ISP, replacing the actual user's IP address with the company proxy's IP
        // address
        String response = realIsp.getResource(url, PROXY_IP);
        // Put the response in the cache
        cache.put(url, response);
        return response;
    }

}
