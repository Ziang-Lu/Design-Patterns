package customer;

import billing_implementor.BillingImplementor;

/**
 * Concrete TeenagerCustomer class that works as "ConcreteImplementor".
 *
 * @author Ziang Lu
 */
public class TeenagerCustomer extends Customer {

    /**
     * Constructor with parameter.
     * @param billingImpl billing implementor to use
     */
    public TeenagerCustomer(BillingImplementor billingImpl) {
        super(billingImpl);
    }

    @Override
    public void addDrinks(double price, int n) {
        if (rounds.size() < 3) {
            super.addDrinks(price, n);
        }
    }

}
