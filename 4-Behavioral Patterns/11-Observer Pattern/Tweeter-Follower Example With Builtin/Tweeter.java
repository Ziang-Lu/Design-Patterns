import java.util.Observable;

/**
 * Tweeter class that works as "ConcreteSubject".
 *
 * @author Ziang Lu
 */
public class Tweeter extends Observable {

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
     * Writes a new tweet and notify all the observers.
     */
    public void writeTweet() {
        latestTweet = "A wonderful day!";
        System.out.println(name + ": I wrote a new tweet: " + latestTweet);
        // Note that for notifyObservers() method to take any effect, the method setChanged() must be called prior to
        // the call to notifyObservers()
        setChanged();
        notifyObservers(this);
    }

}
