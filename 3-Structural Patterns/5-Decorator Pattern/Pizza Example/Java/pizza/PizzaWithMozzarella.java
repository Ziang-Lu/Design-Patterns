package pizza;

/**
 * PizzaWithMozzarella class that works as one kind of "ConcreteDecorator".
 * This class adds (decorates) mozzarella cheese to a Pizza ("Component")
 * object.
 *
 * @author Ziang Lu
 */
public class PizzaWithMozzarella extends PizzaDecorator {

    /**
     * Constructor with parameter.
     * @param pizza pizza to decorate
     */
    public PizzaWithMozzarella(Pizza pizza) {
        super(pizza);
        System.out.println("Adding mozzarella cheese");
    }

    @Override
    public String getDescription() {
        // Returns the decorated Pizza after adding mozzarella cheese to it
        return pizzaToDecorate.getDescription() + ", Mozzarella Cheese";
    }

    @Override
    public double getPrice() {
        // Returns the cost of the decorated pizza after adding mozzarella cheese to it
        double total = pizzaToDecorate.getPrice() + 1.0;
        System.out.println("Cost of Tomato Sauce: $1.0");
        return total;
    }

}
