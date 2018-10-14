package friend;

/**
 * Tape class that works as "Adaptee".
 *
 * By comparing the signatures of stickOut() method and the Eraser.erase()
 * method, we can find that this class and the Eraser are independent or
 * incompatible systems.
 *
 * @author Ziang Lu
 */
public class Tape {

    /**
     * Sticks out the given text.
     * @param text text to stick out
     */
    public void stickOut(String text) {
        System.out.println("'" + text + "' is stuck out by Tape.");
    }

}
