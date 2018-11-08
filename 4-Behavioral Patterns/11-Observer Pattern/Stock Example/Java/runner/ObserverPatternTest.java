package runner;

import company.Company;
import observer.StockHolder;
import subject.StockCenter;

/**
 * Application that actually uses Observer Pattern with multi-threading.
 *
 * @author Ziang Lu
 */
public class ObserverPatternTest {

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

        new Thread(new GetTheStock(stockCenter, Company.Google, 2), "Thread-Google Price Changing").start();
        new Thread(new GetTheStock(stockCenter, Company.Apple, 2), "Thread-Apple Price Changing").start();

        /*
         * Output:
         * [Thread-Apple Price Changing] New price for Apple: 81.52
         * [Thread-Google Price Changing] New price for Google: 99.77
         * [Thread-Apple Price Changing] StockHolder (ID: 2) got an update on Apple Price: 81.52
         * [Thread-Google Price Changing] StockHolder (ID: 1) got an update on Google Price: 99.77
         * [Thread-Apple Price Changing] New price for Apple: 81.20
         * [Thread-Google Price Changing] New price for Google: 97.57
         * [Thread-Apple Price Changing] StockHolder (ID: 2) got an update on Apple Price: 81.20
         * [Thread-Google Price Changing] StockHolder (ID: 1) got an update on Google Price: 97.57
         * [Thread-Apple Price Changing] New price for Apple: 82.08
         * [Thread-Google Price Changing] New price for Google: 99.25
         * [Thread-Apple Price Changing] StockHolder (ID: 2) got an update on Apple Price: 82.08
         * [Thread-Google Price Changing] StockHolder (ID: 1) got an update on Google Price: 99.25
         */
    }

}
