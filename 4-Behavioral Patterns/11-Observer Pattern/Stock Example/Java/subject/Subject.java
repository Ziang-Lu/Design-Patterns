package subject;

import observer.Observer;

import java.lang.ref.WeakReference;
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
    protected final Set<WeakReference<Observer>> myObservers = new HashSet<>();

    /**
     * Registers a new observer.
     * @param observer new observer to register
     */
    public void register(Observer observer) {
        myObservers.add(new WeakReference<>(observer));
    }

    /**
     * Unregisters the given observer.
     * @param observer observer to unregister
     */
    public void unregister(Observer observer) {
        WeakReference<Observer> toRemove = null;
        for (WeakReference<Observer> weakRef : myObservers) {
            if (weakRef.get() == observer) {
                toRemove = weakRef;
                break;
            }
        }
        myObservers.remove(toRemove);
    }

    /**
     * Notifies all observers about a state change.
     */
    protected abstract void notifyObservers();

}
