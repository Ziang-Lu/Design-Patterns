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
    private volatile static VanillaIceCreamFactory instance = null;

    /**
     * Gets the singleton instance.
     * This implementation utilizes Lazy Initialization Pattern and double-check
     * locking mechanism.
     * @return singleton instance
     */
    public static VanillaIceCreamFactory getInstance() {
        if (instance == null) {
            synchronized (VanillaIceCreamFactory.class) {
                if (instance == null) {
                    instance = new VanillaIceCreamFactory();
                }
            }
        }
        return instance;
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
