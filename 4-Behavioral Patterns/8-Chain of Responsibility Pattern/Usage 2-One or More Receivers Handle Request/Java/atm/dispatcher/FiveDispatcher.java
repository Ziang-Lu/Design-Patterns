package atm.dispatcher;

/**
 * FiveDispatcher class that works as "ConcreteHandler".
 * This class is implemented as a singleton class.
 *
 * @author Ziang Lu
 */
public class FiveDispatcher extends DollarDispatcher {

    /**
     * Singleton instance.
     */
    private volatile static FiveDispatcher instance = null;

    /**
     * Gets the singleton instance.
     * This implementation utilizes Lazy Initialization Pattern and double-check
     * locking mechanism.
     * @param dispatcher next dispatcher
     * @return singleton instance
     */
    public static FiveDispatcher getInstance(DollarDispatcher dispatcher) {
        if (instance == null) {
            synchronized (FiveDispatcher.class) {
                if (instance == null) {
                    instance = new FiveDispatcher(dispatcher);
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
    private FiveDispatcher(DollarDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    protected int getDenomination() {
        return 5;
    }

}
