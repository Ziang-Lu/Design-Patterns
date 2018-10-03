package model;

/**
 * Sofa class.
 *
 * @author Ziang Lu
 */
public class Sofa {

    /**
     * Size of this sofa in number of people.
     */
    private int size;

    /**
     * Constructor with parameter.
     * @param size size of the sofa
     */
    public Sofa(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Sofa{size=" + size + "}";
    }

}
