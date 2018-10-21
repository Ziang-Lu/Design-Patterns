package flyweight.circle;

import flyweight.FlyweightShape;

/**
 * Abstract FlyweightCircle interface that works as "Flyweight".
 * This interface enables sharing but does not enforce it; it defines
 * "operation(extrinsicState)" to assign extrinsic states to or customize
 * "ConcreteFlyweight", to let it change to "UnsharedConcreteFlyweight".
 *
 * @author Ziang Lu
 */
public interface FlyweightCircle extends FlyweightShape {

    /**
     * Sets the radius of this circle.
     * @param radius radius to set
     */
    void setRadius(double radius);

}
