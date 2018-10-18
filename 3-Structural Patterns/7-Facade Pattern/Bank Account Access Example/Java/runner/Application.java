package runner;

import bank_account_access.BankAccountAccessFacade;

/**
 * Application that actually uses Facade Pattern.
 * Note that by using Facade Pattern, the application now doesn't necessarily to
 * know the complex logic and implementation details in the sub-components, but
 * only need to interact with the Facade.
 *
 * @author Ziang Lu
 */
public class Application {

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        BankAccountAccessFacade bankAccountAccess = new BankAccountAccessFacade(12345678, 1234);

        System.out.println();
        bankAccountAccess.withdrawCash(50);
        System.out.println();
        bankAccountAccess.withdrawCash(900);
        System.out.println();
        bankAccountAccess.depositCash(200);

        /*
         * Output:
         * Welcome to ABC bank!
         * We are glad to serve you.
         *
         * Withdrawal completed! Current balance: $950.0
         * Transaction completed!
         *
         * Withdrawal completed! Current balance: $50.0
         * Transaction completed!
         *
         * Deposit completed! Current balance: $250.0
         * Transaction completed!
         */
    }

}
