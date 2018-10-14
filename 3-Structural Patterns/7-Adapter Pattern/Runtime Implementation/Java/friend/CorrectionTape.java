package friend;

/**
 * CorrectionTape class that works as "Adaptee".
 *
 * By comparing the signatures of dashOut() method and the Eraser.erase()
 * method, we can find that this class and the Eraser are independent or
 * incompatible systems.
 *
 * @author Ziang Lu
 */
public class CorrectionTape {

    /**
     * Dashes out the given text.
     * @param text text to dash out
     */
    public void dashOut(String text) {
        System.out.println("'" + text + "' is dashed out by Correction Tape.");
    }

}
