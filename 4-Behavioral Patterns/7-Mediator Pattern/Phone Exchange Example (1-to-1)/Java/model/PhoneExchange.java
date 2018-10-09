package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * PhoneExchange class that works as "Mediator".
 * A "Mediator" object acts as the communication center for "Colleague" objects.
 *
 * @author Ziang Lu
 */
public class PhoneExchange {

    /**
     * Phone directory.
     */
    private Map<String, PhoneCustomer> directory = new HashMap<>();
    /**
     * Random number generator to use when generating a phone number.
     */
    private Random randomGenerator = new Random();

    /**
     * Registers the given phone customer and assigns a phone number to this
     * customer.
     * @param customer phone customer to register
     * @return assigned phone number
     */
    String register(PhoneCustomer customer) {
        String phoneNumber = getPhoneNumber();
        directory.put(phoneNumber, customer);
        return phoneNumber;
    }

    /**
     * Private helper method to generate a phone number.
     * @return generated phone number
     */
    private String getPhoneNumber() {
        boolean valid = false;
        String phoneNumber = null;
        while (!valid) {
            phoneNumber = getThreeDigit() + "-" + getThreeDigit() + "-" + getFourDigit();
            if (!directory.containsKey(phoneNumber)) {
                valid = true;
            }
        }
        return phoneNumber;
    }

    /**
     * Helper method to generate a three-digit string.
     * @return generated three-digit string
     */
    private String getThreeDigit() {
        return String.valueOf(randomGenerator.nextInt(900) + 100);
    }

    /**
     * Helper method to generate a four-digit string.
     * @return generated four-digit string
     */
    private String getFourDigit() {
        return String.valueOf(randomGenerator.nextInt(9000) + 1000);
    }

    /**
     * Routes a call with the given message from the given caller to a recipient
     * with the given number (if any).
     * @param callerNumber caller number
     * @param recipientNumber phone number of the recipient
     * @param msg message to send
     */
    void route(String callerNumber, String recipientNumber, String msg) {
        if (!directory.containsKey(recipientNumber)) {
            System.out.println("Failed.");
            return;
        }
        System.out.println("Successful!");
        directory.get(recipientNumber).receiveCall(callerNumber, msg);
    }

}
