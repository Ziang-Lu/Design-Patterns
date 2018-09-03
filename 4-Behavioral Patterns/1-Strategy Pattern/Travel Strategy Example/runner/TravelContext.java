package runner;

import strategy.TravelStrategy;

/**
 * Traveler class works as the director, an interface to the outside world: it
 * wraps a travel strategy and the traveler will use that travel strategy to go
 * to the airport.
 *
 * @author Ziang Lu
 */
public class Traveler {

    /**
     * Travel strategy to use.
     */
    private TravelStrategy travelStrategy;

    /**
     * Mutator of travelStrategy.
     * Client will set what travel strategy to use by calling this method.
     * @param travelStrategy travel strategy to use
     */
    public void setTravelStrategy(TravelStrategy travelStrategy) {
        this.travelStrategy = travelStrategy;
    }

    /**
     * Operation to use the underlying strategy to go to the airport.
     */
    public void useStrategyToGotoAirport() {
        travelStrategy.gotoAirport();
    }

}
