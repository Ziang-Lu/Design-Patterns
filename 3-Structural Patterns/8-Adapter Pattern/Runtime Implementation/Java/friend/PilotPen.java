package friend;

/**
 * PilotPen class that works as "Adaptee".
 *
 * By comparing the signatures of mark() method and the Pen.write() method, we
 * can find that this class and the Pen are independent or incompatible systems.
 *
 * @author Ziang Lu
 */
public class PilotPen {

    /**
     * Marks the given text.
     * @param text text to mark
     */
    public void mark(String text) {
        System.out.println("'" + text + "' is written in Pilot Pen.");
    }

}
