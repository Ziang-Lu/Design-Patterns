package model.receiver;

/**
 * Printer class that works as the "Receiver".
 *
 * @author Ziang Lu
 */
public class Printer {

    /**
     * Prints the given document.
     * @param doc document to print
     */
    public void printDoc(String doc) {
        System.out.println("<Printer> is printing " + doc);
    }

    /**
     * Copies the given document.
     * @param doc document to copy
     */
    public void copyDoc(String doc) {
        System.out.println("<Printer> is copying " + doc);
    }

}
