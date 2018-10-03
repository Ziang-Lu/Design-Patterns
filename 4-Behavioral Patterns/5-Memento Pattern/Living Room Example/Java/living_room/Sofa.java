package living_room;

/**
 * Sofa class.
 *
 * @author Ziang Lu
 */
public class Sofa implements Cloneable {

    /**
     * Size of this sofa in number of people.
     */
    private int size;
    /**
     * Style of this sofa.
     */
    private String style;

    /**
     * Constructor with parameter.
     * @param size size of the sofa
     * @param style style of the sofa
     */
    public Sofa(int size, String style) {
        this.size = size;
        this.style = style;
    }

    @Override
    public Sofa clone() throws CloneNotSupportedException {
        return (Sofa) super.clone();
    }

    @Override
    public String toString() {
        return "Sofa{size=" + size + ", style= " + style + "}";
    }

}
