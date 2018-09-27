package subject;

import company.Company;
import observer.Observer;

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
     * @param company given company
     * @param price price to set
     */
    public void setPrice(Company company, double price) {
        prices.put(company, price);
        notifyObservers();
    }

    @Override
    protected synchronized void notifyObservers() {
        for (Observer observer : myObservers) {
            observer.update(this);
        }
    }

}
