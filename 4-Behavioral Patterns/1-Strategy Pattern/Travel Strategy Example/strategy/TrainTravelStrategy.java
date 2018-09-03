package strategy;

/**
 * Concrete bus travel strategy class to perform the travel tasks (solve the
 * travel problems) by train.
 *
 * @author Ziang Lu
 */
public class TrainTravelStrategy implements TravelStrategy {

    @Override
    public void gotoAirport() {
        System.out.println("Using " + getClass().getSimpleName() +
                ", the traveler is going to the airport by train, and will be charged $5.");
    }

}
