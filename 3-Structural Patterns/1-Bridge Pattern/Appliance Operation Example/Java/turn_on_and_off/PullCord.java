package turn_on_and_off;

import appliance_implementor.ApplianceImplementor;

/**
 * Concrete PullCord class that works as "ConcreteAbstraction".
 * This turn-on-and-off operation controls an appliance using a pull cord.
 *
 * @author Ziang Lu
 */
public class PullCord extends TurnOnAndOff {

    /**
     * Constructor with parameter.
     * @param appliance appliance to control by the turn-on-and-off abstraction
     */
    public PullCord(ApplianceImplementor appliance) {
        super(appliance);
    }

}
