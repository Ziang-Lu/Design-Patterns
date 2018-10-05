package observer;

import subject.Subject;

/**
 * Abstract Observer interface.
 *
 * @author Ziang Lu
 */
public interface Observer {

    /**
     * Gets notified with an update from some subject.
     * @param subject subject whose state changes
     */
    void update(Subject subject);

}
