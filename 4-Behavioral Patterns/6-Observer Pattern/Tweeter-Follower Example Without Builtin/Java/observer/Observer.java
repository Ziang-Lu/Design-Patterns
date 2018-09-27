package observer;

import subject.Subject;

/**
 * Abstract Observer interface.
 *
 * @author Ziang Lu
 */
public abstract class Observer {

    /**
     * Gets notified with an update from some subject.
     * @param subject subject whose state changes
     */
    public abstract void update(Subject subject);

}
