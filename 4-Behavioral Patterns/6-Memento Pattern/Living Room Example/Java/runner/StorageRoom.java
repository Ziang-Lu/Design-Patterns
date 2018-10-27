package runner;

import java.util.HashMap;
import java.util.Map;

/**
 * StorageRoom class that works as "Caretaker" that actually uses Memento
 * Pattern.
 * This class is responsible for keeping a collection of "Memento", but never
 * examines or operates on the contents of a "Memento".
 *
 * @author Ziang Lu
 */
public class StorageRoom {

    /**
     * Stored mapping between tags and the corresponding mementos.
     */
    private Map<String, IMemento> memoMap = new HashMap<>();

    /**
     * Gets the memento associated with the given tag from this storage room.
     * @param tag tag associated with the memento to get
     * @return corresponding memento
     */
    private IMemento getMemento(String tag) {
        return memoMap.get(tag);
    }

    /**
     * Stores the given memento associated with the given tag in this storage
     * room.
     * @param tag tag associated with the memento to store
     * @param memo memento to store
     */
    private void addMemento(String tag, IMemento memo) {
        memoMap.put(tag, memo);
    }

}
