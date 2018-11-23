package billing_implementor;

/**
 * Concrete NormalBillingImplementor class that works as "ConcreteImplementor"
 * to get the actual price using normal billing implementor.
 * This class is implemented as a singleton class.
 *
 * @author Ziang Lu
 */
public class NormalBillingImplementor implements BillingImplementor {

    /**
     * Singleton instance.
     */
    private volatile static NormalBillingImplementor instance;

    /**
     * Gets the singleton instance.
     * This implementation utilizes Lazy Initialization Pattern and double-check
     * locking mechanism.
     * @return singleton instance
     */
    public static NormalBillingImplementor getInstance() {
        NormalBillingImplementor localRef = instance;
        if (localRef == null) {
            synchronized (NormalBillingImplementor.class) {
                if (localRef == null) {
                    instance = localRef = new NormalBillingImplementor();
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
    private NormalBillingImplementor() {}

    @Override
    public double getActualPrice(double rawPrice) {
        return rawPrice;
    }

}
