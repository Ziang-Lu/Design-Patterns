package runner;

import appliance_implementor.ApplianceImplementor;
import appliance_implementor.FloorLamp;
import appliance_implementor.TV;
import turn_on_and_off.OnOffSwitch;
import turn_on_and_off.PullCord;
import turn_on_and_off.TurnOnAndOff;

/**
 * Application that actually uses Bridge Pattern.
 *
 * @author Ziang Lu
 */
public class Application {

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        ApplianceImplementor floorLamp = new FloorLamp();
        TurnOnAndOff pullCord = new PullCord(floorLamp);

        pullCord.turnOn();
        pullCord.turnOff();

        TV tv = new TV();
        TurnOnAndOff onOffSwitch = new OnOffSwitch(tv);

        onOffSwitch.turnOn();
        onOffSwitch.turnOff();

        /*
         * Output:
         * Floor Lamp is turned on.
         * Floor Lamp is turned off.
         * TV is turned on.
         * TV is turned off.
         */
    }

}
