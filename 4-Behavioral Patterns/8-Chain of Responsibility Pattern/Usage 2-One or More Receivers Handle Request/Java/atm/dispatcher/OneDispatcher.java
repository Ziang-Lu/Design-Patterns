package atm.dispatcher;

/**
 * OneDispatcher class that works as "ConcreteHandler".
 * This class is implemented as a singleton class.
 *
 * @author Ziang Lu
 */
public class OneDispatcher extends DollarDispatcher {

    /**
     * Singleton instance.
     */
    private volatile static OneDispatcher instance = null;

    /**
     * Gets the singleton instance.
     * This implementation utilizes Lazy Initialization Pattern and double-check
     * locking mechanism.
     * @param dispatcher next dispatcher
     * @return singleton instance
     */
    public static OneDispatcher getInstance(DollarDispatcher dispatcher) {
        if (instance == null) {
            synchronized (OneDispatcher.class) {
                if (instance == null) {
                    instance = new OneDispatcher(dispatcher);
                }
            }
        }
        return instance;
    }

    /**
     * Private default constructor.
     * This has to be private so that the class instances cannot be created
     * outside of the class.
     */
    private OneDispatcher() {
        super(null);
    }

    @Override
    protected int getDenomination() {
        return 1;
    }

}
