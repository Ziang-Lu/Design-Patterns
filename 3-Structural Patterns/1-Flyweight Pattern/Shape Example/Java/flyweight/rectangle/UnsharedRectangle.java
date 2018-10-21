package flyweight.rectangle;

import flyweight.Color;

/**
 * Concrete UnsharedRectangle class that works as "UnsharedConcreteFlyweight".
 * This class contains a reference to the shared "ConcreteFlyweight", which
 * contains all the intrinsic states. And after customized with the given
 * extrinsic states (which are NOT constant, context-dependent and needs to be
 * calculated on the fly), this class works as "UnsharedConcreteFlyweight".
 *
 * @author Ziang Lu
 */
public class UnsharedRectangle implements FlyweightRectangle {

    /**
     * Reference to the shared flyweight rectangle.
     */
    private SharedRectangle flyweightRect;

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
    private Color color; // Extrinsinc

    /**
     * Constructor with parameter.
     * @param flyweightRect reference to the shared flyweight rectangle
     */
    public UnsharedRectangle(SharedRectangle flyweightRect) {
        this.flyweightRect = flyweightRect;
        width = 4.0;
        height = 3.0;
        color = null;
    }

    @Override
    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public void draw(Color color) {
        this.color = color;
        System.out.println("Rectangle has been draw with " + color + ": " + this);
    }

    @Override
    public String toString() {
        return "UnsharedRectangle{leftBottomX=" + flyweightRect.leftBottomX() + ", leftBottomY=" +
                flyweightRect.leftBottomY() + ", width=" + width + ", height=" + height + ", color=" + color + "}";
    }

}
