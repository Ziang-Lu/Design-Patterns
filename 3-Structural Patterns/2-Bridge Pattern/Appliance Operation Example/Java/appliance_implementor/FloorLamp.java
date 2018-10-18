package appliance_implementor;

/**
 * Concrete FloorLamp class that works as "ConcreteImplementor".
 *
 * @author Ziang Lu
 */
public class FloorLamp implements ApplianceImplementor {

    @Override
    public void turnOn() {
        System.out.println("Floor Lamp is turned on.");
    }

    @Override
    public void turnOff() {
        System.out.println("Floor Lamp is turned off.");
    }

}
