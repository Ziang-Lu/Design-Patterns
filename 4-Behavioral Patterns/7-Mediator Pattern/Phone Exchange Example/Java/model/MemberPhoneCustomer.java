package model;

/**
 * Concrete MemberPhoneCustomer class that works as "ConcreteColleague'.
 * Member phone customers have unlimited number of calls per month.
 *
 * @author Ziang Lu
 */
public class MemberPhoneCustomer extends PhoneCustomer {

    /**
     * Constructor with parameter.
     * @param name name of this phone customer
     * @param phoneExchange phone exchange for this phone customer
     */
    public MemberPhoneCustomer(String name, PhoneExchange phoneExchange) {
        super(name, phoneExchange);
    }

    @Override
    public String toString() {
        return "MemberPhoneCustomer{name=" + name + ", phoneNumber=" + phoneNumber + "} with unlimited calls per month";
    }

}
