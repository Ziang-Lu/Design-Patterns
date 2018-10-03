package runner;

import atm.AtmMachine;

/**
 * Application that actually uses Chain of Responsibility Pattern.
 * In this example, ONE OR MORE THAN ONE receivers in the chain handles the
 * request.
 *
 * @author Ziang Lu
 */
public class Application {

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        AtmMachine atm = new AtmMachine();
        atm.withdraw(455);

        /*
         * Output:
         * HundredDispatcher dispatching 4 100-dollar notes
         * After dispatched by HundredDispatcher: 55 dollars pending to be dispatched.
         * TwentyDispatcher dispatching 2 20-dollar notes
         * After dispatched by TwentyDispatcher: 15 dollars pending to be dispatched.
         * TenDispatcher dispatching 1 10-dollar notes
         * After dispatched by TenDispatcher: 5 dollars pending to be dispatched.
         * FiveDispatcher dispatching 1 5-dollar notes
         */
    }

}
