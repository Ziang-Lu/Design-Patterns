package runner;

import pizza.PizzaWithMozzarella;
import pizza.Pizza;
import pizza.PlainPizza;
import pizza.PizzaWithTomatoSauce;

/**
 * Application that actually uses Decorator Pattern.
 *
 * @author Ziang Lu
 */
public class DecoratorPatternTest {

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        Pizza myPizza = new PizzaWithTomatoSauce(new PizzaWithMozzarella(new PlainPizza()));
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
         * Cost of Plain Pizza: $8.0
         * Cost of Mozzarella Cheese: $1.0
         * Cost of Tomato Sauce: $0.5
         * Price of my pizza: $9.5
         */
    }

}
