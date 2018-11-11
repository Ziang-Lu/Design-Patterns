package model.receiver;

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
        if (instance == null) {
            synchronized (EmailBox.class) {
                if (instance == null) {
                    instance = new EmailBox();
                }
            }
        }
        return instance;
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
        System.out.println("<Email Box> is sending '" + msg + "' to " + recipientEmail);
    }

}
