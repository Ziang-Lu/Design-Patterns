package word_app_menu;

import java.util.ArrayList;
import java.util.List;

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
     * Command history on this Word document.
     */
    private List<WordDocumentCommand> commandHistory;

    /**
     * Constructor with parameter.
     * @param filename filename of the Word document
     */
    public WordDocument(String filename) {
        this.filename = filename;
        commandHistory = new ArrayList<>();
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
     * @param openCommand command to open this Word document
     */
    void open(OpenCommand openCommand) {
        System.out.println(filename + " has been opened.");
        commandHistory.add(openCommand);
    }

    /**
     * Saves this Word document.
     * @param saveCommand command to save this Word document
     */
    void save(SaveCommand saveCommand) {
        System.out.println(filename + " has been saved.");
        commandHistory.add(saveCommand);
    }

    /**
     * Closes this Word document.
     * @param closeCommand command to close this Word document
     */
    void close(CloseCommand closeCommand) {
        System.out.println(filename + " has been closed.");
        commandHistory.add(closeCommand);
    }

    /**
     * Prints the command history on this Word document.
     */
    public void printCommandHistory() {
        System.out.println("Command history on " + filename + ":");
        for (WordDocumentCommand command : commandHistory) {
            System.out.println(command);
        }
    }

}
