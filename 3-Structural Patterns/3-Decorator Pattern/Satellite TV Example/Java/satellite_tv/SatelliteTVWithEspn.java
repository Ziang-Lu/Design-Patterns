package satellite_tv;

/**
 * SatelliteTVWithEspn class that works as one kind of "ConcreteDecorator".
 * This class adds (decorates) ESPN channels to a SatelliteTV ("Component")
 * object.
 *
 * @author Ziang Lu
 */
public class SatelliteTVWithEspn extends SatelliteTVDecorator {

    /**
     * Constructor with parameter.
     * @param satelliteTV satellite TV to decorate
     */
    public SatelliteTVWithEspn(SatelliteTV satelliteTV) {
        super(satelliteTV);
    }

    @Override
    public void show(int channelNumber) {
        if ((channelNumber >= 100) && (channelNumber < 200)) {
            System.out.println("Enjoy the football game!");
        } else {
            // Forward the request to the encapsulated satellite TV
            satelliteTV.show(channelNumber);
        }
    }

    @Override
    public int getSubscriptionCost() {
        // Returns the cost of the decorated satellite TV after adding ESPN channels to the package
        int total = satelliteTV.getSubscriptionCost() + 8;
        System.out.println("Cost of ESPN channels: $8");
        return total;
    }

}
