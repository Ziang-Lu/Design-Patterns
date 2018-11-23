package billing_implementor;

/**
 * Concrete HappyHourBillingImplementor class that works as
 * "ConcreteImplementor" to get the actual price using happy hour billing
 * implementor.
 * This class is implemented as a singleton class.
 *
 * @author Ziang Lu
 */
public class HappyHourBillingImplementor implements BillingImplementor {

    /**
     * Singleton instance.
     */
    private volatile static HappyHourBillingImplementor instance;

    /**
     * Gets the singleton instance.
     * This implementation utilizes Lazy Initialization Pattern and double-check
     * locking mechanism.
     * @return singleton instance
     */
    public static HappyHourBillingImplementor getInstance() {
        HappyHourBillingImplementor localRef = instance;
        if (localRef == null) {
            synchronized (HappyHourBillingImplementor.class) {
                if (localRef == null) {
                    instance = localRef = new HappyHourBillingImplementor();
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
    private HappyHourBillingImplementor() {}

    @Override
    public double getActualPrice(double rawPrice) {
        // 50% discount
        return rawPrice * 0.5;
    }

}
