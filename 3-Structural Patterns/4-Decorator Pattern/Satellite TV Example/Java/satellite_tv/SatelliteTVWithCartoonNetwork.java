package satellite_tv;

/**
 * SatelliteTVWithEspn class that works as one kind of "ConcreteDecorator".
 * This class adds (decorates) Cartoon Network channels to a SatelliteTV
 * ("Component") object.
 *
 * @author Ziang Lu
 */
public class SatelliteTVWithCartoonNetwork extends SatelliteTVDecorator {

    /**
     * Constructor with parameter.
     * @param satelliteTV satellite TV to decorate
     */
    public SatelliteTVWithCartoonNetwork(SatelliteTV satelliteTV) {
        super(satelliteTV);
    }

    @Override
    public void show(int channelNumber) {
        if ((channelNumber >= 300) && (channelNumber < 400)) {
            System.out.println("Enjoy the Mickey Mouse!");
        } else {
            // Forward the request to the encapsulated satellite TV
            satelliteTV.show(channelNumber);
        }
    }

    @Override
    public int getSubscriptionCost() {
        // Returns the cost of the decorates satellite TV after adding Cartoon Network channels to the package
        int total = satelliteTV.getSubscriptionCost() + 5;
        System.out.println("Cost of Cartoon Network channels: $5");
        return total;
    }

}
