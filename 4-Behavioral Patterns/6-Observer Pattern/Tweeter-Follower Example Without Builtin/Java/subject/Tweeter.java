package subject;

import observer.Observer;

/**
 * Tweeter class that works as "ConcreteSubject".
 *
 * @author Ziang Lu
 */
public class Tweeter extends Subject {

    /**
     * Username of this tweeter.
     */
    private final String username;
    /**
     * Latest tweet of this tweeter.
     */
    private String latestTweet;

    /**
     * Constructor with parameter.
     * @param username username of the tweeter
     */
    public Tweeter(String username) {
        this.username = username;
        latestTweet = "";
    }

    /**
     * Accessor of username.
     * @return username
     */
    public String getUsername() {
        return username;
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
        System.out.println(username + ": I wrote a new tweet: " + latestTweet);
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : myObservers) {
            observer.update(this);
        }
    }

}
