import java.util.HashSet;
import java.util.Set;

/**
 * Abstract Subject class.
 *
 * @author Ziang Lu
 */
public abstract class Subject {

    /**
     * Name of this subject.
     */
    protected final String name;
    /**
     * Observers of this subject.
     */
    protected final Set<Observer> myObservers;

    /**
     * Cosntructor with parameter.
     * @param name name of the subject
     */
    public Subject(String name) {
        this.name = name;
        myObservers = new HashSet<Observer>();
    }

    /**
     * Adds a new observer.
     * @param observer observer to add
     */
    public void addObserver(Observer observer) {
        myObservers.add(observer);
    }

    /**
     * Notifies all observers about an update.
     */
    protected abstract void notifyObservers();

}
