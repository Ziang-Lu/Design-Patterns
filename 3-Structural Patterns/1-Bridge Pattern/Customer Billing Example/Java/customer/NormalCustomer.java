package customer;

import billing_implementor.BillingImplementor;

/**
 * Concrete NormalCustomer class that works as "ConcreteImplementor".
 *
 * @author Ziang Lu
 */
public class NormalCustomer extends Customer {

    /**
     * Constructor with parameter.
     * @param billingImplementor billing implementor to use
     */
    public NormalCustomer(BillingImplementor billingImplementor) {
        super(billingImplementor);
    }

}
