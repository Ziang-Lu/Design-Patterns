package pizza;

/**
 * Abstract Pizza interface that works as "Component".
 *
 * @author Ziang Lu
 */
public interface Pizza {

    /**
     * Returns the description of this pizza.
     * @return description of the pizza
     */
    String getDescription();

    /**
     * Returns the price of this pizza.
     * @return cost of the pizza
     */
    double getPrice();

}
