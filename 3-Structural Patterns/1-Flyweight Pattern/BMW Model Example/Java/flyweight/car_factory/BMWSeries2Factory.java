package flyweight.car_factory;

import flyweight.car.FlyweightBMWCar;
import flyweight.car.BMWSeries2;

/**
 * Concrete factory BMWSeries2Factory class.
 * This class is implemented as a singleton class.
 *
 * @author Ziang Lu
 */
public class BMWSeries2Factory implements BMWCarFactory {

    /**
     * Singleton instance.
     */
    private volatile static BMWSeries2Factory instance = null;

    /**
     * Gets the singleton instance.
     * This implementation utilizes Lazy Initialization Pattern and double-check
     * locking mechanism.
     * @return singleton instance
     */
    public static BMWSeries2Factory getInstance() {
        BMWSeries2Factory localRef = instance;
        if (localRef == null) {
            synchronized (BMWSeries2Factory.class) {
                if (localRef == null) {
                    instance = localRef = new BMWSeries2Factory();
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
    private BMWSeries2Factory() {}

    /**
     * Concrete factory method to make a concrete product BMWSeries2 instance.
     * @return instantiated FlyweightBMWCar
     */
    @Override
    public FlyweightBMWCar createCar() {
        return new BMWSeries2();
    }

}
