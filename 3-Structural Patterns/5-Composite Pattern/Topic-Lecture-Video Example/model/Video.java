package model;

/**
 * Video class working as "Leaf".
 *
 * @author Ziang Lu
 */
public class Video extends Module {

    /**
     * Genre of this module.
     */
    private static final String GENRE = "Video - ";

    /**
     * Constructor with parameter.
     * @param name name of the video
     */
    public Video(String name) {
        super(name);
    }

    @Override
    public void display(String indentLevel) {
        System.out.println(indentLevel + GENRE + name);
    }

}
