package model;

import java.util.HashMap;
import java.util.Map;

/**
 * StorageRoom class that works as "Caretaker".
 * This class is responsible for keeping a collection of "Memento", but never
 * examines or operates on the contents of a "Memento".
 *
 * @author Ziang Lu
 */
public class StorageRoom {

    /**
     * Stored mapping between tags and the corresponding mementos.
     */
    private Map<String, Memento> mementos = new HashMap<>();

    /**
     * Gets the memento associated with the given tag from this storage room.
     * @param tag tag associated with the memento to get
     * @return corresponding memento
     */
    Memento getMemento(String tag) {
        return mementos.get(tag);
    }

    /**
     * Stores the given memento associated with the given tag to this storage
     * room.
     * @param tag tag associated with the memento to store
     * @param memento memento to store
     */
    void addMemento(String tag, Memento memento) {
        mementos.put(tag, memento);
    }

}
