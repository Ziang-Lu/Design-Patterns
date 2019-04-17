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
    private final String name;

    /**
     * Constructor with parameter.
     * @param name name of the follower
     */
    public Follower(String name) {
        this.name = name;
    }

    /**
     * Follows the given tweeter.
     * @param tweeter tweeter to follow
     */
    public void follow(Tweeter tweeter) {
        System.out.println(name + ": Starting to follow " + tweeter.getName());
        tweeter.register(this);
    }

    /**
     * Unfollows the given tweeter.
     * @param tweeter tweeter to unfollow
     */
    public void unfollow(Tweeter tweeter) {
        System.out.println(name + ": Stops to follow " + tweeter.getName());
        tweeter.unregister(this);
    }

    @Override
    public void update(Subject subject) {
        Tweeter tweeter = (Tweeter) subject;
        System.out.println(name + ": I got an update from " + tweeter.getName() + " about a new tweet: " +
                tweeter.getLatestTweet().getContent());
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Observer)) {
            return false;
        }
        Follower anotherFollower = (Follower) o;
        return name.equals(anotherFollower.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

}
