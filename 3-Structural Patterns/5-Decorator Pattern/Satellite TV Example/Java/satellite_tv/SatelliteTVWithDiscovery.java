package satellite_tv;

/**
 * SatelliteTVWithEspn class that works as one kind of "ConcreteDecorator".
 * This class adds (decorates) Discovery channels to a SatelliteTV ("Component")
 * object.
 *
 * @author Ziang Lu
 */
public class SatelliteTVWithDiscovery extends SatelliteTVDecorator {

    /**
     * Constructor with parameter.
     * @param satelliteTV satellite TV to decorate
     */
    public SatelliteTVWithDiscovery(SatelliteTV satelliteTV) {
        super(satelliteTV);
    }

    @Override
    public void show(int channelNumber) {
        if ((channelNumber >= 200) && (channelNumber < 300)) {
            System.out.println("Enjoy the boring documentary.");
        } else {
            // Forward the request to the encapsulated satellite TV
            satelliteTV.show(channelNumber);
        }
    }

    @Override
    public int getSubscriptionCost() {
        // Returns the cost of the decorates satellite TV after adding Discovery channels to the package
        int total = satelliteTV.getSubscriptionCost() + 10;
        System.out.println("Cost of Discovery channels: $10");
        return total;
    }

}
