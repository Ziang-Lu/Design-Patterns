package runner;

import ice_cream.IceCream;
import ice_cream_factory.IceCreamWithNutsFactory;
import ice_cream_factory.IceCreamWithSprinklesFactory;
import ice_cream_factory.VanillaIceCreamFactory;

/**
 * Application that actually uses Decorator Pattern.
 *
 * @author Ziang Lu
 */
public class DecoratorPatternTest {

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        IceCream myIceCream = new IceCreamWithNutsFactory(
                new IceCreamWithSprinklesFactory(VanillaIceCreamFactory.getInstance())).makeIceCream();
        System.out.println(myIceCream);

        /*
         * Output:
         * Creating a Vanilla Ice Cream
         * Adding Sprinkles
         * Adding Nuts
         * VanillaIceCream with toppings [Sprinkles, Nuts]
         */
    }

}
