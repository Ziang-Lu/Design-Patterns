package shape_abstraction;

/**
 * Concrete Circle class that works as "ConcreteAbstraction".
 *
 * @author Ziang Lu
 */
public class Circle extends Shape {

    /**
     * x-coordinate of the circle.
     */
    private double x;
    /**
     * y-coordinate of the circle.
     */
    private double y;
    /**
     * Radius of the circle.
     */
    private double radius;

    /**
     * Constructor with parameter.
     * @param x x-coordinate of the circle
     * @param y y-coordinate of the circle
     * @param radius radius of the circle
     */
    public Circle(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{x=" + x + ", y=" + y + ", radius=" + radius + "}";
    }

}
