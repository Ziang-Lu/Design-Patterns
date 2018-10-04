package ice_cream_factory;

import ice_cream.IceCream;
import ice_cream.VanillaIceCream;

/**
 * Concrete factory VanillaIceCreamFactory that works as one kind of
 * "ConcreteComponent".
 * This class is implemented as a singleton class.
 *
 * @author Ziang Lu
 */
public class VanillaIceCreamFactory implements IceCreamFactory {

    /**
     * Singleton instance.
     */
    private volatile static VanillaIceCreamFactory singleton = null;

    /**
     * Gets the singleton instance.
     * This implementation utilizes Lazy Initialization Pattern and double-check
     * locking mechanism.
     * @return singleton instance
     */
    public static VanillaIceCreamFactory getInstance() {
        if (singleton == null) {
            synchronized (VanillaIceCreamFactory.class) {
                if (singleton == null) {
                    singleton = new VanillaIceCreamFactory();
                }
            }
        }
        return singleton;
    }

    /**
     * Private default constructor.
     * This has to be private so that the class instances cannot be created
     * outside of the class.
     */
    private VanillaIceCreamFactory() {}

    @Override
    public IceCream makeIceCream() {
        System.out.println("Creating a Vanilla Ice Cream");
        return new VanillaIceCream();
    }

}
