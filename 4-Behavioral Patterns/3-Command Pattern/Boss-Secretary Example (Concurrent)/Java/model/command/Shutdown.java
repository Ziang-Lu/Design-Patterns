package model.command;

/**
 * Concrete Shutdown class that works as "ConcreteCommand".
 * This special command works as an indicator to shut down the secretary thread.
 *
 * @author Ziang Lu
 */
public class Shutdown extends Command {

    /**
     * Constructor with parameter.
     * @param priority priority priority of the command
     */
    public Shutdown(int priority) {
        super(priority);
    }

    @Override
    public void execute() {}

}
