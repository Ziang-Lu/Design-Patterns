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
        User thor = new NormalUser("Thor");
        User bruce = new NormalUser("Bruce Banner");
        User nat = new NormalUser("Nathasha Romanoff");
        User clint = new NormalUser("Clint Barton");

        InterphoneGroup avengers = new InterphoneGroup();
        steve.joinGroup(avengers);
        tony.joinGroup(avengers);
        thor.joinGroup(avengers);
        bruce.joinGroup(avengers);
        nat.joinGroup(avengers);
        clint.joinGroup(avengers);

        tony.sendToAll("Incoming enemy!");

        System.out.println();
        steve.sendToLeaders("We need a plan of attack.");

        System.out.println();
        clint.sendMessage("Thor", "Please give me a ride.");

        /*
         * Output:
         * Tony Stark sends a public message: Incoming enemy!
         * Thor received a message from Tony Stark: Incoming enemy!
         * Bruce Banner received a message from Tony Stark: Incoming enemy!
         * Clint Barton received a message from Tony Stark: Incoming enemy!
         * Nathasha Romanoff received a message from Tony Stark: Incoming enemy!
         * Steve Rogers received a message from Tony Stark: Incoming enemy!
         *
         * Steve Rogers sends a message to all the leaders: We need a plan of attack.
         * Tony Stark received a message from Steve Rogers: We need a plan of attack.
         *
         * Clint Barton sends a message to Thor: Please give me a ride.
         * Thor received a message from Clint Barton: Please give me a ride.
         */
    }

}
