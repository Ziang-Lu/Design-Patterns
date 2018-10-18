package runner;

import observer.Follower;
import subject.Tweeter;

/**
 * Application that actually uses Observer Pattern.
 *
 * @author Ziang Lu
 */
public class ObserverPatternTest {

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        Tweeter trump = new Tweeter("Donald Trump");
        Follower american1 = new Follower("US Citizen 1");
        Follower american2 = new Follower("US Citizen 2");
        american1.follow(trump);
        american2.follow(trump);

        System.out.println();
        trump.writeTweeter();

        /*
         * Output:
         * US Citizen 1: Starting to follow Donald Trump
         * US Citizen 2: Starting to follow Donald Trump
         *
         * Donald Trump: I wrote a new tweet: A wonderful way with my family!
         * US Citizen 2: I got an update from Donald Trump about a new tweet: A wonderful way with my family!
         * US Citizen 1: I got an update from Donald Trump about a new tweet: A wonderful way with my family!
         */
    }

}
