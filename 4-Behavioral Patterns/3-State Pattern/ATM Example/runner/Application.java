package runner;

import atm.AtmMachine;
import card.Card;

/**
 * Application.
 *
 * @author Ziang Lu
 */
public class Application {

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        Card pncCard = new Card(1005, 10000);
        AtmMachine atm = new AtmMachine();

        atm.insertCard(pncCard);
        atm.enterPin(1005);
        atm.checkBalance();
        atm.requestCash(1500);
        atm.ejectCard();

        System.out.println();
        atm.insertCard(pncCard);
        atm.enterPin(1005);
        atm.checkBalance();
        atm.requestCash(1500);
        atm.ejectCard();

        /*
         * Output:
         * Current balance: $10000
         * Successfully withdrew $1500
         * Thanks for using.
         *
         * Current balance: $8500
         * No enough cash! Can only withdraw $500
         * Thanks for using.
         */
    }

}
