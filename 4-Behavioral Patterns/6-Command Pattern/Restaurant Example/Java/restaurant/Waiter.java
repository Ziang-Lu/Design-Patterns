package restaurant;

import java.util.Arrays;

/**
 * Waiter class that works as "Invoker".
 * This class is responsible for executing the different "Command"s.
 * The "Invoker" does not know how to handle the request, but simply invoke
 * command.execute() method, and let the internal correct "Receive" handle the
 * request.
 *
 * @author Ziang Lu
 */
public class Waiter {

    /**
     * Colleague cook in the restaurant.
     */
    private final Cook restaurantCook;
    /**
     * Colleague cleaner in the restaurant.
     */
    private final Cleaner restaurantCleaner;

    /**
     * Constructor with parameter.
     * @param restaurantCook colleague cook
     * @param restaurantCleaner colleague cleaner
     */
    public Waiter(Cook restaurantCook, Cleaner restaurantCleaner) {
        this.restaurantCook = restaurantCook;
        this.restaurantCleaner = restaurantCleaner;
    }

    /**
     * Places a new order with the given items.
     * @param items items of the order
     */
    public void placeOrder(String... items) {
        System.out.println("Waiter [Invoker] has received an order with items: " + Arrays.toString(items) + ".");
        // Create an order [Command] by passing in the cook [Receiver]
        Order order = new Order(restaurantCook);
        for (String item : items) {
            order.addItem(item);
        }
        System.out.println("Waiter [Invoker] started executing the command...");
        order.execute();
    }

    /**
     * Receives a request to clean the table.
     */
    public void clean() {
        System.out.println("Waiter [Invoker] has received the clean request.");
        // Create a clean command [Command] by passing in the cleaner [Receiver]
        CleanCommand cleanCommand = new CleanCommand(restaurantCleaner);
        System.out.println("Waiter [Invoker] started executing the clean command...");
        cleanCommand.execute();
    }

}
