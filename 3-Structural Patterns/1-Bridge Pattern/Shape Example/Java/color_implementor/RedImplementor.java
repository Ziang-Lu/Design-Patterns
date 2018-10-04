package color_implementor;

import shape_abstraction.Shape;

/**
 *i
 *
 * @author Ziang Lu
 */
public class RedImplementor implements ColorImplementor {

    @Override
    public void fillColor(Shape shape) {
        System.out.println(shape.getClass().getSimpleName() + " is filled with red color using RedImplementor.");
    }

}
