package ice_cream;

/**
 * Abstract IceCreamDecorator class that works as "Decorator".
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
 * @author Ziang Lu
 */
abstract class IceCreamDecorator extends IceCream {

    /**
     * Ice cream to decorate.
     */
    protected IceCream iceCreamToDecorate;

    /**
     * Protected constructor with parameter.
     * @param iceCream ice cream to decorate
     */
    protected IceCreamDecorator(IceCream iceCream) {
        iceCreamToDecorate = iceCream;
    }

}
