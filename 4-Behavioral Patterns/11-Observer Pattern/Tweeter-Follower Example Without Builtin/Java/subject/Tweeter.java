package subject;

import observer.Observer;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Tweeter class that works as "ConcreteSubject".
 *
 * @author Ziang Lu
 */
public class Tweeter extends Subject {

    /**
     * Username of this tweeter.
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
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        for (WeakReference<Observer> weakRef : myObservers) {
            Observer observer = weakRef.get();
            if (observer != null) {
                observer.update(this);
            }
        }
    }

}
