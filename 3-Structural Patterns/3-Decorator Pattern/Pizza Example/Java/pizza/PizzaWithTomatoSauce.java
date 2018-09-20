package pizza;

/**
 * PizzaWithTomatoSauce class that works as one kind of
 * "ConcreteDecorator".
 * This class adds (decorates) tomato sauce to a Pizza ("Component") object.
 *
 * @author Ziang Lu
 */
public class PizzaWithTomatoSauce extends PizzaDecorator {

    /**
     * Constructor with parameter.
     * @param pizza pizza to decorate
     */
    public PizzaWithTomatoSauce(Pizza pizza) {
        super(pizza);
        System.out.println("Adding tomato sauce");
    }

    @Override
    public String getDescription() {
        // Returns the decorated Pizza after adding tomato sauce to it
        return pizzaToDecorate.getDescription() + ", Tomato Sauce";
    }

    @Override
    public double getPrice() {
        System.out.println("Cost of Tomato Sauce: $0.5");
        // Returns the cost of the decorated pizza after adding tomato sauce to it
        return pizzaToDecorate.getPrice() + 0.5;
    }

}
