package flyweight.car;

import flyweight.customization.BMWCarCustomization;

/**
 * Abstract FlyweightBMWCar class that works as "Flyweight".
 * This abstract class enables sharing but does not enforce it; it defines
 * "operation(extrinsicState)" to customize a "ConcreteFlyweight" to a
 * "UnsharedConcreteFlyweight".
 *
 * In this specific example, all of the extrinsic states are separately
 * encapsulated in its own BMWCarCustomization class, so that when we want to
 * customize our FlyweightBMWCar, we simply pass in a BMWCarCustomization
 * object, which has all the extrinsic states we desire in it.
 *
 * @author Ziang Lu
 */
public abstract class FlyweightBMWCar {

    /**
     * Prints full characteristics of this car according to the given
     * customization.
     * @param customization customization of this car
     */
    public void printFullCharacteristics(BMWCarCustomization customization) {
        customization.printCustomization();
    }

    /**
     * Calculates the total price for this car according to the given
     * customization.
     * @param customization customization of this car
     * @return total price of this car
     */
    public abstract int calcPrice(BMWCarCustomization customization);

    /**
     * Protected helper method to get the base price for this car (without
     * customization).
     * @return base price of this car
     */
    protected abstract int getBasePrice();

}
