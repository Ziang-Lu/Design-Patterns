package flyweight.rectangle;

import flyweight.FlyweightShape;

/**
 * Abstract FlyweightRectangle interface that works as "Flyweight".
 * This interface enables sharing but does not enforce it; it defines
 * "operation(extrinsicState)" to assign extrinsic states to or customize
 * "ConcreteFlyweight", to let it change to "UnsharedConcreteFlyweight".
 *
 * @author Ziang Lu
 */
public interface FlyweightRectangle extends FlyweightShape {

    /**
     * Sets the width of this rectangle.
     * @param width width to set
     */
    void setWidth(double width);

    /**
     * Sets the height of this rectangle.
     * @param height height to set
     */
    void setHeight(double height);

}
