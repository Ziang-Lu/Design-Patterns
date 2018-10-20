package flyweight;

/**
 * Concrete SharedCircle class.
 * This class first works as "ConcreteFlyweight", pre-defines all the intrinsic
 * states (which are constant and context-independent).
 * After assignment of extrinsic states (which are NOT constant,
 * context-dependent and needs to be calculated on the fly) or customization,
 * this class would work as "UnsharedConcreteFlyweight".
 *
 * @author Ziang Lu
 */
public class SharedCircle implements FlyweightShape {

    /**
     * x-coordinate of the center of this SharedCircle.
     */
    private final double x = 0.0; // Intrinsic
    /**
     * y-coordinate of the center of this SharedCircle.
     */
    private final double y = 0.0; // Intrinsic

    /**
     * Radius of this UnsharedCircle.
     */
    private double radius; // Extrinsic
    /**
     * Color of this UnsharedCircle.
     */
    private Color color; // Extrinsic

    /**
     * Default constructor.
     */
    SharedCircle() {
        radius = 5.0;
        color = null;
        System.out.println("Creating a Shared Circle without color: " + this);
    }

    /**
     * Mutator of radius.
     * @param radius radius to set
     */
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
        StringBuilder s = new StringBuilder();
        s.append("Circle@").append(Integer.toHexString(hashCode()));
        s.append(" {x=").append(x);
        s.append(", y=").append(y);
        s.append(", radius=").append(radius);
        s.append(", color=").append(color).append("}");
        return s.toString();
    }

}
