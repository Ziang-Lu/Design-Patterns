package model;

/**
 * Abstract PhoneCustomer class that works as "Colleague".
 * When a "Colleague" object needs to communicate to another "Colleague" object,
 * it does not directly call on the other "Colleague" object; instead, it calls
 * the "Mediator" object whose main duty is to route the message to the
 * destination "Colleague" object.
 * In this way, the communication complexity between the "Colleague" objects are
 * greatly reduced.
 *
 * @author Ziang Lu
 */
public abstract class PhoneCustomer {

    /**
     * Name of this phone customer.
     */
    protected final String name;
    /**
     * Phone number of this phone customer.
     */
    protected final String phoneNumber;
    /**
     * Phone exchange for this phone customer.
     */
    private PhoneExchange phoneExchange;

    /**
     * Constructor with parameter.
     * @param name name of this phone customer
     * @param phoneExchange phone exchange for this phone customer
     */
    protected PhoneCustomer(String name, PhoneExchange phoneExchange) {
        this.name = name;
        phoneNumber = phoneExchange.register(this);
        this.phoneExchange = phoneExchange;
    }

    /**
     * Accessor of phoneNumber.
     * @return phoneNumber
     */
    public String getNumber() {
        return phoneNumber;
    }

    /**
     * Calls the given recipient with the given message.
     * @param recipientNumber phone number of the recipient
     * @param msg message to send
     */
    public void call(String recipientNumber, String msg) {
        System.out.println(name + " calling " + recipientNumber + " with message: " + msg + " ...");
        phoneExchange.call(phoneNumber, recipientNumber, msg);
    }

    /**
     * Receives a call from the given number with the given message.
     * @param callerNumber caller number
     * @param msg received message
     */
    void receiveCall(String callerNumber, String msg) {
        System.out.println(name + " received a call from " + callerNumber + " with message: " + msg);
    }

}
