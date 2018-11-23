package model.receiver;

import java.util.Random;

/**
 * EmailBox class that works as the "Receiver".
 *
 * This class is implemented as a singleton class.
 *
 * @author Ziang Lu
 */
public class EmailBox {

    /**
     * Singleton instance.
     */
    private volatile static EmailBox instance = null;

    /**
     * Gets the singleton instance.
     * This implementation utilizes Lazy Initialization Pattern and double-check
     * locking mechanism.
     * @return singleton instance
     */
    public static EmailBox getInstance() {
        EmailBox localRef = instance;
        if (localRef == null) {
            synchronized (EmailBox.class) {
                if (localRef == null) {
                    instance = localRef = new EmailBox();
                }
            }
        }
        return localRef;
    }

    /**
     * Private default constructor.
     * This has to be private so that the class instances cannot be created
     * outside of the class.
     */
    private EmailBox() {}

    /**
     * Sends the given message to the given recipient.
     * @param recipientEmail email address of the recipient
     * @param msg message to send
     */
    public void sendEmail(String recipientEmail, String msg) {
        try {
            Thread.sleep((new Random().nextInt(8) + 1) * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " <Email Box> has sent '" + msg + "' to " +
                recipientEmail);
    }

}
