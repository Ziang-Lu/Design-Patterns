package pizza;

/**
 * MozzarellaPizzaDecorator class that works as one kind of "ConcreteDecorator".
 * This class adds (decorates) mozzarella cheese to a Pizza ("Component")
 * object.
 *
 * @author Ziang Lu
 */
public class MozzarellaPizzaDecorator extends PizzaDecorator {

    /**
     * Constructor with parameter.
     * @param pizza pizza to decorate
     */
    public MozzarellaPizzaDecorator(Pizza pizza) {
        super(pizza);
        System.out.println("Adding mozzarella cheese");
    }

    @Override
    public String getDescription() {
        return pizzaToDecorate.getDescription() + ", Mozzarella Cheese";
    }

    @Override
    public double getPrice() {
        return pizzaToDecorate.getPrice() + 1.0;
    }

}
