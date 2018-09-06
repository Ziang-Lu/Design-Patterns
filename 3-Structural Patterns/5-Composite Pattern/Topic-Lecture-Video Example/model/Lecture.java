package model;

/**
 * Lecture class working as "Leaf".
 *
 * @author Ziang Lu
 */
public class Lecture extends Module {

    /**
     * Genre of this module.
     */
    private static final String GENRE = "Lecture - ";

    /**
     * Constructor with parameter.
     * @param name name of the lecture
     */
    public Lecture(String name) {
        super(name);
    }

    @Override
    public void display(String indentLevel) {
        System.out.println(indentLevel + GENRE + name);
    }

}
