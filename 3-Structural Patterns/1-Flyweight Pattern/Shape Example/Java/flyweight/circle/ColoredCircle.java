package flyweight.circle;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Concrete ColoredCircle class.
 * This class first works as "ConcreteFlyweight" and pre-defines all the
 * intrinsic states (which are constant and context-independent).
 * After customized with the given extrinsic states (which are NOT constant.
 * context-dependent and needs to be calculated on the fly), this class would
 * work as "UnsharedConcreteFlyweight".
 *
 * @author Ziang Lu
 */
public class ColoredCircle implements FlyweightCircle {

    /**
     * Color of this shared ColoredCircle.
     */
    private final Color color; // Intrinsic

    /**
     * x-coordinate of the unshared circle.
     */
    private int x; // Extrinsic
    /**
     * y-coordinate of the unshared circle.
     */
    private int y; // Extrinsic
    /**
     * Radius of the unshared circle.
     */
    private int radius; // Extrinsic

    /**
     * Constructor with parameter.
     * @param color color of the shared ColoredCircle
     */
    public ColoredCircle(Color color) {
        this.color = color;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        int topLeftX = x - radius, topLeftY = y - radius;
        int width = 2 * radius, height = 2 * radius;
        g.fillOval(topLeftX, topLeftY, width, height);
    }

}
