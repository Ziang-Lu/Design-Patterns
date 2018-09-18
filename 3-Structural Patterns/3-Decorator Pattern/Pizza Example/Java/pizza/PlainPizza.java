package pizza;

/**
 * PlainPizza class that works as one kind of "ConcreteComponent".
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
        return 8.0;
    }

}
