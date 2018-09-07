package bank_account_access;

/**
 * SecurityCodeManager class as a sub-component of a bank account access.
 *
 * @author Ziang Lu
 */
class SecurityCodeManager {

    /**
     * PIN of the bank account.
     */
    private final int pin = 1234;

    /**
     * Check whether the provided PIN is correct.
     * @param providedPin PIN provided by the client
     * @return whether the provided PIN is correct
     */
    boolean correctPin(int providedPin) {
        if (providedPin != pin) {
            System.out.println("Incorrect PIN!");
            return false;
        }
        return true;
    }

}
