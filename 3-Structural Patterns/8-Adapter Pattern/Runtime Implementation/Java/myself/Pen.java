package myself;

/**
 * Abstract Pen interface that works as "Target".
 *
 * By comparing the signatures of write() method and the
 * InkPen.ink()/PilotPen.mark() method, we can find that this interface and the
 * InkPen/PilotPen are independent or incompatible systems.
 *
 * @author Ziang Lu
 */
public interface Pen {

    /**
     * Writes the given text using this pen.
     * @param text text to write
     */
    void write(String text);

}
