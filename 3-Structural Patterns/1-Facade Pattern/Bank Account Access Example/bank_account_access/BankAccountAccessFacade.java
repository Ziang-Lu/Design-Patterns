package bank_account_access;

/**
 * Facade class for bank account access that serves as a front-facing interface
 * masking more complex sub-components to simplify the usage for client and
 * minimize the dependencies between the client and the sub-components.
 *
 * @author Ziang Lu
 */
public class BankAccountAccessFacade {

    /**
     * Welcome screen of this bank account access.
     */
    private WelcomeScreen welcomeScreen;
    /**
     * Account number manager of this bank account access.
     */
    private AccountNumberManager accountNumberManager;
    /**
     * PIN manager of this bank account access.
     */
    private SecurityCodeManager pinManager;
    /**
     * Balance manager of this bank account access.
     */
    private BalanceManager balanceManager;
    /**
     * Account number provided by the client.
     */
    private int providedAccountNumber;
    /**
     * PIN provided by the client.
     */
    private int providedPin;

    /**
     * Constructor with parameter.
     * @param accountNumber account number provided by the client
     * @param pin PIN provided by the client
     */
    public BankAccountAccessFacade(int accountNumber, int pin) {
        welcomeScreen = new WelcomeScreen();
        accountNumberManager = new AccountNumberManager();
        pinManager = new SecurityCodeManager();
        balanceManager = new BalanceManager();
        providedAccountNumber = accountNumber;
        providedPin = pin;
    }

    /**
     * Withdraws money from the bank account.
     * @param amount amount of money to withdraw
     */
    public void withdrawCash(int amount) {
        // Check account number
        if (!accountNumberManager.correctAccountNumber(providedAccountNumber)) {
            return;
        }
        // Check PIN
        if (!pinManager.correctPin(providedPin)) {
            return;
        }
        // Withdraw the money
        balanceManager.withdraw(amount);
    }

    /**
     * Deposits money to the bank account
     * @param amount amount of money to deposit
     */
    public void depositCash(int amount) {
        // Check account number
        if (!accountNumberManager.correctAccountNumber(providedAccountNumber)) {
            return;
        }
        // Check PIN
        if (!pinManager.correctPin(providedPin)) {
            return;
        }
        // Deposit the money
        balanceManager.deposit(amount);
    }

}
