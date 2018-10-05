package runner;

import billing_implementor.BillingImplementor;
import billing_implementor.HappyHourBillingImplementor;
import billing_implementor.NormalBillingImplementor;
import customer.Customer;
import customer.NormalCustomer;
import customer.TeenagerCustomer;

/**
 * Application that uses Bridge Pattern.
 *
 * @author Ziang Lu
 */
public class Application {

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        // Prepare the billing implementors
        BillingImplementor normalImplementor = NormalBillingImplementor.getInstance();
        BillingImplementor happyHourImplementor = HappyHourBillingImplementor.getInstance();

        // Normal time slot
        Customer firstCustomer = new NormalCustomer(normalImplementor);
        firstCustomer.addDrinks(1.0, 1);

        // Happy Hour starts! [Switch billing implementor]
        firstCustomer.setBillingImplementor(happyHourImplementor);
        firstCustomer.addDrinks(1.0, 2);

        Customer secondCustomer = new TeenagerCustomer(happyHourImplementor);
        secondCustomer.addDrinks(0.8, 1);

        // First customer checks out
        firstCustomer.printBill();

        // Happy Hour ends [Switch billing implementor]
        secondCustomer.setBillingImplementor(normalImplementor);
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
