package color_implementor;

import shape_abstraction.Shape;

/**
 * Abstract filling-color implementor interface that works as "Implementor" to
 * define the methods that the concrete implementation classes must implement.
 * This interface acts as a bridge between the abstraction layer and the
 * concrete implementation classes.
 *
 * @author Ziang Lu
 */
public interface ColorImplementor {

    /**
     * Fills the given shape with some color.
     * @param shape shape to fill color
     */
    void fillColor(Shape shape);

}
