package flyweight;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * Abstract FlyweightLetter interface that works as "Flyweight".
 * This interface enables sharing but does not enforce it; it defines
 * "operation(extrinsicState)" to customize a "ConcreteFlyweight" to a
 * "UnsharedConcreteFlyweight".
 *
 * @author Ziang Lu
 */
public interface FlyweightLetter {

    /**
     * Sets the horizontal position of this letter.
     * @param horizontalPos horizontal position to set
     */
    void setHorizontalPos(int horizontalPos);

    /**
     * Sets the vertical position of this letter.
     * @param verticalPos vertical position to set
     */
    void setVerticalPos(int verticalPos);

    /**
     * Sets the font of this letter.
     * @param font font to set
     */
    void setFont(Font font);

    /**
     * Sets the color of this letter.
     * @param color color to set
     */
    void setColor(Color color);

    /**
     * Draws this letter in the given graphics.
     * @param g graphics in which to draw
     */
    void draw(Graphics g);

}
