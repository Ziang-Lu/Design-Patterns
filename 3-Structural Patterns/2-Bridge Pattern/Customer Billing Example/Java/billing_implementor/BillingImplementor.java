package billing_implementor;

/**
 * Abstract billing implementor interface that works as "Implementor" to define
 * the methods that the concrete implementation classes must implement.
 * This interface acts as a bridge between the abstraction layer and the
 * concrete implementation classes.
 *
 * @author Ziang Lu
 */
public interface BillingImplementor {

    /**
     * Calculates the actual price from the given raw price according to this
     * billing implementor.
     * @param rawPrice raw price
     * @return actual price
     */
    double getActualPrice(double rawPrice);

}
