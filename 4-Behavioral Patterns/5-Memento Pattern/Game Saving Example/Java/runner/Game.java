package runner;

import player.Memento;
import player.Player;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Game class that works as "Caretaker" that actually uses Memento Pattern.
 * This class is responsible for keeping a collection of "Memento", but never
 * examines or operates on the contents of a "Memento".
 *
 * @author Ziang Lu
 */
public class Game {

    /**
     * Stored mapping between dates and the corresponding mementos.
     */
    private static Map<Date, Memento> memosMap = new HashMap<>();

    /**
     * Gets the memento associated with the given date from this game.
     * @param date date associated with the memento to get
     * @return corresponding memento
     */
    private static Memento getMemento(Date date) {
        return memosMap.get(date);
    }

    /**
     * Stores the given memento associated with the given date in this game.
     * @param date date associated with the memento to store
     * @param memo memento to store
     */
    private static void addMemento(Date date, Memento memo) {
        memosMap.put(date, memo);
    }

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        // Create a player of level 7
        Player player = new Player(7, 0.95);
        System.out.println("Player status: " + player);

        // Enter Checkpoint-8
        System.out.println();
        System.out.println("Entering Checkpoint-8:");

        // pp
        Date beforeCheck8 = Calendar.getInstance().getTime();
        Memento memo = player.createMemento();
        addMemento(beforeCheck8, memo);

        int trial = 1;
        Random randomGenerator = new Random();
        while (true) {
            System.out.println();
            if (randomGenerator.nextDouble() < 0.8) {
                player.fail();
                System.out.println("Trial #" + trial + " failed. Player status: " + player);

                // If failed to pass Checkpoint-8, restore the player to the state before entering this checkpoint, and
                // keep attempting
                player.restore(getMemento(beforeCheck8));
                ++trial;
            } else {
                player.succeed();
                System.out.println("Trial #" + trial + " succeeded. Player status: " + player);

                // If succeeded to pass Checkpoint-8, go straight to the next checkpoint
                break;
            }
        }

        /*
         * Output:
         * Player status: Player{level=7, life=0.95}
         *
         * Entering Checkpoint-8:
         * Created a memento for Playe: Memento{level=7, life=0.95}
         *
         * Trial #1 failed. Player status: Player{level=7, life=0.095}
         * Player restoring to Memento{level=7, life=0.95}...
         *
         * Trial #2 failed. Player status: Player{level=7, life=0.095}
         * Player restoring to Memento{level=7, life=0.95}...
         *
         * Trial #3 succeeded. Player status: Player{level=8, life=1.0}
         */
    }

}
