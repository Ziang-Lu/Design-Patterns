package ice_cream_factory;

import ice_cream.IceCream;

/**
 * IceCreamWithNutsFactory class that works as one kind of "ConcreteDecorator".
 * This class adds (decorates) nuts to an IceCream object created from an
 * IceCreamFactory ("Component") object.
 *
 * Note that this class shouldn't be implemented as a singleton class since
 * we may create multiple instances of this class to decorate different
 * IceCreamFactory objects
 *
 * @author Ziang Lu
 */
public class IceCreamWithNutsFactory extends IceCreamFactoryDecorator {

    /**
     * Constructor with parameter.
     * @param iceCreamFactory ice cream factory to decorate
     */
    public IceCreamWithNutsFactory(IceCreamFactory iceCreamFactory) {
        super(iceCreamFactory);
    }

    @Override
    public IceCream makeIceCream() {
        IceCream original = iceCreamFactoryToDecorate.makeIceCream();
        System.out.println("Adding Nuts");
        original.addTopping("Nuts");
        return original;
    }

}
