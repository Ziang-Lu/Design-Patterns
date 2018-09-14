package strategy;

/**
 * Concrete HappyHourBillingStrategy to perform the getting actual price task
 * (solve the getting actual price problem) using the happy hour billing
 * strategy.
 *
 * @author Ziang Lu
 */
public class HappyHourBillingStrategy implements BillingStrategy {

    @Override
    public double getActualPrice(double rawPrice) {
        // 50% discount
        return rawPrice * 0.5;
    }

}
