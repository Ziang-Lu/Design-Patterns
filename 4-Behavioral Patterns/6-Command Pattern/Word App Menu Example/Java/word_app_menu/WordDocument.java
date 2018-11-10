package word_app_menu;

/**
 * WordDocument class that works as the "Receiver" for "WordDocumentCommand".
 *
 * @author Ziang Lu
 */
public class WordDocument {

    /**
     * Filename of this Word document.
     */
    private final String filename;

    /**
     * Constructor with parameter.
     * @param filename filename of the Word document
     */
    public WordDocument(String filename) {
        this.filename = filename;
    }

    /**
     * Accessor of filename.
     * @return filename
     */
    String filename() {
        return filename;
    }

    /**
     * Opens this Word document.
     */
    void open() {
        System.out.println(filename + " has been opened.");
    }

    /**
     * Saves this Word document.
     */
    void save() {
        System.out.println(filename + " has been saved.");
    }

    /**
     * Closes this Word document.
     */
    void close() {
        System.out.println(filename + " has been closed.");
    }

}
