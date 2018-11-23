package atm.dispatcher;

/**
 * HundredDispatcher class that works as "ConcreteHandler".
 * This class is implemented as a singleton class.
 *
 * @author Ziang Lu
 */
public class HundredDispatcher extends DollarDispatcher {

    /**
     * Singleton instance.
     */
    private volatile static HundredDispatcher instance = null;

    /**
     * Gets the singleton instance.
     * This implementation utilizes Lazy Initialization Pattern and double-check
     * locking mechanism.
     * @param dispatcher next dispatcher
     * @return singleton instance
     */
    public static HundredDispatcher getInstance(DollarDispatcher dispatcher) {
        HundredDispatcher localRef = instance;
        if (localRef == null) {
            synchronized (HundredDispatcher.class) {
                if (localRef == null) {
                    instance = localRef = new HundredDispatcher(dispatcher);
                }
            }
        }
        return localRef;
    }

    /**
     * Private default constructor.
     * This has to be private so that the class instances cannot be created
     * outside of the class.
     * @param dispatcher next dispatcher
     */
    private HundredDispatcher(DollarDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    protected int getDenomination() {
        return 100;
    }

}
