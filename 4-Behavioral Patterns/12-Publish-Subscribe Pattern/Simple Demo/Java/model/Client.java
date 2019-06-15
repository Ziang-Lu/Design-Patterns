package model;

/**
 * Client class that can work both as the role of publisher and receiver.
 *
 * @author Ziang Lu
 */
public class Client {

    /**
     * Name of this client.
     */
    private final String name;
    /**
     * Pub/Sub server to connect to.
     */
    private PubSubServer server;

    /**
     * Constructor with parameter.
     * @param name name of the client
     * @param server Pub/Sub server to connect to
     */
    public Client(String name, PubSubServer server) {
        this.name = name;
        this.server = server;
    }

    /**
     * Subscribes to the given channel.
     * @param channel channel to subscribe to
     */
    public void subscribe(String channel) {
        System.out.println(name + " starts subscribing to channel-[" + channel + "]");
        server.register(this, channel);
    }

    /**
     * Publishes the given message to the given channel.
     * @param channel channel to publish message to
     * @param content content of the message
     */
    public void publish(String channel, String content) {
        System.out.println(name + " publishes message '" + content + "' to channel-[" + channel + "]");
        server.route(channel, content);
        // Note that this client (as a publisher) only knows the Pub/Sub server and the channel, but not the actual
        // receivers that will receive the message
    }

    /**
     * Receives the given message from the given channel.
     * @param channel channel that the message is from
     * @param message received message
     */
    void receiveMessage(String channel, String message) {
        // Note that this client (as a receiver) only knows the channels it subscribes to, but not the actual sender
        // that sends the message
        System.out.println(name + " receives message '" + message + "' from channel-[" + channel + "]");
    }

}
