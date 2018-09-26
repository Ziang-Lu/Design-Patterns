package car;

/**
 * Factory CarFactory class that actually uses Null Object Pattern.
 *
 * @author Ziang Lu
 */
public class CarFactory {

    /**
     * Factory method to make a product Car instance according to the given max
     * speed.
     * @param maxSpeed max speed of the car to make
     * @return instantiated Car
     */
    public static Car getCar(int maxSpeed) {
        // Assumption: maxSpeed > 0
        if (maxSpeed < 70) {
            return new SlowCar();
        } else if (maxSpeed < 120) {
            return new FastCar();
        } else {
            // Normal way: Return a null
//            return null;

            // Null Object Pattern: Return a null object
            return NullCar.getInstance();
        }
    }

    /**
     * Private default constructor.
     * This has to be private so that the class instances cannot be created
     * outside of the class.
     * This will force the client to use the above static method to make Car
     * instances.
     */
    private CarFactory() {}

}
