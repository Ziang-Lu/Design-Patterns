package model.command;

import model.receiver.Printer;

/**
 * Concrete PrintDoc class that works as "ConcreteCommand".
 * This command prints a document using a printer.
 *
 * This class contains a reference to a "Receiver", which is responsible for, in
 * the execute() method, perform some actions and thus handle the request.
 *
 * @author Ziang Lu
 */
public class PrintDoc extends Command {

    /**
     * Reference to the "Receiver", which is responsible for, in th execute()
     * method, perform actions and thus handle the request.
     */
    private final Printer printer;
    /**
     * Document to print.
     * This works as the argument to be used in the execute() method, i.e., the
     * argument to be passed to printer.printDoc() method.
     */
    private final String docToPrint;

    /**
     * Constructor with parameter.
     * @param printer printer to use
     * @param doc document to print
     * @param priority priority of the command
     */
    public PrintDoc(Printer printer, String doc, int priority) {
        super(priority);
        this.printer = printer;
        docToPrint = doc;
        System.out.println(Thread.currentThread().getName() + " A print-document command [Command] has been created");
    }

    @Override
    public void execute() {
        // Let the printer [Receiver] handle this print-document command [Command]
        printer.printDoc(docToPrint);
    }

}
