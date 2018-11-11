package car;

/**
 * Concrete product SlowCar class.
 *
 * @author Ziang Lu
 */
class SlowCar extends Car {

    /**
     * Default constructor.
     */
    SlowCar() {
        System.out.println("Creating a Slow Car");
    }

    @Override
    public void speedUp() {
        currSpeed += 5;
        System.out.println("Speeding up... Current speed: " + currSpeed);
    }

}
