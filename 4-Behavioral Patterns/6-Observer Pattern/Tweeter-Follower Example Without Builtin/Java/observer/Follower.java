package observer;

import subject.Subject;
import subject.Tweeter;

/**
 * Follower class that works as "ConcreteObserver".
 *
 * @author Ziang Lu
 */
public class Follower extends Observer {

    /**
     * Name of this follower.
     */
    private final String name;

    /**
     * Constructor with parameter.
     * @param name name of the follower
     */
    public Follower(String name) {
        this.name = name;
    }

    @Override
    public void update(Subject subject) {
        Tweeter tweeter = (Tweeter) subject;
        System.out.println(name + ": I got an update from " + tweeter.getName() + " about a new tweet: " +
                tweeter.getLatestTweet());
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
