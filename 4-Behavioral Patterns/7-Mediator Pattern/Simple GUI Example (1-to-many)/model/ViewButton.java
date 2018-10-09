package model;

import javax.swing.JButton;

/**
 * Concrete ViewButton class that works as "ConcreteColleague".
 *
 * @author Ziang Lu
 */
public class ViewButton extends JButton implements Command {

    /**
     * Mediator for this view button.
     */
    private Mediator mediator;

    /**
     * Constructor with parameter.
     * @param mediator mediator for the view button
     */
    public ViewButton(Mediator mediator) {
        super("View"); // Set the button name
        this.mediator = mediator;
        mediator.register(this);
    }

    @Override
    public void execute() {
        mediator.view();
    }

}
