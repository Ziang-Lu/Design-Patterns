package flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * FlyweightShapeFactory class that actually uses Flyweight Pattern.
 * Flyweight Pattern stores already existing similar objects
 * ("ConcreteFlyweight") in a cache, so that they can easily be used (shared),
 * and creates a new object only when no matching object is found.
 *
 * This class is implemented as a singleton class.
 *
 * @author Ziang Lu
 */
public class FlyweightShapeFactory {

    /**
     * Singleton instance.
     */
    private volatile static FlyweightShapeFactory instance = null;

    /**
     * Gets the singleton instance.
     * This implementation utilizes Lazy Initialization Pattern and double-check
     * locking mechanism.
     * @return singleton instance
     */
    public static FlyweightShapeFactory getInstance() {
        if (instance == null) {
            synchronized (FlyweightShapeFactory.class) {
                if (instance == null) {
                    instance = new FlyweightShapeFactory();
                }
            }
        }
        return instance;
    }

    /**
     * Cached flyweight shapes.
     */
    private Map<String, FlyweightShape> flyweightShapes = new HashMap<>();

    /**
     * Private default constructor.
     * This has to be private so that the class instances cannot be created
     * outside of the class.
     */
    private FlyweightShapeFactory() {}

    /**
     * Gets the flyweight shape of the given type.
     *
     * Note that since we'll be handling a large number of "ConcreteFlyweight"
     * object requests, which may come from multiple threads, we need to take
     * concurrency into consideration.
     * Thus, this implementation utilizes double-check locking mechanism.
     *
     * @param shapeType shape type to get
     * @return corresponding flyweight shape
     */
    public FlyweightShape getFlyweightShape(String shapeType) {
        if (!flyweightShapes.containsKey(shapeType)) {
            synchronized (FlyweightShapeFactory.class) {
                if (!flyweightShapes.containsKey(shapeType)) {
                    if (shapeType.equalsIgnoreCase("circle")) {
                        flyweightShapes.put("circle", new SharedCircle());
                    } else if (shapeType.equalsIgnoreCase("rectangle")) {
                        flyweightShapes.put("rectangle", new SharedRectangle());
                    }
                }
            }
        }
        return flyweightShapes.get(shapeType);
    }

}
