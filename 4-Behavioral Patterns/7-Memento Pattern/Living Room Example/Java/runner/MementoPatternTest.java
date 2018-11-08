package runner;

import living_room.IMemento;
import living_room.LedTV;
import living_room.LivingRoom;
import living_room.Sofa;

/**
 * Application that actually uses Memento Pattern.
 *
 * @author Ziang Lu
 */
public class MementoPatternTest {

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        LivingRoom livingRoom = new LivingRoom();
        StorageRoom storageRoom = new StorageRoom();

        // Decorate the living room as classical style
        livingRoom.setLedTV(new LedTV(42, false, 800.0));
        livingRoom.setSofa(new Sofa(5, "classical"));

        // Save the classical style of the living room in a memento
        IMemento classical = livingRoom.createMemento();
        String classicalTag = "Classical-Style Decoration";
        storageRoom.addMemento(classicalTag, classical);
        // Decorate the living room as modern style
        livingRoom.setLedTV(new LedTV(46, true, 1000.0));
        livingRoom.setSofa(new Sofa(7, "modern"));
        System.out.println("Living Room current state: " + livingRoom);

        // Restore the living room to the previous saved classical style
        System.out.println();
        System.out.println("Living Room restoring " + classicalTag + "...");
        livingRoom.restore(storageRoom.getMemento(classicalTag));
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
