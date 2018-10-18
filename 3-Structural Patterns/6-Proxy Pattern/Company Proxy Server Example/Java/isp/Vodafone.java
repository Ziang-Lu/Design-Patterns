package isp;

/**
 * Vodafone class that works as "RealSubject", which is the real Internet
 * Service Provider (ISP).
 *
 * @author Ziang Lu
 */
class Vodafone extends InternetServiceProvider {

    @Override
    public String getResource(String url, String ip) {
        // Note that the real ISP will only know the request comes from the company proxy
        logRequest(url, ip);
        return "[Contents in " + url + "]";
    }

}
