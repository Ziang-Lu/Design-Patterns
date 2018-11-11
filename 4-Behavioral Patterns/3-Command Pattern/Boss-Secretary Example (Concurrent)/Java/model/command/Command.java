package model.command;

/**
 * Command interface that works as "Command".
 * This interface represents a request, and defines only one execute()
 * method, which executes this command.
 *
 * @author Ziang Lu
 */
public interface Command {

    /**
     * Executes this command.
     */
    void execute();

}
