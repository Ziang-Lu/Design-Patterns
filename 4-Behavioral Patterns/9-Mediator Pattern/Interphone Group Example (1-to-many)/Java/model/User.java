package model;

/**
 * Abstract User class that works as "Colleague".
 * When a "Colleague" object needs to communicate to another "Colleague" object,
 * it does not directly call on the other "Colleague" object; instead, it calls
 * the "Mediator" object whose main duty is to control and coordinate the
 * communication between "Colleague" objects.
 * In this way, the communication complexity between the "Colleague" objects are
 * greatly reduced.
 *
 * @author Ziang Lu
 */
public abstract class User {

    /**
     * User of this user.
     */
    private final String name;
    /**
     * Interphone group of this user.
     */
    protected InterphoneGroup group;

    /**
     * Constructor with parameter.
     * @param name name of the user
     */
    protected User(String name) {
        this.name = name;
    }

    /**
     * Accessor of name.
     * @return name
     */
    String getName() {
        return name;
    }

    /**
     * Joins the given interphone group.
     * @param group interphone group to join
     */
    public abstract void joinGroup(InterphoneGroup group);

    /**
     * Sends the given message to all the members in the group.
     * @param msg message to send
     */
    public void sendToAll(String msg) {
        System.out.println(name + " sends a public message: " + msg);
        group.publishMessage(this, msg);
    }

    /**
     * Sends the given message to all the leaders in the group.
     * @param msg message to send
     */
    public void sendToLeaders(String msg) {
        System.out.println(name + " sends a message to all the leaders: " + msg);
        group.publishMessageToLeaders(this, msg);
    }

    /**
     * Sends the given message to the given recipient.
     * @param recipient name of the recipient
     * @param msg message to send
     */
    public void sendMessage(String recipient, String msg) {
        System.out.println(name + " sends a message to " + recipient + ": " + msg);
        group.privateMessage(this, recipient, msg);
    }

    /**
     * Receives the given message from the given sender.
     * @param senderName name of the sender
     * @param msg received message
     */
    void receiveMessage(String senderName, String msg) {
        System.out.println(name + " received a message from " + senderName + ": " + msg);
    }

}
