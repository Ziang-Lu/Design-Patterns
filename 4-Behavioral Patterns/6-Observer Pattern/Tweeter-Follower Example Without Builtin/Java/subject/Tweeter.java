package subject;

import observer.Observer;

/**
 * Tweeter class that works as "ConcreteSubject".
 *
 * @author Ziang Lu
 */
public class Tweeter extends Subject {

    /**
     * Name of this tweeter.
     */
    private final String name;
    /**
     * Latest tweet of this tweeter.
     */
    private String latestTweet;

    /**
     * Constructor with parameter.
     * @param name name of the tweeter
     */
    public Tweeter(String name) {
        this.name = name;
        latestTweet = "";
    }

    /**
     * Accessor of name.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Accessor of latestTweet.
     * @return latestTweet
     */
    public String getLatestTweet() {
        return latestTweet;
    }

    /**
     * Writes a new tweet and notifies all the observers.
     */
    public void writeTweeter() {
        latestTweet = "A wonderful way with my family!";
        System.out.println(name + ": I wrote a new tweet: " + latestTweet);
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : myObservers) {
            observer.update(this);
        }
    }

}
