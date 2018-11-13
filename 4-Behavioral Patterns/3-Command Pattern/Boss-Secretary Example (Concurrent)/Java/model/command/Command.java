package model.command;

/**
 * Command interface that works as "Command".
 * This interface represents a request, and defines only one execute()
 * method, which executes this command.
 *
 * @author Ziang Lu
 */
public abstract class Command implements Comparable<Command> {

    /**
     * Priority of this command.
     */
    private int priority;

    /**
     * Constructor with parameter.
     * @param priority priority of the command
     */
    protected Command(int priority) {
        this.priority = priority;
    }

    /**
     * Executes this command.
     */
    public abstract void execute();

    @Override
    public int compareTo(Command o) {
        return Integer.compare(priority, o.priority);
    }

}
