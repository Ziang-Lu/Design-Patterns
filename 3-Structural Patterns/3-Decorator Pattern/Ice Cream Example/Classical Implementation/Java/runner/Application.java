package runner;

import ice_cream.IceCream;
import ice_cream.IceCreamWithNuts;
import ice_cream.IceCreamWithSprinkles;
import ice_cream.VanillaIceCream;

/**
 * Application that actually uses Decorator Pattern.
 *
 * @author Ziang Lu
 */
public class Application {

    /**
     * Main application.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        IceCream myIceCream = new IceCreamWithNuts(new IceCreamWithSprinkles(new VanillaIceCream())).makeIceCream();
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
