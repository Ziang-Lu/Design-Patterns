package runner;

import satellite_tv.SatelliteTV;
import satellite_tv.SatelliteTVWithCartoonNetwork;
import satellite_tv.SatelliteTVWithDiscovery;
import satellite_tv.SatelliteTVWithEspn;
import satellite_tv.SkyTV;

/**
 * Application that actually uses Decorator Pattern.
 *
 * @author Ziang Lu
 */
public class Application {

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        SatelliteTV tv1 = new SatelliteTVWithCartoonNetwork(new SatelliteTVWithEspn(new SkyTV()));
        tv1.show(50);
        tv1.show(150);
        tv1.show(250);
        tv1.show(350);
        System.out.println("Total cost: $" + tv1.getSubscriptionCost());

        System.out.println();

        SatelliteTV tv2 = new SatelliteTVWithCartoonNetwork(
                new SatelliteTVWithDiscovery(new SatelliteTVWithEspn(new SkyTV())));
        tv2.show(50);
        tv2.show(150);
        tv2.show(250);
        tv2.show(350);
        System.out.println("Total cost: $" + tv2.getSubscriptionCost());

        /*
         * Output:
         * Enjoy the news!
         * Enjoy the football game!
         * You have not subscribed yet. Please subscribe.
         * Enjoy the Mickey Mouse!
         * Cost of the normal package: $100
         * Cost of ESPN channels: $8
         * Cost of Cartoon Network channels: $5
         * Total cost: $113
         *
         * Enjoy the news!
         * Enjoy the football game!
         * Enjoy the boring documentary.
         * Enjoy the Mickey Mouse!
         * Cost of the normal package: $100
         * Cost of ESPN channels: $8
         * Cost of Discovery channels: $10
         * Cost of Cartoon Network channels: $5
         * Total cost: $123
         */
    }

}
