package turn_on_and_off;

import appliance_implementor.ApplianceImplementor;

/**
 * Concrete OnOffSwitch class that works as "ConcreteAbstraction".
 * This turn-on-and-off operation controls an appliance using a on/off switch.
 *
 * @author Ziang Lu
 */
public class OnOffSwitch extends TurnOnAndOff {

    /**
     * Constructor with parameter.
     * @param appliance appliance to control by the turn-on-and-off abstraction
     */
    public OnOffSwitch(ApplianceImplementor appliance) {
        super(appliance);
    }

}
