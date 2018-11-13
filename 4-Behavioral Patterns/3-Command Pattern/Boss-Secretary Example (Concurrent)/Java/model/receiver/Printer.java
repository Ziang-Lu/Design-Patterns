package model.receiver;

import java.util.Random;

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
        try {
            Thread.sleep((new Random().nextInt(8) + 1) * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " <Printer> has printed " + doc);
    }

    /**
     * Copies the given document.
     * @param doc document to copy
     */
    public void copyDoc(String doc) {
        try {
            Thread.sleep((new Random().nextInt(8) + 1) * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " <Printer> has copied " + doc);
    }

}
