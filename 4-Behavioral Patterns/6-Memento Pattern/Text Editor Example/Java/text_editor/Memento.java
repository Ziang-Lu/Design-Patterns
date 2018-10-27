package text_editor;

/**
 * Memento class.
 * This class holds a snapshot of the internal state of the "Originator".
 * This is like a wrapper (a packing box) for the internal state of the
 * "Originator" to be stored.
 */
public class Memento {

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
    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Memento [text=" + text + "]";
    }

}
