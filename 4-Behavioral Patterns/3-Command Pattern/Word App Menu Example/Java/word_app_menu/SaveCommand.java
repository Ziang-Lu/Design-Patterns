package word_app_menu;

/**
 * Concrete SaveCommand class that works as "ConcreteCommand".
 * This command saves a Word document.
 *
 * @author Ziang Lu
 */
class SaveCommand extends WordDocumentCommand {

    /**
     * Default constructor.
     */
    SaveCommand() {
        System.out.println("A save command [Command] has been created.");
    }

    @Override
    void setDoc(WordDocument doc) {
        System.out.println("Setting the Word document [Receiver] for save command [Command] as " + doc.filename() +
                ".");
        super.setDoc(doc);
    }

    @Override
    void execute() {
        // Let the Word document [Receiver] handle this save command [Command]
        doc.save();
    }

}
