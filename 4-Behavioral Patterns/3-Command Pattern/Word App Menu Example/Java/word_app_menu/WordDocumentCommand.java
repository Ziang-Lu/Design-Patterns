package word_app_menu;

/**
 * Abstract WordDocumentCommand class that works as "Command".
 * This abstract class represents a request, and defines only one execute()
 * method, which executes this command; this abstract class also contains a
 * reference to a "Receiver", which is responsible for, in the execute() method,
 * perform some actions and thus handle the request.
 *
 * @author Ziang Lu
 */
abstract class WordDocumentCommand {

    /**
     * Reference to the "Receiver", which is responsible for, in the execute()
     * method, perform some actions and thus handle the request.
     */
    protected WordDocument doc;

    /**
     * Mutator of doc.
     * @param doc doc to set
     */
    void setDoc(WordDocument doc) {
        this.doc = doc;
    }

    /**
     * Executes this command.
     * We let the receiver perform some actions and thus handle the request.
     */
    abstract void execute();

}
