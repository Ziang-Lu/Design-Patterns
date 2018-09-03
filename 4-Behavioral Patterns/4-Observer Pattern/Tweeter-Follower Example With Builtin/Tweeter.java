import java.util.Observable;

/**
 * Concrete Tweeter class working as "Subject".
 *
 * @author Ziang Lu
 */
public class Tweeter extends Observable {

    /**
     * Name of this tweeter.
     */
    private final String name;

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
     * Writes a new Tweeter.
     */
    public void writeTweeter() {
        System.out.println(name + " -> I wrote a new Tweeter!");
        setChanged();
        notifyObservers();
    }

}
