package strategy;

/**
 * Concrete NormalBillingStrategy to perform the getting actual price task
 * (solve the getting actual price problem) using the normal billing strategy.
 *
 * @author Ziang Lu
 */
public class NormalBillingStrategy implements BillingStrategy {

    @Override
    public double getActualPrice(double rawPrice) {
        return rawPrice;
    }

}
