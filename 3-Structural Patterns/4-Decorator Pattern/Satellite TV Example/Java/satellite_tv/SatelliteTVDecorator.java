package satellite_tv;

/**
 * Abstract SatelliteTVDecorator class that works as "Decorator".
 * This is essentially a wrapper that reproduces the functionality of an
 * existing class and adds new functionality to it, without impacting existing
 * structure and functionality of the objects.
 *
 * However, since decorators should be stackable, which means we should be able
 * to add decorators on decorators on decorators...... to further increase the
 * provided functionalities.
 * Thus, we let different "ConcreteComponent" classes and the abstract
 * "Decorator" both inherit from the common super class "Component", so that
 * "Decorator" will only have an abstract "Component" object to decorate, but
 * does not need to care it will actually decorate a "ConcreteComponent" or
 * another "Decorator".
 *
 * Note that since for "Decorator", we are forwarding the request from the
 * client to the "Component" it's decorating, we are actually in some sense
 * using Delegation Pattern here
 *
 * @author Ziang Lu
 */
abstract class SatelliteTVDecorator implements SatelliteTV {

    /**
     * Satellite TV to decorate.
     * Dynamically customize and add functionality to this SatelliteTV instance,
     * which could either be a SatelliteTV or some other SatelliteTVDecorator.
     */
    protected SatelliteTV satelliteTV;

    /**
     * Protected constructor with parameter.
     * @param satelliteTV satellite TV to decorate
     */
    protected SatelliteTVDecorator(SatelliteTV satelliteTV) {
        this.satelliteTV = satelliteTV;
    }

}
