package model;

/**
 * Abstract Choice class working as "Component".
 * Note that this implementation uses Design-for-Type-Safety, i.e., defining
 * child-related operations only in "Composite"
 *
 * @author Ziang Lu
 */
public interface Choice {

    /**
     * Prints a prompt message of this choice.
     */
    void printChoiceMessage();

}
