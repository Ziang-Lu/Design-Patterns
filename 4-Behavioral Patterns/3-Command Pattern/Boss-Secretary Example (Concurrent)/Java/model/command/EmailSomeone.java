package model.command;

import model.receiver.EmailBox;

/**
 * Concrete EmailSomeone class that works as "ConcreteCommand".
 * This command emails someone using a email box.
 *
 * This class contains a reference to a "Receiver", which is responsible for, in
 * the execute() method, perform some actions and thus handle the request.
 *
 * @author Ziang Lu
 */
public class EmailSomeone implements Command {

    /**
     * Reference to the "Receiver", which is responsible for, in th execute()
     * method, perform actions and thus handle the request.
     */
    private final EmailBox emailBox;
    /**
     * Email address of the recipient.
     * This works as the argument to be used in the execute() method, i.e., the
     * argument to be passed to emailBox.sendEmail() method.
     */
    private final String recipientEmail;
    /**
     * Message to send.
     * This works as the argument to be used in the execute() method, i.e., the
     * argument to be passed to emailBox.sendEmail() method.
     */
    private final String msgToEmail;

    /**
     * Constructor with parameter.
     * @param emailBox email box to use
     * @param recipientEmail email address of the recipient
     * @param msg message to send
     */
    public EmailSomeone(EmailBox emailBox, String recipientEmail, String msg) {
        this.emailBox = emailBox;
        this.recipientEmail = recipientEmail;
        msgToEmail = msg;
        System.out.println("An email-someone command [Command] has been created.");
    }

    @Override
    public void execute() {
        // Let the email box [Receiver] handle this email-someone command [Command]
        emailBox.sendEmail(recipientEmail, msgToEmail);
    }

}
