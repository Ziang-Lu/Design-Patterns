package runner;

import company.Company;
import observer.StockHolder;
import subject.StockCenter;

/**
 * Application that actually uses Observer Pattern with multi-threading.
 *
 * @author Ziang Lu
 */
public class Application {

    /**
     * Main driver.
     * @param args argument from command line
     */
    public static void main(String[] args) {
        StockCenter stockCenter = new StockCenter();
        StockHolder googleHolder = new StockHolder(Company.Google);
        googleHolder.follow(stockCenter);
        StockHolder appleHolder = new StockHolder(Company.Apple);
        appleHolder.follow(stockCenter);

        new Thread(new GetTheStock(stockCenter, Company.Google, 2)).start();
        new Thread(new GetTheStock(stockCenter, Company.Apple, 2)).start();

        /*
         * Output:
         * New price for Google: 100.29
         * New price for Apple: 78.53
         * StockHolder (ID: 1) got an update on Google Price: 100.29
         * StockHolder (ID: 2) got an update on Apple Price: 78.53
         * New price for Google: 98.34
         * StockHolder (ID: 1) got an update on Google Price: 98.34
         * New price for Apple: 76.73
         * StockHolder (ID: 2) got an update on Apple Price: 76.73
         * New price for Google: 98.58
         * StockHolder (ID: 1) got an update on Google Price: 98.58
         * New price for Apple: 76.50
         * StockHolder (ID: 2) got an update on Apple Price: 76.50
         */
    }

}
