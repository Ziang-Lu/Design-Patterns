package observer;

import subject.Subject;
import subject.Tweeter;

/**
 * Follower class that works as "ConcreteObserver".
 *
 * @author Ziang Lu
 */
public class Follower implements Observer {

    /**
     * Username of this follower.
     */
    private final String username;

    /**
     * Constructor with parameter.
     * @param username username of the follower
     */
    public Follower(String username) {
        this.username = username;
    }

    /**
     * Follows the given tweeter.
     * @param tweeter tweeter to follow
     */
    public void follow(Tweeter tweeter) {
        System.out.println(username + ": Starting to follow " + tweeter.getUsername());
        tweeter.register(this);
    }

    /**
     * Unfollows the given tweeter.
     * @param tweeter tweeter to unfollow
     */
    public void unfollow(Tweeter tweeter) {
        System.out.println(username + ": Stops to follow " + tweeter.getUsername());
        tweeter.unregister(this);
    }

    @Override
    public void update(Subject subject) {
        Tweeter tweeter = (Tweeter) subject;
        System.out.println(username + ": I got an update from " + tweeter.getUsername() + " about a new tweet: " +
                tweeter.getLatestTweet());
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Observer)) {
            return false;
        }
        Follower anotherFollower = (Follower) o;
        return username.equals(anotherFollower.username);
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }

}
