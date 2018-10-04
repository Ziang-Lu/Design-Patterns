package color_implementor;

import shape_abstraction.Shape;

/**
 * Concrete RedImplementor class that works as "ConcreteImplementor" to fill a
 * shape with red color.
 *
 * @author Ziang Lu
 */
public class BlueImplementor implements ColorImplementor {

    @Override
    public void fillColor(Shape shape) {
        System.out.println(shape.getClass().getSimpleName() + " is filled with blue color using BlueImplementor.");
    }

}
