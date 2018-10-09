package model;

/**
 * Concrete SearchButton class that works as "ConcreteColleague".
 *
 * @author Ziang Lu
 */
public class SearchButton extends Command {

    /**
     * Constructor with parameter.
     * @param mediator mediator for the search button
     */
    public SearchButton(Mediator mediator) {
        super("Search", mediator);
    }

    @Override
    public void execute() {
        mediator.search();
    }

}
