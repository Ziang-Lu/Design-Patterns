package runner;

import model.Client;
import model.PubSubServer;

/**
 * Application that actually uses Publish-Subscribe Pattern for messaging.
 *
 * @author Ziang Lu
 */
public class PubSubPatternTest {

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        PubSubServer server = new PubSubServer();
        Client cli1 = new Client("Chris", server);
        cli1.subscribe("news");
        Client cli2 = new Client("Tony", server);
        cli2.subscribe("news");
        Client cli3 = new Client("Someone", server);

        System.out.println();
        cli3.publish("news", "It's a good day!");

        /*
         * Output:
         * Chris starts subscribing to channel-[news]
         * Tony starts subscribing to channel-[news]
         *
         * Someone publishes message 'It's a good day!' to channel-[news]
         * Chris receives message 'It's a good day!' from channel-[news]
         * Tony receives message 'It's a good day!' from channel-[news]
         */
    }

}
