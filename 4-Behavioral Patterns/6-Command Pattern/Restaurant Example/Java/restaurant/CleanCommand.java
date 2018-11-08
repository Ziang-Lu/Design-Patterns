package restaurant;

/**
 * Concrete CleanCommand class that works as "ConcreteCommand".
 * This class contains a reference to a "Receiver", which is responsible for, in
 * the execute() method, perform some actions and thus handle the request.
 *
 * @author Ziang Lu
 */
class CleanCommand implements Command {

    /**
     * Reference to the "Receiver", which is responsible for, in the execute()
     * method, perform some actions and thus handle the request.
     */
    private final Cleaner cleaner;

    /**
     * Constructor with parameter.
     * @param cleaner cleaner to eventually handle this clean command
     */
    CleanCommand(Cleaner cleaner) {
        this.cleaner = cleaner;
        System.out.println("A new clean command [Command] has been created.");
    }

    @Override
    public void execute() {
        // Let the cleaner [Receiver] handle this clean command [Command]
        cleaner.cleanTable();
    }

}
