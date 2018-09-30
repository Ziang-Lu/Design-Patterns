package subject;

import observer.Observer;

import java.util.HashSet;
import java.util.Set;

/**
 * Abstract Subject class.
 *
 * @author Ziang Lu
 */
public abstract class Subject {

    /**
     * Observers of this subject.
     */
    protected final Set<Observer> myObservers = new HashSet<>();

    /**
     * Registers a new observer.
     * @param observer new observer to register
     */
    public void register(Observer observer) {
        myObservers.add(observer);
    }

    /**
     * Unregisters the given observer.
     * @param observer observer to unregister
     */
    public void unregister(Observer observer) {
        myObservers.remove(observer);
    }

    /**
     * Notifies all observers about a state change.
     */
    protected abstract void notifyObservers();

}
