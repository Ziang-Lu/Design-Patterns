package car;

/**
 * NullCar class that works as null objects.
 * A NullCar object does nothing to indicate that a Car object does not exist.
 *
 * This class is implemented as a singleton class.
 *
 * @author Ziang Lu
 */
class NullCar extends Car {

    /**
     * Singleton instance.
     */
    private volatile static NullCar instance = null;

    /**
     * Gets the singleton instance.
     * This implementation utilizes Lazy Initialization Pattern and double-check
     * locking mechanism.
     * @return singleton instance
     */
    static NullCar getInstance() {
        if (instance == null) {
            synchronized (NullCar.class) {
                if (instance == null) {
                    instance = new NullCar();
                }
            }
        }
        return instance;
    }

    /**
     * Private default constructor.
     * This has to be private so that the class instances cannot be created
     * outside of the class.
     */
    private NullCar() {}

    @Override
    public boolean exceedingSpeed(int desiredSpeed) {
        return true;
    }

    @Override
    public void speedUp() {
        // Do nothing
        System.out.println("Null Car encountered");
    }

}
