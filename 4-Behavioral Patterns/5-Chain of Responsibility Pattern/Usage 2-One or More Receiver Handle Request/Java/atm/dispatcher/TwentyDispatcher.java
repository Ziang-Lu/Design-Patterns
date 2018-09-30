package atm.dispatcher;

/**
 * TwentyDispatcher class that works as "ConcreteHandler".
 * This class is implemented as a singleton class.
 *
 * @author Ziang Lu
 */
public class TwentyDispatcher extends DollarDispatcher {

    /**
     * Singleton instance.
     */
    private volatile static TwentyDispatcher instance = null;

    /**
     * Gets the singleton instance.
     * This implementation utilizes Lazy Initialization Pattern and double-check
     * locking mechanism.
     * @param dispatcher next dispatcher
     * @return singleton instance
     */
    public static TwentyDispatcher getInstance(DollarDispatcher dispatcher) {
        if (instance == null) {
            synchronized (TwentyDispatcher.class) {
                if (instance == null) {
                    instance = new TwentyDispatcher(dispatcher);
                }
            }
        }
        return instance;
    }

    /**
     * Private default constructor.
     * This has to be private so that the class instances cannot be created
     * outside of the class.
     * @param dispatcher next dispatcher
     */
    private TwentyDispatcher(DollarDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    protected int getDenomination() {
        return 20;
    }

}
