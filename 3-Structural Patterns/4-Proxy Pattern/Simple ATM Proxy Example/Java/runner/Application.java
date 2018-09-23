package runner;

import atm.AtmMachine;
import atm_proxy.AtmMachineInfoProxy;
import atm_proxy.GetAtmData;
import card.Card;

/**
 * Application that actually uses Proxy Pattern.
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

        System.out.println();

        // Proxy Pattern demo

        AtmMachine realAtm = new AtmMachine();
        GetAtmData atmInfoProxy = new AtmMachineInfoProxy(realAtm);

        // By using the proxy, we limit the accessible methods of the real subject AtmMachine to be only getAtmState()
        // and getCashInAtm().
        System.out.println("Current state of the ATM: " + atmInfoProxy.getAtmState());
        System.out.println("Current amount of cash in the ATM: $" + atmInfoProxy.getCashInAtm());

        /*
         * Output:
         * Current state of the ATM: NoCardState
         * Current amount of cash in the ATM: $2000
         */

        // By contrast, the client cannot perform this action:
        // atmInfoProxy.insertCard(pncCard);
        // Because insertCard() method is not defined in the super class "Subject", meaning that we don't want our
        // client to have access to it.
    }

}
