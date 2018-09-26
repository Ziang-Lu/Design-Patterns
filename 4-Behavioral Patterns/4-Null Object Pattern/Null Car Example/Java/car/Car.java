package car;

/**
 * Abstract product Car class.
 *
 * @author Ziang Lu
 */
public abstract class Car {

    /**
     * Current speed of this car.
     */
    protected int currSpeed = 0;

    /**
     * Accessor of currSpeed.
     * @return currSpeed
     */
    public int currSpeed() {
        return currSpeed;
    }

    /**
     * Checks whether the current speed of this car exceeds the given desired
     * speed.
     * @param desiredSpeed given desired speed
     * @return whether the current speed exceeds the given desired speed
     */
    public boolean exceedingSpeed(int desiredSpeed) {
        return currSpeed > desiredSpeed;
    }

    /**
     * Speeds this car up.
     */
    public abstract void speedUp();

}
