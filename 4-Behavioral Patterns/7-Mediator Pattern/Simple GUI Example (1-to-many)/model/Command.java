package model;

/**
 * Abstract Command interface that acts as "Colleague".
 * When a "Colleague" object needs to communicate to another "Colleague" object,
 * it does not directly call on the other "Colleague" object; instead, it calls
 * the "Mediator" object whose main duty is to control and coordinate the
 * communication between "Colleague" objects.
 * In this way, the communication complexity between the "Colleague" objects are
 * greatly reduced.
 *
 * @author Ziang Lu
 */
public interface Command {

    /**
     * Executes this command.
     */
    void execute();

}
