package flyweight;

import flyweight.car.FlyweightBMWCar;
import flyweight.car_factory.BMWCarFactory;
import flyweight.car_factory.BMWSeries1Factory;
import flyweight.car_factory.BMWSeries2Factory;

import java.util.HashMap;
import java.util.Map;

/**
 * FlyweightBMWCarFactory class that actually uses Flyweight Pattern.
 * Flyweight Pattern stores already existing similar objects
 * ("ConcreteFlyweight") in a cache, so that they can easily be used (shared),
 * and creates a new object only when no matching object is found.
 *
 * This class is implemented as a singleton class.
 *
 * @author Ziang Lu
 */
public class FlyweightBMWCarFactory {

    /**
     * Singleton instance.
     */
    private volatile static FlyweightBMWCarFactory instance = null;

    /**
     * Gets the singleton instance.
     * This implementation utilizes Lazy Initialization Pattern and double-check
     * locking mechanism.
     * @return singleton instance
     */
    public static FlyweightBMWCarFactory getInstance() {
        FlyweightBMWCarFactory localRef = instance;
        if (localRef == null) {
            synchronized (FlyweightBMWCarFactory.class) {
                if (localRef == null) {
                    instance = localRef = new FlyweightBMWCarFactory();
                }
            }
        }
        return localRef;
    }

    public enum Model {
        Series1, Series2
    }

    /**
     * Cached flyweight models.
     */
    private Map<Model, FlyweightBMWCar> flyweightModels = new HashMap<>();

    /**
     * Private default constructor.
     * This has to be private so that the class instances cannot be created
     * outside of the class.
     */
    private FlyweightBMWCarFactory() {}

    /**
     * Gets the flyweight car of the given model.
     *
     * Note that since we'll be handling a large number of "ConcreteFlyweight"
     * object requests, which may come from multiple threads, we need to take
     * concurrency into consideration.
     * Thus, this implementation utilizes double-check locking mechanism.
     *
     * @param model model to get
     * @return corresponding flyweight model
     */
    public FlyweightBMWCar getFlyweightBMWCar(Model model) {
        if (!flyweightModels.containsKey(model)) {
            BMWCarFactory bmwCarFactory = null;
            switch (model) {
                case Series1:
                    bmwCarFactory = BMWSeries1Factory.getInstance();
                    break;
                default:
                    bmwCarFactory = BMWSeries2Factory.getInstance();
                    break;
            }
            synchronized (FlyweightBMWCarFactory.class) {
                if (!flyweightModels.containsKey(model)) {
                    flyweightModels.put(model, bmwCarFactory.createCar());
                }
            }
        }
        return flyweightModels.get(model);
    }

}
