package word_app_menu;

/**
 * Concrete CloseCommand class that works as "ConcreteCommand".
 *
 * @author Ziang Lu
 */
class CloseCommand extends WordDocumentCommand {

    /**
     * Default constructor.
     */
    CloseCommand() {
        System.out.println("A open command [Command] has ben created.");
    }

    @Override
    void setDoc(WordDocument doc) {
        System.out.println("Setting the Word document [Receiver] for close command [Command] as " + doc.filename() +
                ".");
        super.setDoc(doc);
    }

    @Override
    void execute() {
        // Let the Word document [Receiver] handle this close command [Command]
        doc.close(this);
    }

}
