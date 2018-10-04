package ice_cream;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract product IceCream class.
 *
 * @author Ziang Lu
 */
public abstract class IceCream {

    /**
     * Toppings of this ice cream.
     */
    private List<String> toppings = new ArrayList<>();

    /**
     * Adds the given topping to this ice cream.
     * @param topping given topping
     */
    public void addTopping(String topping) {
        toppings.add(topping);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " with toppings " + toppings;
    }

}
