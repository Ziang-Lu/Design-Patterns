package ice_cream;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract IceCream class that works as "Component".
 *
 * @author Ziang Lu
 */
public abstract class IceCream {

    /**
     * Toppings of this ice cream.
     */
    private List<String> toppings = new ArrayList<>();

    /**
     * Makes an ice cream.
     * @return ice cream made
     */
    public abstract IceCream makeIceCream();

    /**
     * Adds the given topping to this ice cream.
     * @param topping given topping
     */
    void addTopping(String topping) {
        toppings.add(topping);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " with toppings " + toppings;
    }

}
