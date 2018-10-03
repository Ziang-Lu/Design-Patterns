package runner;

import living_room.LedTV;
import living_room.LivingRoom;
import living_room.Memento;
import living_room.Sofa;

import java.util.HashMap;
import java.util.Map;

/**
 * StorageRoom class that works as "Caretaker" that actually uses Memento
 * Pattern.
 * This class is responsible for keeping a collection of "Memento", but never
 * examines or operates on the contents of a "Memento".
 *
 * @author Ziang Lu
 */
public class StorageRoom {

    /**
     * Stored mapping between tags and the corresponding mementos.
     */
    private static Map<String, Memento> memoMap = new HashMap<>();

    /**
     * Gets the memento associated with the given tag from this storage room.
     * @param tag tag associated with the memento to get
     * @return corresponding memento
     */
    private static Memento getMemento(String tag) {
        return memoMap.get(tag);
    }

    /**
     * Stores the given memento associated with the given tag in this storage
     * room.
     * @param tag tag associated with the memento to store
     * @param memento memento to store
     */
    private static void addMemento(String tag, Memento memento) {
        memoMap.put(tag, memento);
    }

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        LivingRoom livingRoom = new LivingRoom();

        // Decorate the living room as classical style
        livingRoom.setLedTV(new LedTV(42, false, 800.0));
        livingRoom.setSofa(new Sofa(5, "classical"));

        // Save the classical style of the living room in a memento
        Memento classical = livingRoom.createMemento();
        String classicalTag = "Classical-Style Decoration";
        addMemento(classicalTag, classical);
        // Decorate the living room as modern style
        livingRoom.setLedTV(new LedTV(46, true, 1000.0));
        livingRoom.setSofa(new Sofa(7, "modern"));
        System.out.println("Living Room current state: " + livingRoom);

        // Restore the living room to the previous saved classical style
        System.out.println();
        System.out.println("Living Room restoring " + classicalTag + "...");
        livingRoom.restore(getMemento(classicalTag));
        System.out.println("Living Room current state: " + livingRoom);

        /*
         * Output:
         * Created a memento for Living Room: Memento [ledTV=LedTV{size=42, usbSupport=false, price=$800.0}, sofa=Sofa{size=5, style= classical}]
         * Living Room current state: LivingRoom{ledTV=LedTV{size=46, usbSupport=true, price=$1000.0}, sofa=Sofa{size=7, style= modern}}
         *
         * Living Room restoring to Classical-Style Decoration...
         * Living Room current state: LivingRoom{ledTV=LedTV{size=42, usbSupport=false, price=$800.0}, sofa=Sofa{size=5, style= classical}}
         */
    }

}
