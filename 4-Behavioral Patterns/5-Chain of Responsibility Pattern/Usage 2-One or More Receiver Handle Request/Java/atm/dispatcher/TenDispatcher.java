package atm.dispatcher;

/**
 * TenDispatcher class that works as "ConcreteHandler".
 * This class is implemented as a singleton class.
 *
 * @author Ziang Lu
 */
public class TenDispatcher extends DollarDispatcher {

    /**
     * Singleton instance.
     */
    private volatile static TenDispatcher instance = null;

    /**
     * Gets the singleton instance.
     * This implementation utilizes Lazy Initialization Pattern and double-check
     * locking mechanism.
     * @param dispatcher next dispatcher
     * @return singleton instance
     */
    public static TenDispatcher getInstance(DollarDispatcher dispatcher) {
        if (instance == null) {
            synchronized (TenDispatcher.class) {
                if (instance == null) {
                    instance = new TenDispatcher(dispatcher);
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
    private TenDispatcher(DollarDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    protected int getDenomination() {
        return 10;
    }

}
