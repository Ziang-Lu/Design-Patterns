package flyweight.circle;

import flyweight.Color;

/**
 * Concrete UnsharedCircle class that works as "UnsharedConcreteFlyweight".
 * This class contains a reference to the shared "ConcreteFlyweight", which
 * contains all the intrinsic states. And after customized with the given
 * extrinsic states (which are NOT constant, context-dependent and needs to be
 * calculated on the fly), this class works as "UnsharedConcreteFlyweight".
 *
 * @author Ziang Lu
 */
public class UnsharedCircle implements FlyweightCircle {

    /**
     * Reference to the shared flyweight circle.
     */
    private final SharedCircle flyweightCircle;

    /**
     * Radius of this UnsharedCircle.
     */
    private double radius; // Extrinsic
    /**
     * Color of this UnsharedCircle.
     */
    private Color color; // Extrinsic

    /**
     * Constructor with parameter.
     * @param flyweightCircle reference to the shared flyweight circle
     */
    public UnsharedCircle(SharedCircle flyweightCircle) {
        this.flyweightCircle = flyweightCircle;
        radius = 5.0;
        color = null;
    }

    @Override
    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw(Color color) {
        this.color = color;
        System.out.println("Circle has been drawn with " + color + ": " + this);
    }

    @Override
    public String toString() {
        return "UnsharedCircle{x=" + flyweightCircle.x() + ", y=" + flyweightCircle.y() + ", radius=" + radius +
                ", color=" + color + "}";
    }

}
