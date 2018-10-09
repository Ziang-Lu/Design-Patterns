package model;

import javax.swing.JButton;

/**
 * Concrete SearchButton class that works as "ConcreteColleague".
 *
 * @author Ziang Lu
 */
public class SearchButton extends JButton implements Command {

    /**
     * Mediator for this search button.
     */
    private Mediator mediator;

    /**
     * Constructor with parameter.
     * @param mediator mediator for the search button
     */
    public SearchButton(Mediator mediator) {
        super("Search"); // Set the button name
        this.mediator = mediator;
        mediator.register(this);
    }

    @Override
    public void execute() {
        mediator.search();
    }
}
