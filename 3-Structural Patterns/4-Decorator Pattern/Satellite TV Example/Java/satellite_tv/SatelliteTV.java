package satellite_tv;

/**
 * Abstract SatelliteTV interface that works as "Component".
 *
 * @author Ziang Lu
 */
public interface SatelliteTV {

    /**
     * Shows the channel according to the given channel number.
     * @param channelNumber given channel number
     */
    void show(int channelNumber);

    /**
     * Gets the total subscription cost of the package.
     * @return total subscription cost
     */
    int getSubscriptionCost();

}
