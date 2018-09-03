package model;

/**
 * Abstract Module class working as "Component".
 *
 * @author Ziang Lu
 */
public abstract class Module {

    /**
     * Name of this module.
     */
    protected final String name;

    /**
     * Constructor with parameter.
     * @param name name of the module
     */
    protected Module(String name) {
        this.name = name;
    }

    /**
     * Displays this module.
     * @param indentLevel indent level
     */
    public abstract void display(String indentLevel);

}
