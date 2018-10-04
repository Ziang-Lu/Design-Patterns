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
    private final WelcomeScreen welcomeScreen;
    /**
     * Account number manager of this bank account access.
     */
    private final AccountNumberManager accountManger;
    /**
     * PIN manager of this bank account access.
     */
    private final SecurityCodeManager pinManager;
    /**
     * Balance manager of this bank account access.
     */
    private final BalanceManager balanceManager;
    /**
     * Account number provided by the client.
     */
    private final int providedAccountNumber;
    /**
     * PIN provided by the client.
     */
    private final int providedPin;

    /**
     * Constructor with parameter.
     * @param accountNumber account number provided by the client
     * @param pin PIN provided by the client
     */
    public BankAccountAccessFacade(int accountNumber, int pin) {
        welcomeScreen = new WelcomeScreen();
        accountManger = new AccountNumberManager();
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
        if (!correctAccountInfo()) {
            return;
        }
        balanceManager.withdraw(amount);
        System.out.println("Transaction completed!");
    }

    /**
     * Private helper method to check the provided account number and PIN.
     * @return whether the provided account number and PIN is correct
     */
    private boolean correctAccountInfo() {
        return accountManger.correctAccountNumber(providedAccountNumber) && pinManager.correctPin(pin);
    }

    /**
     * Deposits money to the bank account,
     * @param amount amount of money to deposit
     */
    public void depositCash(int amount) {
        if (!correctAccountInfo()) {
            return;
        }
        balanceManager.deposit(amount);
        System.out.println("Transaction compledted!");
    }

}
