package ice_cream_factory;

import ice_cream.IceCream;

/**
 * Note that in this ice cream example, the different behaviors are in the
 * object creation process, and within the different behaviors (methods), we are
 * returning the newly created instances: thus, this example is somehow related
 * to creational design patterns.
 * Thus, we incorporate Factory Method Pattern, and some concepts of Abstract
 * Factory Pattern and Builder Pattern, and implement this example with
 * factories.
 *
 * Abstract factory IceCreamFactory class that works as "Component".
 *
 * @author Ziang Lu
 */
public interface IceCreamFactory {

    /**
     * Abstract factory method to make an abstract product IceCream instance.
     * However, the ability to determine which concrete type of IceCream product
     * to instantiate is deferred to concrete factories (subclasses).
     * @return instantiated IceCream
     */
    IceCream makeIceCream();

}
