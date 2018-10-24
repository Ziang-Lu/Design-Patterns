package flyweight;

import java.awt.Graphics;

/**
 * Shape interface.
 *
 * @author Ziang Lu
 */
public interface Shape {

    /**
     * Draws this shape in the given graphics.
     * @param g graphics in which to draw
     */
    void draw(Graphics g);

}
