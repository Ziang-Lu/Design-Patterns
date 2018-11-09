package word_app_menu;

/**
 * Concrete OpenCommand class that works as "ConcreteCommand".
 *
 * @author Ziang Lu
 */
class OpenCommand extends WordDocumentCommand {

    /**
     * Default constructor.
     */
    OpenCommand() {
        System.out.println("An open command [Command] has ben created.");
    }

    @Override
    void setDoc(WordDocument doc) {
        System.out.println("Setting the Word document [Receiver] for open command [Command] as " + doc.filename() +
                ".");
        super.setDoc(doc);
    }

    @Override
    void execute() {
        // Let the Word document [Receiver] handle this open command [Command]
        doc.open(this);
    }

}
