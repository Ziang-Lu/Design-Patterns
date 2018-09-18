package model;

/**
 * Abstract Module class that works as "Component".
 * Note that this implementations uses Design-for-Type-Safety, i.e., defining
 * child-related operations only in "Composite"
 *
 * @author Ziang Lu
 */
public abstract class Module {

    /**
     * Name of this module.
     */
    protected final String title;

    /**
     * Constructor with parameter.
     * @param title title of the module
     */
    protected Module(String title) {
        this.title = title;
    }

    /**
     * Displays this module.
     * @param indentLevel indent level
     */
    public abstract void display(String indentLevel);

}
