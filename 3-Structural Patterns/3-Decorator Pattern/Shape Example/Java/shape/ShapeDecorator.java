package shape;

/**
 * Abstract ShapeDecorator class that works as "Decorator".
 * This is essentially a wrapper that reproduces the functionality of an
 * existing class and adds new functionality to it, without impacting existing
 * structure and functionality of the objects.
 *
 * However, since decorators should be stackable, which means we should be able
 * to add decorators on decorators on decorators...... to further increase the
 * provided functionalities.
 * Thus, we let different "ConcreteComponent" classes and the abstract
 * "Decorator" both inherit from the common super class "Component", so that
 * "Decorator" will only have an abstract "Component" object to decorate, but
 * does not need to care it will actually decorate a "ConcreteComponent" or
 * another "Decorator."
 *
 * Note that since for "Decorator", we are forwarding the request from the
 * client to the "Component" it's decorating, we are actually in some sense
 * using Delegation Pattern here
 *
 * @author Ziang Lu
 */
abstract class ShapeDecorator implements Shape {

    /**
     * Shape to decorate.
     * Dynamically customize and add functionality to this Shape instance, which
     * could either be a concrete shape or some other ShapeDecorator.
     */
    protected Shape shapeToDecorate;

    /**
     * Protected constructor with parameter.
     * @param shape shape to decorate
     */
    protected ShapeDecorator(Shape shape) {
        shapeToDecorate = shape;
    }

    @Override
    public String toString() {
        return shapeToDecorate.toString();
    }

}
