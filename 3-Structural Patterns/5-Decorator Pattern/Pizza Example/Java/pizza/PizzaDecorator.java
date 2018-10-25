package pizza;

/**
 * Abstract PizzaDecorator class that works as "Decorator".
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
abstract class PizzaDecorator implements Pizza {

    /**
     * Pizza to decorate.
     * Dynamically customize and add functionality to this Pizza instance, which
     * could either be a PlainPizza or some other PizzaDecorator.
     */
    protected Pizza pizzaToDecorate;

    /**
     * Protected constructor with parameter.
     * @param pizza pizza to decorate
     */
    protected PizzaDecorator(Pizza pizza) {
        pizzaToDecorate = pizza;
    }

}
