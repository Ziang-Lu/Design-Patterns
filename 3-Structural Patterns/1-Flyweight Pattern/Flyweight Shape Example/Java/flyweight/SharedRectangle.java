package flyweight;

/**
 * Concrete SharedRectangle class.
 * This class first works as "ConcreteFlyweight", pre-defines all the intrinsic
 * states (which are constant and context-independent).
 * After assignment of extrinsic states (which are NOT constant,
 * context-dependent and needs to be calculated on the fly) or customization,
 * this class would work as "UnsharedConcreteFlyweight".
 *
 * @author Ziang Lu
 */
public class SharedRectangle implements FlyweightShape {

    /**
     * x-coordinate of the left bottom of this SharedRectangle.
     */
    private final double leftBottomX = 0.0; // Intrinsic
    /**
     * y-coordinate of the left bottom of this SharedRectangle.
     */
    private final double leftBottomY = 0.0; // Intrinsic

    /**
     * Width of this UnsharedRectangle.
     */
    private double width; // Extrinsic
    /**
     * Height of this UnsharedRectangle.
     */
    private double height; // Extrinsic
    /**
     * Color of this UnsharedRectangle.
     */
    private Color color; // Extrinsic

    /**
     * Default constructor.
     */
    SharedRectangle() {
        width = 4.0;
        height = 3.0;
        color = null;
        System.out.println("Creating a Shared Rectangle without color: " + this);
    }

    /**
     * Mutator of width.
     * @param width width to set
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * Mutator of height.
     * @param height height to set
     */
    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public void draw(Color color) {
        this.color = color;
        System.out.println("Rectangle has been drawn with " + color + ": " + this);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Rectangle@").append(Integer.toHexString(hashCode()));
        s.append(" {leftBottomX=").append(leftBottomX);
        s.append(", leftBottomY=").append(leftBottomY);
        s.append(", width=").append(width);
        s.append(", height=").append(height);
        s.append(", color=").append(color).append("}");
        return s.toString();
    }

}
