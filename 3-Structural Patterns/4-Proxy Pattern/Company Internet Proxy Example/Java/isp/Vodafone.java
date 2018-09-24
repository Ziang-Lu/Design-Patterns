package isp;

/**
 * Vodafone class that works as "RealSubject", which is the real Internet
 * Service Provider (ISP).
 *
 * @author Ziang Lu
 */
class Vodafone implements InternetServiceProvider {

    @Override
    public String getResource(String url) {
        return "[Contents in " + url + "]";
    }

}
