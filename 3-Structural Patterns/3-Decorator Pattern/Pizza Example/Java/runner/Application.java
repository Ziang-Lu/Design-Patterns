package runner;

import pizza.MozzarellaPizzaDecorator;
import pizza.Pizza;
import pizza.PlainPizza;
import pizza.TomatoSaucePizzaDecorator;

/**
 * Application that actually uses Decorator Pattern.
 *
 * @author Ziang Lu
 */
public class Application {

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        Pizza myPizza = new TomatoSaucePizzaDecorator(new MozzarellaPizzaDecorator(new PlainPizza()));
        System.out.println();
        System.out.println("Ingredients of my pizza:");
        System.out.println(myPizza.getDescription());
        System.out.println("Price of my pizza: $" + myPizza.getPrice());

        /*
         * Output:
         * Adding Thin Dough
         * Adding mozzarella cheese
         * Adding tomato sauce
         *
         * Ingredients of my pizza:
         * Thin Dough, Mozzarella Cheese, Tomato Sauce
         * Price of my pizza: $9.5
         */
    }

}
