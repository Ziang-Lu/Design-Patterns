package model;

import java.util.ArrayList;
import java.util.List;

/**
 * InterphoneGroup class that works as "Mediator".
 * A "Mediator" object acts as the communication center for "Colleague" objects.
 *
 * @author Ziang Lu
 */
public class InterphoneGroup {

    /**
     * Members in this interphone group.
     */
    private List<User> members = new ArrayList<>();

    /**
     * Registers the given user.
     * @param user user to register
     */
    void register(User user) {
        members.add(user);
    }

    /**
     * Publishes the given message from the given sender.
     * @param sender sender of the message
     * @param msg message to publish
     */
    void publishMessage(User sender, String msg) {
        for (User member : members) {
            if (member != sender) { // The sender himself should not receive the message.
                member.receiveMessage(sender.getName(), msg);
            }
        }
    }

}
