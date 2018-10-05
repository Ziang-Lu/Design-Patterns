package text_editor;

/**
 * TextEditor class that works as "Originator".
 *
 * @author Ziang Lu
 */
public class TextEditor {

    /**
     * Memento class.
     * This class holds a snapshot of the internal state of the "Originator".
     * This is like a wrapper (a packing box) for the internal state of the
     * "Originator" to be stored.
     */
    private static class Memento implements IMemento {
        /**
         * Stored text.
         */
        private String text;

        /**
         * Constructor with parameter.
         * @param text text to store
         */
        Memento(String text) {
            this.text = text;
        }

        /**
         * Accessor of text.
         * @return text
         */
        String getText() {
            return text;
        }

        @Override
        public String toString() {
            return "Memento [text=" + text + "]";
        }
    }

    /**
     * Current text in this text editor.
     */
    private String text = "";

    /**
     * Mutator of text.
     * @param text text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Creates a memento containing a snapshot of the internal state of this
     * text editor.
     * @return created memento
     */
    public Memento createMemento() {
        Memento memo = new Memento(text);
        System.out.println("Created a memento for TextEditor: " + memo);
        return memo;
    }

    /**
     * Restores the internal state of this text editor from the given memento.
     * @param memo memento to restore from
     */
    public void restore(IMemento memo) {
        Memento memento = (Memento) memo;
        text = memento.getText();
    }

    @Override
    public String toString() {
        return "TextEditor{text=" + text + "}";
    }

}
