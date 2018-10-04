package model;

/**
 * Video class that works as one kind of "Leaf".
 *
 * @author Ziang Lu
 */
public class Video extends Module {

    /**
     * Constructor with parameter.
     * @param title title of the video
     */
    public Video(String title) {
        super(title);
    }

    @Override
    public void display(String indentLevel) {
        System.out.println(indentLevel + "Video - " + title);
    }

}
