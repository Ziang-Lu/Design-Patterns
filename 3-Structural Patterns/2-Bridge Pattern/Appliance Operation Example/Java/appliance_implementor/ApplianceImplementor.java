package appliance_implementor;

/**
 * Abstract appliance implementor interface that works as "Implementor" to
 * define the methods that the concrete implementation classes must implement.
 * This interface acts as a bridge between the abstraction layer and the
 * concrete implementation classes.
 *
 * @author Ziang Lu
 */
public interface ApplianceImplementor {

    /**
     * Turns on this appliance.
     */
    void turnOn();

    /**
     * Turns off this appliance.
     */
    void turnOff();

}
