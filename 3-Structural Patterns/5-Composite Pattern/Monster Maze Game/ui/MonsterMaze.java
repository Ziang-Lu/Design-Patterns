package ui;

import model.Monster;
import model.Room;
import model.Treasure;

/**
 * Application that actually uses Composite Pattern.
 *
 * @author Ziang Lu
 */
public class MonsterMaze {

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        Room r1 = new Room(1);
        Room r2 = new Room(2);
        Room r3 = new Room(3);
        Room r4 = new Room(4);
        Room r5 = new Room(5);
        Room r6 = new Room(6);

        Monster m1 = new Monster();
        Monster m2 = new Monster();

        Treasure t = new Treasure(100);

        r1.addChoice(r2);
        r1.addChoice(r4);

        r2.addChoice(r3);
        r2.addChoice(r6);

        r3.addChoice(r4);
        r3.addChoice(m1);
        m1.setTreasure(t);
        r3.addChoice(t);

        r4.addChoice(r5);
        r5.addChoice(m2);

        r6.addChoice(t);

        MonsterMazeGame game = new MonsterMazeGame(r1);
        game.playGame();
    }

}
