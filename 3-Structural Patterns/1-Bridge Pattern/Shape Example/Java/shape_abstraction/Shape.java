package shape_abstraction;

import color_implementor.ColorImplementor;

/**
 * Abstract Shape class that works as "Abstraction".
 * This class defines a fillColor() method for the client to call, and holds a
 * reference to a fill-color implementor, so that the client will use that
 * implementor to fill the color of this shape.
 *
 * @author Ziang Lu
 */
public abstract class Shape {

    /**
     * Fill-color implementor.
     */
    private ColorImplementor colorImplementor;

    /**
     * Draws this shape.
     */
    public void draw() {
        System.out.println(getClass().getSimpleName() + " has been drawn without any color.");
    }

    /**
     * Mutator of colorImplementor.
     * @param colorImplementor filling-color implementor to set
     */
    public void setColorImplementor(ColorImplementor colorImplementor) {
        this.colorImplementor = colorImplementor;
    }

    /**
     * Fills the color of this shape using a filling-color implementor.
     */
    public void fillColor() {
        colorImplementor.fillColor(this);
    }

}
