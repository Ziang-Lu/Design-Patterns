package restaurant;

import java.util.HashSet;
import java.util.Set;

/**
 * Concrete Order class that works as "ConcreteCommand".
 * This class contains a reference to a "Receiver", which is responsible for, in
 * the execute() method, perform some actions and thus handle the request.
 *
 * @author Ziang Lu
 */
class Order implements Command {

    /**
     * Reference to the "Receiver", which is responsible for, in the execute()
     * method, perform some actions and thus handle the request.
     */
    private final Cook cook;
    /**
     * Food items in this order.
     */
    private final Set<String> items;

    /**
     * Constructor with parameter.
     * @param cook cook to eventually handle this order
     */
    Order(Cook cook) {
        this.cook = cook;
        items = new HashSet<>();
        System.out.println("A new order [Command] has been created.");
    }

    /**
     * Adds the given item to this order.
     * @param item item to add
     */
    public void addItem(String item) {
        items.add(item);
        System.out.println(item + " has been added to the order.");
    }

    @Override
    public void execute() {
        // Let the cook [Receiver] handle this order [Command]
        cook.cook(items);
    }

}
