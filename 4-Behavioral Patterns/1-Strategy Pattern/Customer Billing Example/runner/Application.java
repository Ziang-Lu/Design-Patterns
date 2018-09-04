package runner;

import strategy.BillingStrategy;
import strategy.HappyHourBillingStrategy;
import strategy.NormalBillingStrategy;

/**
 * Application that actually uses Strategy Pattern to provide multiple
 * algorithms, a family of algorithms, to perform a specific task (solve a
 * specific problem), so that the client can select which actual implementation
 * to use at runtime.
 *
 * @author Ziang Lu
 */
public class Application {

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        // Prepare billing strategies
        BillingStrategy normalStrategy = new NormalBillingStrategy();
        BillingStrategy happyHourStrategy = new HappyHourBillingStrategy();

        // Normal time slot
        Customer firstCustomer = new Customer(normalStrategy);
        firstCustomer.addDrinks(1.0, 1);

        // Happy Hour starts! [Switch billing strategy]
        firstCustomer.setBillingStrategy(happyHourStrategy);
        firstCustomer.addDrinks(1.0, 2);

        Customer secondCustomer = new Customer(happyHourStrategy);
        secondCustomer.addDrinks(0.8, 1);

        // First customer checks out
        firstCustomer.printBill();

        // Happy Hour ends [Switch billing strategy]
        secondCustomer.setBillingStrategy(normalStrategy);
        secondCustomer.addDrinks(1.3, 2);
        secondCustomer.addDrinks(2.5, 1);

        // Second customer checks out
        secondCustomer.printBill();

        /*
         * Output:
         * Total due: 2.0
         * Total due: 5.5
         */
    }

}
