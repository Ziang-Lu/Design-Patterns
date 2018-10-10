package turn_on_and_off;

import appliance_implementor.ApplianceImplementor;

/**
 * Abstract TurnOnAndOff class that works as "Abstraction".
 * This class defines turnOn() and turnOff() methods for the client to call, and
 * holds a reference to an appliance, so that the client will use this
 * turn-on-and-off operation to control that appliance.
 *
 * @author Ziang Lu
 */
public abstract class TurnOnAndOff {

    /**
     * Appliance to control by this turn-on-and-off abstraction
     */
    private ApplianceImplementor appliance;

    /**
     * Constructor with parameter.
     * @param appliance appliance to control by the turn-on-and-off abstraction
     */
    protected TurnOnAndOff(ApplianceImplementor appliance) {
        this.appliance = appliance;
    }

    /**
     * Turns on the controlled appliance.
     */
    public void turnOn() {
        appliance.turnOn();
    }

    /**
     * Turns off the controlled appliance.
     */
    public void turnOff() {
        appliance.turnOff();
    }

}
