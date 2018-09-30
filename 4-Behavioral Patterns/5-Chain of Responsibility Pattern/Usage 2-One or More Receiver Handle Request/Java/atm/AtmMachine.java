package atm;

import atm.dispatcher.DollarDispatcher;
import atm.dispatcher.FiveDispatcher;
import atm.dispatcher.HundredDispatcher;
import atm.dispatcher.OneDispatcher;
import atm.dispatcher.TenDispatcher;
import atm.dispatcher.TwentyDispatcher;

/**
 * ATM machine class.
 *
 * @author Ziang Lu
 */
public class AtmMachine {

    /**
     * First dispatcher to handle withdraw requests.
     */
    private final DollarDispatcher firstDispatcher;

    /**
     * Default constructor.
     */
    public AtmMachine() {
        // Chain the dispatchers, which is the chain of responsibility
        firstDispatcher = HundredDispatcher.getInstance(
                TwentyDispatcher.getInstance(
                        TenDispatcher.getInstance(FiveDispatcher.getInstance(OneDispatcher.getInstance()))
                )
        );
    }

    /**
     * Withdraws the given amount of money from this ATM.
     * @param requestedAmount requested amount of money
     */
    public void withdraw(int requestedAmount) {
        // Delegate to the dispatchers to handle this withdraw request
        entryDispatcher.dispatch(requestedAmount);
    }

}
