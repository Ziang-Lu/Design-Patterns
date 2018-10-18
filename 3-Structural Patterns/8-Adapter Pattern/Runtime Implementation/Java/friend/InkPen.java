package friend;

/**
 * InkPen class that works as "Adaptee".
 *
 * By comparing the signatures of ink() method and the Pen.write() method, we
 * can find that this class and the Pen are independent or incompatible systems.
 *
 * @author Ziang Lu
 */
public class InkPen {

    /**
     * Inks the given text.
     * @param text text to ink
     */
    public void ink(String text) {
        System.out.println("'" + text + "' is written in Ink Pen.");
    }

}
