package model;

import javax.swing.JButton;

/**
 * Concrete BookButton class that works as "ConcreteColleague".
 *
 * @author Ziang Lu
 */
public class BookButton extends JButton implements Command {

    /**
     * Mediator for this book button.
     */
    private Mediator mediator;

    /**
     * Constructor with parameter.
     * @param mediator mediator for the book button
     */
    public BookButton(Mediator mediator) {
        super("Book"); // Set the button name
        this.mediator = mediator;
        mediator.register(this);
    }

    @Override
    public void execute() {
        mediator.book();
    }

}
