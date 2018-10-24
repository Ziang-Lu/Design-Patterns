package flyweight.rect;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Concrete ColoredRectangle class.
 * This class first works as "ConcreteFlyweight" and pre-defines all the
 * intrinsic states (which are constant and context-independent).
 * After customized with the given extrinsic states (which are NOT constant.
 * context-dependent and needs to be calculated on the fly), this class would
 * work as "UnsharedConcreteFlyweight".
 *
 * @author Ziang Lu
 */
public class ColoredRectangle implements FlyweightRectangle {

    /**
     * Color of this shared ColoredRectangle.
     */
    private final Color color; // Intrinsic

    /**
     * x-coordinate of the top-left of the unshared rectangle.
     */
    private int topLeftX; // Extrinsic
    /**
     * y-coordinate of the top-left of the unshared rectangle.
     */
    private int topLeftY; // Extrinsic
    /**
     * Width of the bottom-left of the unshared rectangle.
     */
    private int width; // Extrinsic
    /**
     * Height of the bottom-left of the unshared rectangle.
     */
    private int height; // Extrinsic

    /**
     * Constructor with parameter.
     * @param color color of the shared ColoredRectangle
     */
    public ColoredRectangle(Color color) {
        this.color = color;
    }

    @Override
    public void setTopLeftX(int topLeftX) {
        this.topLeftX = topLeftX;
    }

    @Override
    public void setTopLeftY(int topLeftY) {
        this.topLeftY = topLeftY;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(topLeftX, topLeftY, width, height);
    }
}
