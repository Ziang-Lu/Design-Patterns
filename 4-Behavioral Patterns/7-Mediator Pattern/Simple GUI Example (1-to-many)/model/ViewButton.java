package model;

/**
 * Concrete ViewButton class that works as "ConcreteColleague".
 *
 * @author Ziang Lu
 */
public class ViewButton extends Command {

    /**
     * Constructor with parameter.
     * @param mediator mediator for the view button
     */
    public ViewButton(Mediator mediator) {
        super("View", mediator);
    }

    @Override
    public void execute() {
        mediator.view();
    }

}
