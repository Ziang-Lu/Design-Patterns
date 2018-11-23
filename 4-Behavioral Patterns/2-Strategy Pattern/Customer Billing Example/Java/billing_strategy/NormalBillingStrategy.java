package billing_strategy;

/**
 * Concrete NormalBillingStrategy to perform the getting actual price task
 * (solve the getting actual price problem) using the normal billing strategy.
 * This class is implemented as a singleton class.
 *
 * @author Ziang Lu
 */
public class NormalBillingStrategy implements BillingStrategy {

    /**
     * Singleton instance.
     */
    private volatile static NormalBillingStrategy instance = null;

    /**
     * Gets the singleton instance.
     * This implementation utilizes Lazy Initialization Pattern and double-check
     * locking mechanism.
     * @return singleton instance
     */
    public static NormalBillingStrategy getInstance() {
        NormalBillingStrategy localRef = instance;
        if (localRef == null) {
            synchronized (NormalBillingStrategy.class) {
                if (localRef == null) {
                    instance = localRef = new NormalBillingStrategy();
                }
            }
        }
        return localRef;
    }

    /**
     * Private default constructor.
     * This has to be private so that the class instances cannot be created
     * outside of the class.
     */
    private NormalBillingStrategy() {}

    @Override
    public double getActualPrice(double rawPrice) {
        return rawPrice;
    }

}
