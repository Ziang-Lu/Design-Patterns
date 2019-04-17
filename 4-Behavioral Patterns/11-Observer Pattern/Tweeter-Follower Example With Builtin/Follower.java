import java.util.Observable;
import java.util.Observer;

/**
 * Follower class that works as "ConcreteObserver".
 *
 * @author Ziang Lu
 */
public class Follower implements Observer {

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
    public void update(Observable o, Object arg) {
        Tweeter tweeter = (Tweeter) arg;
        System.out.println(name + ": I got an update from " + tweeter.getName() + " about a new tweet: " +
                tweeter.getLatestTweet().getContent());
    }

}
