package appliance_implementor;

/**
 * Concrete TV class that works as "ConcreteImplementor".
 *
 * @author Ziang Lu
 */
public class TV implements ApplianceImplementor {

    @Override
    public void turnOn() {
        System.out.println("TV is turned on.");
    }

    @Override
    public void turnOff() {
        System.out.println("TV is turned off.");
    }

}
