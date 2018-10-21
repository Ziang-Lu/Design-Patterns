package flyweight.car_factory;

import flyweight.car.FlyweightBMWCar;

/**
 * Abstract factory BMWCarFactory interface.
 *
 * @author Ziang Lu
 */
public interface BMWCarFactory {

    /**
     * Abstract factory method to make an abstract product FlyweightBMWCar
     * instance.
     * However, the ability to determine which concrete type of FlyweightBMWCar
     * product to instantiate is deferred to concrete factories (subclasses).
     * @return instantiated FlyweightBMWCar
     */
    FlyweightBMWCar createCar();

}
