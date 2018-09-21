package ice_cream;

/**
 * VanillaIceCream class that works as one kind of "ConcreteComponent".
 *
 * @author Ziang Lu
 */
public class VanillaIceCream extends IceCream {

    @Override
    public IceCream makeIceCream() {
        System.out.println("Creating a Vanilla Ice Cream");
        return this;
    }

}
