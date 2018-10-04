package bank_account_access;

/**
 * AccountNumberManager class as a sub-component of a bank account access.
 *
 * @author Ziang Lu
 */
class AccountNumberManager {

    /**
     * Account number of the bank account.
     */
    private final int accountNumber = 12345678;

    /**
     * Checks whether the provided account number is correct.
     * @param providedAccountNumber account number provided by the client
     * @return whether the provided account number is correct
     */
    boolean correctAccountNumber(int providedAccountNumber) {
        if (providedAccountNumber != accountNumber) {
            System.out.println("Incorrect account number!");
            return false;
        }
        return true;
    }

}
