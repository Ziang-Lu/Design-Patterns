package runner;

import company.Company;
import subject.StockCenter;

import java.util.Random;

/**
 * GetTheStock class to simulate a thread monitoring the changing price for some
 * company.
 *
 * @author Ziang Lu
 */
class GetTheStock implements Runnable {
m
    /**
     * Random number generator.
     */
    private static final Random RANDOM_GENERATOR = new Random();

    /**
     * Stock center in this thread.
     */
    private StockCenter stockCenter;
    /**
     * Company to monitor in this thread.
     */
    private Company company;
    /**
     * Update interval for this thread.
     */
    private int interval;

    /**
     * Constructor with parameter.
     * @param stockCenter stock center for this thread
     * @param company company to monitor
     * @param interval update interval
     */
    GetTheStock(StockCenter stockCenter, Company company, int interval) {
        this.stockCenter = stockCenter;
        this.company = company;
        this.interval = interval;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; ++i) {
            try {
                Thread.sleep(interval * 1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            double changedPercent = RANDOM_GENERATOR.nextDouble() * 0.06 - 0.03;
            double newPrice = stockCenter.getPrice(company) * (1 + changedPercent);
            System.out.println(String.format("New price for %s: %.2f", company.toString(), newPrice));
            stockCenter.setPrice(company, newPrice);
        }
    }

}
