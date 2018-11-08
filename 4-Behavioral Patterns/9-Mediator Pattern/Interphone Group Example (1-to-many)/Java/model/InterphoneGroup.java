package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * InterphoneGroup class that works as "Mediator".
 * A "Mediator" object acts as the communication center for "Colleague" objects
 * by encapsulating the communication between "Colleague" objects in this
 * "Mediator" object.
 *
 * @author Ziang Lu
 */
public class InterphoneGroup {

    /**
     * All members in this interphone group.
     */
    private Map<String, User> allMembers = new HashMap<>();
    /**
     * Leaders in this interphone group.
     */
    private List<LeaderUser> leaders = new ArrayList<>();

    /**
     * Registers the given leader.
     * @param leader user to register
     */
    void register(LeaderUser leader) {
        allMembers.put(leader.getName(), leader);
        leaders.add(leader);
    }

    /**
     * Registers the given leader.
     * @param user user to register
     */
    void register(NormalUser user) {
        allMembers.put(user.getName(), user);
    }

    /**
     * Publishes the given message from the given sender.
     * @param sender sender of the message
     * @param msg message to publish
     */
    void publishMessage(User sender, String msg) {
        for (User member : allMembers.values()) {
            if (member != sender) { // The sender himself should not receive the message.
                member.receiveMessage(sender.getName(), msg);
            }
        }
    }

    /**
     * Publishes the given message from the given sender to all the leaders.
     * @param sender sender of the message
     * @param msg message to publish
     */
    void publishMessageToLeaders(User sender, String msg) {
        for (LeaderUser leader : leaders) {
            if (leader != sender) { // The sender himself should not receive the message.
                leader.receiveMessage(sender.getName(), msg);
            }
        }
    }

    /**
     * Sends the given message from the given sender to the given recipient.
     * @param sender sender of the message
     * @param recipientName name of the recipient
     * @param msg message to send
     */
    void privateMessage(User sender, String recipientName, String msg) {
        User recipient = allMembers.get(recipientName);
        recipient.receiveMessage(sender.getName(), msg);
    }

}
