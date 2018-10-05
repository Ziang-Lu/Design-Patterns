package customer;

import billing_implementor.BillingImplementor;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract Shape class that works as "Abstraction".
 * This class defines an addDrinks() method for the client to call, and holds a
 * reference to a billing implementor, so that the client will use that
 * implementor to calculate the actual price for drinks.
 *
 * @author Ziang Lu
 */
public abstract class Customer {

    /**
     * Current billing implementor.
     */
    private BillingImplementor currBillingImplementor;
    /**
     * List of drink rounds.
     */
    protected List<Double> rounds;

    /**
     * Constructor with parameter.
     * @param billingImplementor billing implementor to use
     */
    protected Customer(BillingImplementor billingImplementor) {
        currBillingImplementor = billingImplementor;
        rounds = new ArrayList<>();
    }

    /**
     * Mutator of billing implementor.
     * @param billingImplementor billing implementor to set
     */
    public void setBillingImplementor(BillingImplementor billingImplementor) {
        currBillingImplementor = billingImplementor;
    }

    /**
     * Adds the given number of the given drinks.
     * @param price price per drink
     * @param n number of rounds
     */
    public void addDrinks(double price, int n) {
        rounds.add(currBillingImplementor.getActualPrice(price * n));
    }

    /**
     * Prints the total bill for this customer.
     */
    public void printBill() {
        double sum = rounds.stream().mapToDouble(Double::doubleValue).sum();
        System.out.println("Total due: " + sum);
        rounds.clear();
    }

}
