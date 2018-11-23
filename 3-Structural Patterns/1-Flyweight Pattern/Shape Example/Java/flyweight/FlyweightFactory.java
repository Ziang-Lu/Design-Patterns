package flyweight;

import flyweight.circle.ColoredCircle;
import flyweight.circle.FlyweightCircle;
import flyweight.rect.ColoredRectangle;
import flyweight.rect.FlyweightRectangle;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

/**
 * FlyweightFactory class that actually uses Flyweight Pattern.
 * Flyweight Pattern stores already existing similar objects
 * ("ConcreteFlyweight") in a cache, so that they can easily be used (shared),
 * and creates a new object only when no matching object is found.
 *
 * This class is implemented as a singleton class.
 *
 * @author Ziang Lu
 */
public class FlyweightFactory {

    /**
     * Singleton instance.
     */
    private volatile static FlyweightFactory instance = null;

    /**
     * Gets the singleton instance.
     * This implementation utilizes Lazy Initialization Pattern and double-check
     * locking mechanism.
     * @return singleton instance
     */
    public static FlyweightFactory getInstance() {
        FlyweightFactory localRef = instance;
        if (localRef == null) {
            synchronized (FlyweightFactory.class) {
                if (localRef == null) {
                    instance = localRef = new FlyweightFactory();
                }
            }
        }
        return localRef;
    }

    /**
     * Cached flyweight colored circles.
     */
    private Map<Color, FlyweightCircle> flyweightCircles = new HashMap<>();
    /**
     * Cached flyweight colored rectangles.
     */
    private Map<Color, FlyweightRectangle> flyweightRects = new HashMap<>();

    /**
     * Private default constructor.
     * This has to be private so that the class instances cannot be created
     * outside of the class.
     */
    private FlyweightFactory() {}

    /**
     * Gets the flyweight colored circle of the given color.
     *
     * Note that since we'll be handling a large number of "ConcreteFlyweight"
     * object requests, which may come from multiple threads, we need to take
     * concurrency into consideration.
     * Thus, this implementation utilizes double-check locking mechanism.
     * @param color color of the flyweight colored circle to get
     * @return flyweight colored circle
     */
    public FlyweightCircle getColoredCircle(Color color) {
        if (!flyweightCircles.containsKey(color)) {
            synchronized (FlyweightFactory.class) {
                if (!flyweightCircles.containsKey(color)) {
                    flyweightCircles.put(color, new ColoredCircle(color));
                }
            }
        }
        return flyweightCircles.get(color);
    }

    /**
     * Gets the flyweight colored rectangle of the given color.
     *
     * Note that since we'll be handling a large number of "ConcreteFlyweight"
     * object requests, which may come from multiple threads, we need to take
     * concurrency into consideration.
     * Thus, this implementation utilizes double-check locking mechanism.
     * @param color color of the flyweight colored rectangle to get
     * @return flyweight colored rectangle
     */
    public FlyweightRectangle getColoredRectangle(Color color) {
        if (!flyweightRects.containsKey(color)) {
            synchronized (FlyweightFactory.class) {
                if (!flyweightRects.containsKey(color)) {
                    flyweightRects.put(color, new ColoredRectangle(color));
                }
            }
        }
        return flyweightRects.get(color);
    }

}
