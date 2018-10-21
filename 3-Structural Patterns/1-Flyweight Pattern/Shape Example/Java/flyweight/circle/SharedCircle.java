package flyweight.circle;

import flyweight.Color;

/**
 * Concrete SharedCircle class that works as "ConcreteFlyweight".
 * This class pre-defines all the intrinsic states (which are constant and
 * context-independent).
 * This class is implemented as a singleton class.
 *
 * @author Ziang Lu
 */
public class SharedCircle implements FlyweightCircle {

    /**
     * Singleton instance.
     */
    private volatile static SharedCircle instance = null;

    /**
     * Gets the singleton instance.
     * This implementation utilizes Lazy Initialization Pattern and double-check
     * locking mechanism.
     * @return singleton instance
     */
    public static SharedCircle getInstance() {
        if (instance == null) {
            synchronized (SharedCircle.class) {
                if (instance == null) {
                    instance = new SharedCircle();
                }
            }
        }
        return instance;
    }

    /**
     * x-coordinate of the center of this SharedCircle.
     */
    private final double x = 0.0; // Intrinsic
    /**
     * y-coordinate of the center of this SharedCircle.
     */
    private final double y = 0.0; // Intrinsic

    /**
     * Private default constructor.
     * This has to be private so that the class instances cannot be created
     * outside of the class.
     */
    private SharedCircle() {
        System.out.println("Creating a Shared Circle without color: " + this);
    }

    /**
     * Accessor of x.
     * @return x
     */
    double x() {
        return x;
    }

    /**
     * Accessor of y.
     * @return y
     */
    double y() {
        return y;
    }

    @Override
    public void setRadius(double radius) {
        // Do nothing
    }

    @Override
    public void draw(Color color) {
        // Do nothing
    }

    @Override
    public String toString() {
        return "SharedCircle{x=" + x + ", y=" + y + "}";
    }

}
