package flyweight.customization;

/**
 * BMWCarCustomization class.
 * This class encapsulates all the extrinsic states for a FlyweightBMWCar.
 *
 * @author Ziang Lu
 */
public class BMWCarCustomization {

    /**
     * Tire size of the car.
     */
    private final int tireSize;
    /**
     * Laser signature of the car.
     */
    private final String laserSignature;

    /**
     * Constructor with parameter.
     * @param tireSize tire size of the car
     * @param laserSignature laser signature of the car
     */
    public BMWCarCustomization(int tireSize, String laserSignature) {
        this.tireSize = tireSize;
        this.laserSignature = laserSignature;
    }

    /**
     * Accessor of tire size.
     * @return tire size
     */
    public int tireSize() {
        return tireSize;
    }

    /**
     * Accessor of laserSignature.
     * @return laserSignature
     */
    public String laserSignature() {
        return laserSignature;
    }

    /**
     * Prints this customization.
     */
    public void printCustomization() {
        System.out.println("Tire Size: " + tireSize);
        System.out.println("Laser Signature: " + laserSignature);
        System.out.println("Laser Signature length: " + laserSignature.length());
    }

}
