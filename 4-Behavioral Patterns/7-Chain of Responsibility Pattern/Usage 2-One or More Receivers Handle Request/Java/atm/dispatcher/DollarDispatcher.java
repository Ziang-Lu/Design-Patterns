package atm.dispatcher;

/**
 * Abstract DollarDispatcher class that works as "Handler".
 *
 * In order to let different "ConcreteHandler" be able to process the same
 * request, we need them to have similar API.
 * Therefore, we simply let this step be done via letting different
 * "ConcreteHandler" share a common super class "Handler", in which we define
 * the API to process a request.
 *
 * @author Ziang Lu
 */
public abstract class DollarDispatcher {

    /**
     * Next dispatcher of this dispatcher.
     * This works as the next receiver (handler) in the chain of responsibility:
     * if this receiver cannot handle the request, then it passes the request to
     * the next receiver in the chain of responsibility.
     */
    private DollarDispatcher nextDispatcher;

    /**
     * Constructor with parameter.
     * @param nextDispatcher next dispatcher
     */
    DollarDispatcher(DollarDispatcher nextDispatcher) {
        this.nextDispatcher = nextDispatcher;
    }

    /**
     * Gets the denomination of this dispatcher.
     * @return denomination of this dispatcher
     */
    protected abstract int getDenomination();

    /**
     * Dispatches notes according to the requested amount of money.
     * @param requestedAmount requested amount of money
     */
    public void dispatch(int requestedAmount) {
        // This receiver handles the request.
        int denomination = getDenomination();
        int numOfNotes = requestedAmount / denomination;
        if (numOfNotes > 0) {
            dispatchDollar(denomination, numOfNotes);
        }
        // Check whether the request needs further processing
        int pendingAmount = requestedAmount % denomination;
        if ((pendingAmount > 0) && (nextDispatcher != null)) { // If yes
            // Pass the request to the next receiver in the chain of responsibility
            System.out.println("After dispatched by " + getClass().getSimpleName() + ": " + pendingAmount +
                    " dollars pending to be dispatched");
            nextDispatcher.dispatch(pendingAmount);
        }
    }

    /**
     * Private helper method to dispatch the given number of notes for the given
     * denomination.
     * @param denomination denomination of the note to dispatch
     * @param numOfNotes number of notes to dispatch
     */
    private void dispatchDollar(int denomination, int numOfNotes) {
        System.out.println(getClass().getSimpleName() + " dispatching " + numOfNotes + " " + denomination +
                "-dollar notes");
    }

}
