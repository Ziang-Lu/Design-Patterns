package flyweight.rect;

import flyweight.Shape;

/**
 * Abstract FlyweightRectangle interface that works as "Flyweight".
 * This interface enables sharing but does not enforce it; it defines
 * "operation(extrinsicState)" to customize a "ConcreteFlyweight" to a
 * "UnsharedConcreteFlyweight".
 *
 * @author Ziang Lu
 */
public interface FlyweightRectangle extends Shape {

    /**
     * Sets the x-coordinate of the top-left of the rectangle.
     * @param bottomLeftX bottom left x-coordinate to set
     */
    void setTopLeftX(int bottomLeftX);

    /**
     * Sets the y-coordinate of the top-left of the rectangle.
     * @param bottomLeftY bottom left y-coordinate to set
     */
    void setTopLeftY(int bottomLeftY);

    /**
     * Sets the width of the rectangle.
     * @param width width to set
     */
    void setWidth(int width);

    /**
     * Sets the height of the rectangle.
     * @param height height to set
     */
    void setHeight(int height);

}
