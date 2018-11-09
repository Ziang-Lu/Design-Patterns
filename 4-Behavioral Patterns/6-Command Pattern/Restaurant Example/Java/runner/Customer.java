package runner;

import restaurant.CleanCommand;
import restaurant.Cleaner;
import restaurant.Cook;
import restaurant.Waiter;

/**
 * Application that actually uses Command Pattern.
 *
 * @author Ziang Lu
 */
public class Customer {

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        Cook restaurantCook = new Cook(); // Receiver
        Cleaner restaurantCleaner = new Cleaner(); // Receiver
        Waiter restaurantWaiter = new Waiter(restaurantCook); // Invoker

        // Request the waiter [Invoker] to place an order [Command]
        restaurantWaiter.placeOrder("Kung Pao Chicken", "Sesame Chicken");

        System.out.println();

        // Create a clean command [Command] by passing the cleaner [Receiver]
        CleanCommand cleanCommand = new CleanCommand(restaurantCleaner);
        // Let the waiter [Invoker] to execute the clean command [Command]
        restaurantWaiter.clean(cleanCommand);

        /*
         * Output:
         * Waiter [Invoker] has received an order with items: [Kung Pao Chicken, Sesame Chicken].
         * A new order [Command] has been created.
         * Kung Pao Chicken has been added to the order.
         * Sesame Chicken has been added to the order.
         * Waiter [Invoker] starts executing the command...
         * Cook [Receiver] is cooking Sesame Chicken.
         * Cook [Receiver] is cooking Kung Pao Chicken.
         *
         * A new clean command [Command] has been created.
         * Waiter [Invoker] has received the clean command [Command] starts executing the command...
         * Cleaner [Receiver] is cleaning up the table.
         */
    }

}
