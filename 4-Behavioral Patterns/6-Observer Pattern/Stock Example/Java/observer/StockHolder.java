package observer;

import company.Company;
import subject.StockCenter;
import subject.Subject;

/**
 * StockHolder class that works as "ConcreteObserver".
 *
 * @author Ziang Lu
 */
public class StockHolder implements Observer {

    /**
     * Current latest Observer ID.
     */
    private static int observerID = 0;

    /**
     * Observer ID of this stock holder.
     */
    private int myObserverID;
    /**
     * Stock holding by this stock holder.
     */
    private Company stock;
    /**
     * Latest price known by this stock holder.
     */
    private double latestPrice;

    /**
     * Constructor with parameter.
     * @param stock stock to hold
     */
    public StockHolder(Company stock) {
        ++observerID;
        myObserverID = observerID;
        this.stock = stock;
        latestPrice = StockCenter.companyInitialPrices.get(stock);
    }

    /**
     * Follows the given stock center.
     * @param stockCenter stock center to follow
     */
    public void follow(StockCenter stockCenter) {
        stockCenter.register(this);
    }

    /**
     * Unfollows the given stock center.
     * @param stockCenter stock center to unfollow
     */
    public void unfollow(StockCenter stockCenter) {
        stockCenter.unregister(this);
    }

    @Override
    public void update(Subject subject) {
        StockCenter stockCenter = (StockCenter) subject;
        double currPrice = stockCenter.getPrice(stock);
        if (currPrice != latestPrice) {
            System.out.println(String.format("%s (ID: %d) got an update on %s Price: %.2f", getClass().getSimpleName(),
                myObserverID, stock.toString(), currPrice));
            latestPrice = currPrice;
        }
    }

}
