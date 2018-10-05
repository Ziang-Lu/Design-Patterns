package runner;

import text_editor.IMemento;
import text_editor.TextEditor;

import java.util.ArrayList;
import java.util.List;

/**
 * TextEditorApp class that works as "Caretaker" that actually uses Memento
 * Pattern.
 * This class is responsible for keeping a collection of "Memento", but never
 * examines or operates on the contents of a "Memento".
 *
 * @author Ziang Lu
 */
public class TextEditorApp {

    /**
     * Text editor of this application.
     */
    private TextEditor textEditor = new TextEditor();
    /**
     * Stored mementos.
     */
    private List<IMemento> mementoList = new ArrayList<>();
    /**
     * Pointer to the last saved state.
     */
    private int lastSavedPtr = -1;

    /**
     * Writes the given text to the text editor.
     * @param text text to write
     */
    public void write(String text) {
        textEditor.setText(text);
        System.out.println("After writing '" + text + "': " + textEditor);
    }

    /**
     * Saves the current state of the text editor.
     */
    public void save() {
        addMemento(textEditor.createMemento());
        lastSavedPtr = mementoList.size() - 1;
    }

    /**
     * Private helper method to store given memento.
     * @param memo memento to store
     */
    private void addMemento(IMemento memo) {
        mementoList.add(memo);
    }

    /**
     * Undo the most recent change in the text editor.
     */
    public void undo() {
        if (lastSavedPtr <= 0) {
            System.out.println("No more undo operation available!");
            return;
        }
        System.out.print("Undo operation... ");
        --lastSavedPtr;
        IMemento prevState = getMemento(lastSavedPtr);
        textEditor.restore(prevState);
        System.out.println(textEditor);
    }

    /**
     * Private helper method to get the memento at the given index.
     * @param idx index of the memento
     */
    private IMemento getMemento(int idx) {
        return mementoList.get(idx);
    }

    /**
     * Redoes the most recent change in the text editor.
     */
    public void redo() {
        if (lastSavedPtr >= (mementoList.size() - 1)) {
            System.out.println("No more redo operation available!");
            return;
        }
        System.out.print("Redo operation...");
        ++lastSavedPtr;
        IMemento nextState = getMemento(lastSavedPtr);
        textEditor.restore(nextState);
        System.out.println(textEditor);
    }

}
