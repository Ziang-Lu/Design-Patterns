package pizza;

/**
 * PlainPizza class that works as one kind of "ConcreteComponent".
 * Every pizza we are going to make will start from a PlainPizza.
 *
 * @author Ziang Lu
 */
public class PlainPizza implements Pizza {

    /**
     * Default constructor.
     */
    public PlainPizza() {
        System.out.println("Adding Thin Dough");
    }

    @Override
    public String getDescription() {
        return "Thin Dough";
    }

    @Override
    public double getPrice() {
        System.out.println("Cost of Plain Pizza: $8.0");
        return 8.0;
    }

}
