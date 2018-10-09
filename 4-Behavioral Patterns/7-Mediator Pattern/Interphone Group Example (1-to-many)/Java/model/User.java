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
    private InterphoneGroup group;

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
    public void joinGroup(InterphoneGroup group) {
        this.group = group;
        group.register(this);
    }

    /**
     * Sends the given message to the group.
     * @param msg message to send
     */
    public void sendMessage(String msg) {
        System.out.println(name + " sends a message: " + msg);
        group.publishMessage(this, msg);
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
