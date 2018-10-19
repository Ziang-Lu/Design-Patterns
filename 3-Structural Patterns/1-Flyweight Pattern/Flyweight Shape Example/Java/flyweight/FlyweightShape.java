package flyweight;

/**
 * Abstract FlyweightShape interface that works as "Flyweight".
 * This interface enables sharing but does not enforce it; it defines
 * "operation(extrinsicState)" to assign extrinsic states to or customize
 * "ConcreteFlyweight", to let it change to "UnsharedConcreteFlyweight".
 *
 * @author Ziang Lu
 */
interface FlyweightShape {

    /**
     * Draws this flyweight shape with the given color.
     * @param color color to fill
     */
    void draw(Color color);

}
