package flyweight;

import java.awt.*;

/**
 * Concrete Letter class.
 * This class first works as "ConcreteFlyweight" and pre-defines all the
 * intrinsic states (which are constant and context-independent).
 * After customized with the given extrinsic states (which are NOT constant.
 * context-dependent and needs to be calculated on the fly), this class would
 * work as "UnsharedConcreteFlyweight".
 *
 * @author Ziang Lu
 */
public class Letter implements FlyweightLetter {

    /**
     * Character of this shared letter.
     */
    private final char value; // Intrinsic

    /**
     * Horizontal position of the unshared letter.
     */
    private int horizontalPos; // Extrinsic
    /**
     * Vertical position of the unshared letter.
     */
    private int verticalPos; // Extrinsic
    /**
     * Font of the unshared letter.
     */
    private Font font; // Extrinsic
    /**
     * Color of the unshared color.
     */
    private Color color; // Extrinsic

    /**
     * Constructor with parameter.
     * @param value character of this letter
     */
    Letter(char value) {
        this.value = value;
    }

    @Override
    public void setHorizontalPos(int horizontalPos) {
        this.horizontalPos = horizontalPos;
    }

    @Override
    public void setVerticalPos(int verticalPos) {
        this.verticalPos = verticalPos;
    }

    @Override
    public void setFont(Font font) {
        this.font = font;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void draw(Graphics g) {
        g.setFont(font);
        g.setColor(color);
        g.drawString(Character.toString(value), horizontalPos, verticalPos);
    }

}
