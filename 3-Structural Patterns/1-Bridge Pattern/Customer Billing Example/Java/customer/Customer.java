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
    private BillingImplementor currBillingImpl;
    /**
     * List of drink rounds.
     */
    protected List<Double> rounds;

    /**
     * Constructor with parameter.
     * @param billingImpl billing implementor to use
     */
    protected Customer(BillingImplementor billingImpl) {
        currBillingImpl = billingImplementor;
        rounds = new ArrayList<>();
    }

    /**
     * Mutator of billing implementor.
     * @param billingImpl billing implementor to set
     */
    public void setBillingImplementor(BillingImplementor billingImpl) {
        currBillingImpl = billingImpl;
    }

    /**
     * Adds the given number of the given drinks.
     * @param price price per drink
     * @param n number of rounds
     */
    public void addDrinks(double price, int n) {
        rounds.add(currBillingImpl.getActualPrice(price * n));
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
