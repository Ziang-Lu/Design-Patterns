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
     * Constructor with parameter.
     * @param restaurantCook colleague cook
     */
    public Waiter(Cook restaurantCook) {
        this.restaurantCook = restaurantCook;
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
        System.out.println("Waiter [Invoker] starts executing the command...");
        order.execute();
    }

    /**
     * Receives a request to clean the table.
     * @param cleanCommand clean command to execute
     */
    public void clean(CleanCommand cleanCommand) {
        System.out.println("Waiter [Invoker] has received the clean command [Command] and starts executing the command...");
        cleanCommand.execute();
    }

}
