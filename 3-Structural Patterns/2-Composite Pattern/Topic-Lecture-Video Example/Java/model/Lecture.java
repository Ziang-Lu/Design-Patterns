package model;

/**
 * Lecture class that works as one kind of "Leaf".
 *
 * @author Ziang Lu
 */
public class Lecture extends Module {

    /**
     * Constructor with parameter.
     * @param title title of the lecture
     */
    public Lecture(String title) {
        super(title);
    }

    @Override
    public void display(String indentLevel) {
        System.out.println(indentLevel + "Lecture- " + title);
    }

}
