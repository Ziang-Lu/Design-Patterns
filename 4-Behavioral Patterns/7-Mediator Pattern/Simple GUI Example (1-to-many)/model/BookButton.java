package model;

/**
 * Concrete BookButton class that works as "ConcreteColleague".
 *
 * @author Ziang Lu
 */
public class BookButton extends Command {

    /**
     * Constructor with parameter.
     * @param mediator mediator for the book button
     */
    public BookButton(Mediator mediator) {
        super("Book", mediator);
    }

    @Override
    public void execute() {
        mediator.book();
    }

}
