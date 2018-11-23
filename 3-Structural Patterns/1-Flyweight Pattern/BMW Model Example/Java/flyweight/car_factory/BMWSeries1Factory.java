package flyweight.car_factory;

import flyweight.car.FlyweightBMWCar;
import flyweight.car.BMWSeries1;

/**
 * Concrete factory BMWSeries1Factory class.
 * This class is implemented as a singleton class.
 *
 * @author Ziang Lu
 */
public class BMWSeries1Factory implements BMWCarFactory {

    /**
     * Singleton instance.
     */
    private volatile static BMWSeries1Factory instance = null;

    /**
     * Gets the singleton instance.
     * This implementation utilizes Lazy Initialization Pattern and double-check
     * locking mechanism.
     * @return singleton instance
     */
    public static BMWSeries1Factory getInstance() {
        BMWSeries1Factory localRef = instance;
        if (localRef == null) {
            synchronized (BMWSeries1Factory.class) {
                if (localRef == null) {
                    instance = localRef = new BMWSeries1Factory();
                }
            }
        }
        return localRef;
    }

    /**
     * Private default constructor.
     * This has to be private so that the class instances cannot be created
     * outside of the class.
     */
    private BMWSeries1Factory() {}

    /**
     * Concrete factory method to make a concrete product BMWSeries1 instance.
     * @return instantiated FlyweightBMWCar
     */
    @Override
    public FlyweightBMWCar createCar() {
        return new BMWSeries1();
    }

}
