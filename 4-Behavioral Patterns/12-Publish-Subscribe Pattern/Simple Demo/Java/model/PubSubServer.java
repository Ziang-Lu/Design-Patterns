package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Pub/Sub server class.
 *
 * @author Ziang Lu
 */
public class PubSubServer {

    /**
     * Map between channels and their subscribers.
     */
    private Map<String, List<Client>> channelToSubscribers;

    /**
     * Default constructor.
     */
    public PubSubServer() {
        channelToSubscribers = new HashMap<>();
    }

    /**
     * Registers that the given client subscribes to the given channel.
     * @param cli client subscribing to a channel
     * @param channel channel that the client subscribes to
     */
    void register(Client cli, String channel) {
        List<Client> subscribers = channelToSubscribers.getOrDefault(channel, new ArrayList<>());
        subscribers.add(cli);
        channelToSubscribers.put(channel, subscribers);
    }

    /**
     * Routes the given message to the given channel.
     * @param channel channel to route message to
     * @param message message to route
     */
    void route(String channel, String message) {
        if (!channelToSubscribers.containsKey(channel)) {
            return;
        }
        for (Client receiver : channelToSubscribers.get(channel)) {
            receiver.receiveMessage(channel, message);
        }
    }

}
