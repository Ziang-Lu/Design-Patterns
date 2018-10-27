package strategy;

/**
 * Abstract billing strategy interface to define the getting actual price task
 * to perform (getting actual price problem to solve).
 *
 * @author Ziang Lu
 */
public interface BillingStrategy {

    /**
     * Calculates the actual price from the given raw price according to the
     * current billing strategy.
     * @param rawPrice raw price
     * @return actual price
     */
    double getActualPrice(double rawPrice);

}
