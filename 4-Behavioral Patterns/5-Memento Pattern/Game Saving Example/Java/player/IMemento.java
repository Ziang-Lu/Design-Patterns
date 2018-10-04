package player;

/**
 * IMemento interface that works as a mark interface for "Memento".
 * In this way, all classes other than the "Originator" can only access
 * "Memento" objects through this mark interface, so they will know nothing
 * about the actual "Memento" objects.
 *
 * @author Ziang Lu
 */
public interface IMemento {}
