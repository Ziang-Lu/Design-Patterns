package restaurant;

/**
 * Waiter class that works as "Invoker".
 * This class is responsible for executing the different "Command"s.
 *
 * @author Ziang Lu
 */
public class Waiter {

    /**
     * Executes the given command.
     * The "Invoker" does not know how to handle the request, but simply invoke
     * command.execute() method, and let the internal correct "Receiver" handle
     * the request.
     * @param command command to execute
     */
    public void executeCommand(Command command) {
        System.out.println("Waiter [Invoker] has received the command [Command] and start executing the command " +
                "[Command] ...");
        command.execute();
    }

}
