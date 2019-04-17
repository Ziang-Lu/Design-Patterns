import java.util.ArrayList;
import java.util.List;
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
     * Tweeter history of this tweeter.
     */
    private List<Tweet> tweetHistory;

    /**
     * Constructor with parameter.
     * @param name name of the tweeter
     */
    public Tweeter(String name) {
        this.name = name;
        tweetHistory = new ArrayList<>();
    }

    /**
     * Accessor of name.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the latest tweet.
     * @return latest tweet
     */
    public Tweet getLatestTweet() {
        return tweetHistory.get(tweetHistory.size() - 1);
    }

    /**
     * Writes a new tweet and notify all the observers.
     * @param content content of the tweet
     */
    public void writeTweet(String content) {
        tweetHistory.add(new Tweet(content));
        System.out.println(name + ": I wrote a new tweet: " + content);
        // Note that for notifyObservers() method to take any effect, the method setChanged() must be called prior to
        // the call to notifyObservers()
        setChanged();
        notifyObservers(this);
    }

}
