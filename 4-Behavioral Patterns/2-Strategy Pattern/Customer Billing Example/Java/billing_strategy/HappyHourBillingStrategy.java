package strategy;

/**
 * Concrete HappyHourBillingStrategy to perform the getting actual price task
 * (solve the getting actual price problem) using the happy hour billing
 * strategy.
 * This class is implemented as a singleton class.
 *
 * @author Ziang Lu
 */
public class HappyHourBillingStrategy implements BillingStrategy {

    /**
     * Singleton instance.
     */
    private volatile static HappyHourBillingStrategy instance = null;

    /**
     * Gets the singleton instance.
     * This implementation utilizes Lazy Initialization Pattern and double-check
     * locking mechanism.
     * @return singleton instance
     */
    public static HappyHourBillingStrategy getInstance() {
        HappyHourBillingStrategy localRef = instance;
        if (localRef == null) {
            synchronized (HappyHourBillingStrategy.class) {
                if (localRef == null) {
                    instance = localRef = new HappyHourBillingStrategy();
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
    private HappyHourBillingStrategy() {}

    @Override
    public double getActualPrice(double rawPrice) {
        // 50% discount
        return rawPrice * 0.5;
    }

}
