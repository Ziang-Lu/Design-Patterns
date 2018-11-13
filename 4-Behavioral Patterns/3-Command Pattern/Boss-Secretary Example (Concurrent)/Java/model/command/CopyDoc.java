package model.command;

import model.receiver.Printer;

/**
 * Concrete CopyDoc class that works as "ConcreteCommand".
 * This command copies a document using a printer.
 *
 * This class contains a reference to a "Receiver", which is responsible for, in
 * the execute() method, perform some actions and thus handle the request.
 *
 * @author Ziang Lu
 */
public class CopyDoc extends Command {

    /**
     * Reference to the "Receiver", which is responsible for, in th execute()
     * method, perform actions and thus handle the request.
     */
    private final Printer printer;
    /**
     * Document to copy.
     * This works as the argument to be used in the execute() method, i.e., the
     * argument to be passed to printer.copyDoc() method.
     */
    private final String docToCopy;

    /**
     * Constructor with parameter.
     * @param printer printer to use
     * @param doc document to copy
     * @param priority priority of the command
     */
    public CopyDoc(Printer printer, String doc, int priority) {
        super(priority);
        this.printer = printer;
        docToCopy = doc;
        System.out.println(Thread.currentThread().getName() + " A copy-document command [Command] has been created");
    }

    @Override
    public void execute() {
        // Let the printer [Receiver] handle this copy-document command [Command]
        printer.copyDoc(docToCopy);
    }

}
