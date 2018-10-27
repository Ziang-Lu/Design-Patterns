package car;

import visitor.CarPartVisitor;

/**
 * Abstract CarPart class that works as "Element/Visitable".
 * This class represents an element in the object structure, and can be visited
 * by a "Visitor", so that the "Visitor" can perform algorithm (handle
 * operation) on this "Element".
 *
 * @author Ziang Lu
 */
public abstract class CarPart {

    /**
     * Color of this car part.
     */
    protected Color color;

    /**
     * Constructor with parameter.
     * @param color color of the car part
     */
    protected CarPart(Color color) {
        this.color = color;
    }

    /**
     * Mutator of color.
     * @param color color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Upgrades this car part.
     */
    public abstract void upgrade();

    /**
     * Accepts the given visitor and lets it perform algorithm (handle
     * operation) on this "Element".
     * In this way, we can change the executing algorithm (operation) on this
     * "Element" by simply varying the visitor object.
     * @param visitor given visitor
     */
    public abstract void accept(CarPartVisitor visitor);

}
