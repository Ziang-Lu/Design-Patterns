package runner;

import model.InterphoneGroup;
import model.LeaderUser;
import model.NormalUser;
import model.User;

/**
 * Application that actually uses Mediator Pattern.
 *
 * @author Ziang Lu
 */
public class Avengers {

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        User steve = new LeaderUser("Steve Rogers");
        User tony = new LeaderUser("Tony Stark");
        User bruce = new NormalUser("Bruce Banner");

        InterphoneGroup avengersGroup = new InterphoneGroup();
        steve.joinGroup(avengersGroup);
        tony.joinGroup(avengersGroup);
        bruce.joinGroup(avengersGroup);

        tony.sendMessage("Incoming enemy!");

        /*
         * Output:
         * Tony Stark sends a message: Incoming enemy!
         * Steve Rogers received a message from Tony Stark: Incoming enemy!
         * Bruce Banner received a message from Tony Stark: Incoming enemy!
         */
    }

}
