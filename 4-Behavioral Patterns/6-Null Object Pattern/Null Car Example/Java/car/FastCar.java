package car;

/**
 * Concrete product FastCar class.
 *
 * @author Ziang Lu
 */
class FastCar extends Car {

    /**
     * Default constructor.
     */
    FastCar() {
        System.out.println("Creating a Fast Car");
    }

    @Override
    public void speedUp() {
        currSpeed += 10;
        System.out.println("Speeding up... Current speed: " + currSpeed);
    }

}
