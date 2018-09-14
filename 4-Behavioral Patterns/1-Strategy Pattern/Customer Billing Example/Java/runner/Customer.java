package runner;

import strategy.BillingStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Customer class that works as an interface to the outside world: it wraps a
 * billing strategy and the client will use that strategy to calculate the
 * actual prices for drinks.
 *
 * @author Ziang Lu
 */
public class Customer {

    /**
     * Billing strategy to use.
     */
    private BillingStrategy billingStrategy;
    /**
     * List of drinks.
     */
    private List<Double> drinks;

    /**
     * Constructor with parameter.
     * @param billingStrategy billing strategy to use
     */
    public Customer(BillingStrategy billingStrategy) {
        this.billingStrategy = billingStrategy;
        drinks = new ArrayList<>();
    }

    /**
     * Mutator of billingStrategy.
     * @param billingStrategy billing strategy to use
     */
    public void setBillingStrategy(BillingStrategy billingStrategy) {
        this.billingStrategy = billingStrategy;
    }

    /**
     * Adds the given number of the given drinks.
     * @param price price per drink
     * @param n number of drinks
     */
    public void addDrinks(double price, int n) {
        drinks.add(billingStrategy.getActualPrice(price * n));
    }

    /**
     * Prints the total bill for this customer.
     */
    public void printBill() {
        double sum = drinks.stream().mapToDouble(Double::doubleValue).sum();
        System.out.println("Total due: " + sum);
        drinks.clear();
    }

}
