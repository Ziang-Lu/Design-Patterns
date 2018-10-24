package flyweight.circle;

import flyweight.Shape;

/**
 * Abstract FlyweightCircle interface that works as "Flyweight".
 * This interface enables sharing but does not enforce it; it defines
 * "operation(extrinsicState)" to customize a "ConcreteFlyweight" to a
 * "UnsharedConcreteFlyweight".
 *
 * @author Ziang Lu
 */
public interface FlyweightCircle extends Shape {

    /**
     * Sets the x-coordinate of the circle.
     * @param x x-coordinate to set
     */
    void setX(int x);

    /**
     * Sets the y-coordinate of the circle.
     * @param y y-coordinate to set
     */
    void setY(int y);

    /**
     * Sets the radius of the circle.
     * @param radius radius to set
     */
    void setRadius(int radius);

}
