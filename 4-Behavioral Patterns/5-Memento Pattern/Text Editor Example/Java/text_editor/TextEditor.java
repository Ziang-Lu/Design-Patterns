package text_editor;

import javax.swing.JTextArea;

/**
 * TextEditor class that works as "Originator".
 *
 * @author Ziang Lu
 */
public class TextEditor {

    /**
     * Current text in this text editor.
     */
    private JTextArea textField;

    /**
     * Constructor with parameter.
     * @param rows number of rows for the text field
     * @param cols number of columns for the text field
     */
    public TextEditor(int rows, int cols) {
        textField = new JTextArea(rows, cols);
    }

    /**
     * Accessor of text.
     * @return text
     */
    public String getText() {
        return textField.getText();
    }

    /**
     * Accessor of textField.
     * @return text field
     */
    public JTextArea getTextField() {
        return textField;
    }

    /**
     * Creates a memento containing a snapshot of the internal state of this
     * text editor.
     * @return created memento
     */
    public Memento createMemento() {
        Memento memo = new Memento(textField.getText());
        System.out.println("Created a memento for TextEditor: " + memo);
        return memo;
    }

    /**
     * Restores the internal state of this text editor from the given memento.
     * @param memo memento to restore from
     */
    public void restore(Memento memo) {
        textField.setText(memo.getText());
    }

    @Override
    public String toString() {
        return "TextEditor{text=" + textField.getText() + "}";
    }

}
