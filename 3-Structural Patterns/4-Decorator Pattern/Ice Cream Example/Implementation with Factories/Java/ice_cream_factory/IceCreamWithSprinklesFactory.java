package ice_cream_factory;

import ice_cream.IceCream;

/**
 * IceCreamWithSprinklesFactory class that works as one kind of
 * "ConcreteDecorator".
 * This class adds (decorates) sprinkles to an IceCream object created from an
 * IceCreamFactory ("Component") object.
 *
 * Note that this class shouldn't be implemented as a singleton class since
 * we may create multiple instances of this class to decorate different
 * IceCreamFactory objects
 *
 * @author Ziang Lu
 */
public class IceCreamWithSprinklesFactory extends IceCreamFactoryDecorator {

    /**
     * Constructor with parameter.
     * @param iceCreamFactory ice cream factory to decorate
     */
    public IceCreamWithSprinklesFactory(IceCreamFactory iceCreamFactory) {
        super(iceCreamFactory);
    }

    @Override
    public IceCream makeIceCream() {
        IceCream original = iceCreamFactoryToDecorate.makeIceCream();
        System.out.println("Adding Sprinkles");
        original.addTopping("Sprinkles");
        return original;
    }

}
