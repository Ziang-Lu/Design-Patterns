package runner;

import text_editor.Caretaker;
import text_editor.Memento;
import text_editor.TextEditor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * TextEditorApp class that works as "Caretaker" that actually uses Memento
 * Pattern.
 * This class is responsible for keeping a collection of "Memento", but never
 * examines or operates on the contents of a "Memento".
 *
 * @author Ziang Lu
 */
public class TextEditorApp extends JFrame {

    /**
     * Text editor of this application.
     */
    private TextEditor textEditor = new TextEditor(5, 10);
    /**
     * Caretaker that stores all the mementos.
     */
    private Caretaker caretaker = new Caretaker();
    /**
     * Pointer to the last saved state.
     */
    private int prevStatePtr = -1;

    /**
     * Default constructor.
     */
    public TextEditorApp() {
        // Set the basic information for this frame
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Memento Pattern demo");

        // Save for the initial empty text
        save();

        JPanel panel = new JPanel();
        panel.add(new JLabel("Text:"));
        panel.add(textEditor.getTextField());

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener((e) -> { // Java lambda expression in place of anonymous class
            if (e.getSource() == saveButton) {
                save();
            }
        });
        panel.add(saveButton);

        JButton undoButton = new JButton("Undo");
        undoButton.addActionListener((e) -> {
            if (e.getSource() == undoButton) {
                undo();
            }
        });
        panel.add(undoButton);

        JButton redoButton = new JButton("Redo");
        redoButton.addActionListener((e) -> {
            if (e.getSource() == redoButton) {
                redo();
            }
        });
        panel.add(redoButton);

        add(panel);

        // Display this frame
        setVisible(true);
    }

    /**
     * Saves the current state of the text editor.
     */
    private void save() {
        caretaker.addMemento(textEditor.createMemento());
        prevStatePtr = caretaker.getLastMementoPtr();
    }

    /**
     * Undo the most recent change in the text editor.
     */
    private void undo() {
        if (!textEditor.getText().equals(caretaker.getMemento(prevStatePtr).getText())) {
            Memento lastSavedState = caretaker.getMemento(prevStatePtr);
            textEditor.restore(lastSavedState);
        } else if (prevStatePtr <= 0) {
            System.out.println("No more undo operation available!");
        } else {
            --prevStatePtr;
            Memento prevState = caretaker.getMemento(prevStatePtr);
            textEditor.restore(prevState);
        }
    }

    /**
     * Redoes the most recent change in the text editor.
     */
    private void redo() {
        if (prevStatePtr >= caretaker.getLastMementoPtr()) {
            System.out.println("No more redo operation available!");
            return;
        }
        ++prevStatePtr;
        Memento nextState = caretaker.getMemento(prevStatePtr);
        textEditor.restore(nextState);
    }

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        new TextEditorApp();
    }

}
