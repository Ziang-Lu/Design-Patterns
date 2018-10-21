package flyweight.rectangle;

import flyweight.Color;

/**
 * Concrete SharedRectangle class that works as "ConcreteFlyweight".
 * This class pre-defines all the intrinsic states (which are constant and
 * context-independent).
 *
 * @author Ziang Lu
 */
public class SharedRectangle implements FlyweightRectangle {

    /**
     * Singleton instance.
     */
    private volatile static SharedRectangle instance = null;

    /**
     * Gets the singleton instance.
     * This implementation utilizes Lazy Initialization Pattern and double-check
     * locking mechanism.
     * @return singleton instance
     */
    public static SharedRectangle getInstance() {
        if (instance == null) {
            synchronized (SharedRectangle.class) {
                if (instance == null) {
                    instance = new SharedRectangle();
                }
            }
        }
        return instance;
    }

    /**
     * x-coordinate of the left bottom of this SharedRectangle.
     */
    private final double leftBottomX = 0.0; // Intrinsic
    /**
     * y-coordinate of the left bottom of this SharedRectangle.
     */
    private final double leftBottomY = 0.0; // Intrinsic

    /**
     * Private default constructor.
     * This has to be private so that the class instances cannot be created
     * outside of the class.
     */
    private SharedRectangle() {
        System.out.println("Creating a Shared Rectangle without color: " + this);
    }

    /**
     * Accessor of leftBottomX.
     * @return leftBottomX
     */
    double leftBottomX() {
        return leftBottomX;
    }

    /**
     * Accessor of leftBottomY.
     * @return leftBottomY
     */
    double leftBottomY() {
        return leftBottomY;
    }

    @Override
    public void setWidth(double width) {
        // Do nothing
    }

    @Override
    public void setHeight(double height) {
        // Do nothing
    }

    @Override
    public void draw(Color color) {
        // Do nothing
    }

    @Override
    public String toString() {
        return "SharedRectangle{leftBottomX=" + leftBottomX + ", leftBottomY=" + leftBottomY + "}";
    }

}
