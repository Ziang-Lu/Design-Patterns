package model;

import javax.swing.JButton;

/**
 * Abstract Command class that acts as "Colleague".
 * When a "Colleague" object needs to communicate to another "Colleague" object,
 * it does not directly call on the other "Colleague" object; instead, it calls
 * the "Mediator" object whose main duty is to control and coordinate the
 * communication between "Colleague" objects.
 * In this way, the communication complexity between the "Colleague" objects are
 * greatly reduced.
 *
 * @author Ziang Lu
 */
public abstract class Command extends JButton {

    /**
     * Mediator of this command.
     */
    private Mediator mediator;

    /**
     * Constructor with parameter.
     * @param name name of the button
     * @param mediator mediator for the command
     */
    protected Command(String name, Mediator mediator) {
        super(name); // Set the button name
        this.mediator = mediator;
        mediator.register(this);
    }

    /**
     * Executes this command.
     */
    public abstract void execute();

}
