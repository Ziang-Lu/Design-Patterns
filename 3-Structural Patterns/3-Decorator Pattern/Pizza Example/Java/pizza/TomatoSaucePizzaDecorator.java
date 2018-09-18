package pizza;

/**
 * TomatoSaucePizzaDecorator class that works as one kind of
 * "ConcreteDecorator".
 * This class adds (decorates) tomato sauce to a Pizza ("Component") object.
 *
 * @author Ziang Lu
 */
public class TomatoSaucePizzaDecorator extends PizzaDecorator {

    /**
     * Constructor with parameter.
     * @param pizza pizza to decorate
     */
    public TomatoSaucePizzaDecorator(Pizza pizza) {
        super(pizza);
        System.out.println("Adding tomato sauce");
    }

    @Override
    public String getDescription() {
        return pizzaToDecorate.getDescription() + ", Tomato Sauce";
    }

    @Override
    public double getPrice() {
        return pizzaToDecorate.getPrice() + 0.5;
    }

}
