package bank_account_access;

/**
 * BalanceManager class as a sub-component of a bank account access.
 *
 * @author Ziang Lu
 */
class BalanceManager {

    /**
     * Balance in the bank account.
     */
    private double balance = 1000.0;

    /**
     * Withdraws money from the bank account.
     * @param amount amount of money to withdraw
     */
    void withdraw(double amount) {
        if (hasEnoughBalance(amount)) {
            balance -= amount;
            System.out.println("Withdrawal completed! Current balance: $" + balance);
        }
    }

    /**
     * Checks whether there is enough balance in the bank account comparing to
     * the given amount.
     * @param amount amount of balance to compare
     * @return whether there is enough balance
     */
    private boolean hasEnoughBalance(double amount) {
        if (amount > balance) {
            System.out.println("You don't have that much money!");
            System.out.println("Current balance: $" + balance);
            return false;
        }
        return true;
    }

    /**
     * Deposits money to the bank account.
     * @param amount amount of money to deposit
     */
    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposition completed! Current balance: $" + balance);
    }

}
