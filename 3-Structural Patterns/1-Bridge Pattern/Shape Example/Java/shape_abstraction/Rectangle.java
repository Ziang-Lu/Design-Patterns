package shape_abstraction;

/**
 * Concrete Rectangle class that works as "ConcreteAbstraction".
 *
 * @author Ziang Lu
 */
public class Rectangle extends Shape {

    /**
     * x-coordinate of the center.
     */
    private double centerX;
    /**
     * y-coordinate of the center
     */
    private double centerY;
    /**
     * Width of this rectangle.
     */
    private double width;
    /**
     * Height of this rectangle.
     */
    private double height;

    /**
     * Constructor with parameter.
     * @param centerX x-coordinate of the center
     * @param centerY y-coordinate of the center
     * @param width width of the rectangle
     * @param height height of the rectangle
     */
    public Rectangle(double centerX, double centerY, double width, double height) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Rectangle{centerX=" + centerX + ", centerY=" + centerY + ", width=" + width + ", height=" + height +
                "}";
    }
}
