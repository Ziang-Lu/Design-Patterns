package subject;

import company.Company;
import observer.Observer;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/**
 * StockCenter class that works as "ConcreteSubject".
 *
 * @author Ziang Lu
 */
public class StockCenter extends Subject {

    /**
     * Mapping between companies and their corresponding initial price.
     */
    public static Map<Company, Double> companyInitialPrices;

    /**
     * Mapping between companies and their corresponding current price.
     */
    private Map<Company, Double> prices;

    /**
     * Default constructor.
     */
    public StockCenter() {
        companyInitialPrices = new HashMap<>();
        companyInitialPrices.put(Company.Google, 100.0);
        companyInitialPrices.put(Company.Apple, 80.0);

        prices = new HashMap<>(companyInitialPrices);
    }

    /**
     * Gets the current price for the given company.
     * @param company given company
     * @return current price for the given company
     */
    public double getPrice(Company company) {
        return prices.get(company);
    }

    /**
     * Sets the price for the given company.
     * Note that since the two thread shares a common StockCenter object, so if
     * we don't make this method synchronized:
     * The two threads may write to StockCenter.prices at the same time, leading
     * to an update to an observer within a thread containing two price changes,
     * which obey our initial idea to let each thread handle only one price
     * changing.
     * Thus, we need to make this method synchronized, so that only after one
     * thread finished making price changes (writing to StockCenter.prices) and
     * notifying the observers about the price change, can the other thread do
     * its price change.
     * @param company given company
     * @param price price to set
     */
    public synchronized void setPrice(Company company, double price) {
        prices.put(company, price);
        notifyObservers();
    }

    @Override
    protected void notifyObservers() {
        for (WeakReference<Observer> weakRef : myObservers) {
            Observer observer = weakRef.get();
            if (observer != null) {
                observer.update(this);
            }
        }
    }

}
