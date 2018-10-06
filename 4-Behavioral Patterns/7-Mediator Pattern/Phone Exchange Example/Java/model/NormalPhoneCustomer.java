package model;

/**
 * Concrete NormalPhoneCustomer class that works as "ConcreteColleague'.
 * Normal phone customers have limited number of calls per month.
 *
 * @author Ziang Lu
 */
public class NormalPhoneCustomer extends PhoneCustomer {

    /**
     * Limited number of calls per month for a normal phone customer.
     */
    private static final int CALLS_PER_MONTH = 50;

    /**
     * Constructor with parameter.
     * @param name name of this phone customer
     * @param phoneExchange phone exchange for this phone customer
     */
    public NormalPhoneCustomer(String name, PhoneExchange phoneExchange) {
        super(name, phoneExchange);
    }

    @Override
    public String toString() {
        return "NormalPhoneCustomer{name=" + name + ", phoneNumber=" + phoneNumber + "} with " + CALLS_PER_MONTH +
                " calls per month";
    }

}
