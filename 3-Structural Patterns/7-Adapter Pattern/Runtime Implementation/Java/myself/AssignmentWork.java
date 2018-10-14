package myself;

/**
 * AssignmentWork class.
 *
 * @author Ziang Lu
 */
public class AssignmentWork {

    /**
     * Pen used to do this assignment.
     */
    private Pen pen;
    /**
     * Eraser used for this assignment.
     */
    private Eraser eraser;

    /**
     * Mutator of pen.
     * @param pen pen to use
     */
    void setPen(Pen pen) {
        this.pen = pen;
    }

    /**
     * Mutator of eraser.
     * @param eraser eraser to use
     */
    void setEraser(Eraser eraser) {
        this.eraser = eraser;
    }

    /**
     * Does this assignment by writing the given text.
     * @param text text to write
     */
    void doAssignment(String text) {
        pen.write(text);
    }

    /**
     * Erases the given text in this assignment.
     * @param text text to erase
     */
    void eraseAssignment(String text) {
        eraser.erase(text);
    }

}
