package runner;

import restaurant.CleanCommand;
import restaurant.Cleaner;
import restaurant.Cook;
import restaurant.Order;
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
        Waiter restaurantWaiter = new Waiter(); // Invoker

        // Create a order [Command] by passing in the cook [Receiver]
        Order order = new Order(restaurantCook);
        order.addItem("Kung Pao Chicken");
        order.addItem("Sesame Chicken");
        System.out.println();
        // Let the waiter [Invoker] execute this command
        restaurantWaiter.executeCommand(order);

        System.out.println();

        // Create a clean command [Command] by passing in the cleaner [Receiver]
        CleanCommand cleanCommand = new CleanCommand(restaurantCleaner);
        System.out.println();
        // Let the waiter [Invoker] execute this command
        restaurantWaiter.executeCommand(cleanCommand);

        /*
         * Output:
         * A new order [Command] has been created.
         * Kung Pao Chicken has been added to the order.
         * Sesame Chicken has been added to the order.
         *
         * Waiter [Invoker] has received the command [Command] and start executing the command [Command] ...
         * Cook [Receiver] is cooking Sesame Chicken.
         * Cook [Receiver] is cooking Kung Pao Chicken.
         *
         * A new clean command [Command] has been created.
         *
         * Waiter [Invoker] has received the command [Command] and start executing the command [Command] ...
         * Cleaner [Receiver] is cleaning up the table.
         */
    }

}
