package school;

import visitor.SchoolVisitor;

/**
 * Abstract Visitable interface that works as "Element/Visitable".
 * This class represents an element in the object structure, and can be visited
 * by a "Visitor", so that the "Visitor" can perform algorithm (handle
 * operation) on this "Element".
 *
 * @author Ziang Lu
 */
public interface Visitable {

    /**
     * Accepts the given visitor and lets it perform algorithm (handle
     * operation) on this "Element".
     * In this way, we can change the executing algorithm (operation) on this
     * "Element" by simply varying the visitor object.
     * @param visitor given visitor
     */
    void accept(SchoolVisitor visitor);

}
