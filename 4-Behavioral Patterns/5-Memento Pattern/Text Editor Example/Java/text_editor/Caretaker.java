package text_editor;

import java.util.ArrayList;
import java.util.List;

public class Caretaker {

    /**
     * Stored mementos.
     */
    private List<Memento> mementoList = new ArrayList<>();

    /**
     * Gets the memento at the given index.
     * @param idx index of the memento
     * @return corresponding memento
     */
    public Memento getMemento(int idx) {
        return mementoList.get(idx);
    }

    /**
     * Gets the pointer to the last saved memento.
     * @return pointer to the last memento
     */
    public int getLastMementoPtr() {
        return mementoList.size() - 1;
    }

    /**
     * Stores the given memento.
     * @param memo memento to store
     */
    public void addMemento(Memento memo) {
        mementoList.add(memo);
    }

}
