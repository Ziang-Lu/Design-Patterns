package restaurant;

import java.util.Set;

/**
 * Cook class that works as the "Receiver" for "Order" command.
 *
 * @author Ziang Lu
 */
public class Cook {

    /**
     * Cooks the given items.
     * @param items items to cook
     */
    void cook(Set<String> items) {
        for (String item : items) {
            System.out.println("Cook [Receiver] is cooking " + item + ".");
        }
    }

}
