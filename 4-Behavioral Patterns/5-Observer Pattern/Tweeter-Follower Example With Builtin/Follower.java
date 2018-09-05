import java.util.Observable;
import java.util.Observer;

/**
 * Concrete Follower class working as "Observer".
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
        System.out.println(name + ": I got an update!");
    }

}
