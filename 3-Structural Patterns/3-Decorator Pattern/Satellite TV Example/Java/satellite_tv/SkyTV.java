package satellite_tv;

/**
 * SkyTV class that that works as one kind of "ConcreteComponent".
 * Every satellite TV we are going to make will start from a SkyTV.
 *
 * @author Ziang Lu
 */
public class SkyTV implements SatelliteTV {

    @Override
    public void show(int channelNumber) {
        if ((channelNumber >= 0) && (channelNumber < 100)) {
            System.out.println("Enjoy the news!");
        } else {
            System.out.println("You have not subscribed yet. Please subscribe.");
        }
    }

    @Override
    public int getSubscriptionCost() {
        System.out.println("Cost of the normal package: $100");
        return 100;
    }

}
