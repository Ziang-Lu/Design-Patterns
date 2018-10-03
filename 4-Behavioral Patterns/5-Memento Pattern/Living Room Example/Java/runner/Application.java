package runner;

import model.LedTV;
import model.LivingRoom;
import model.Sofa;
import model.StorageRoom;

/**
 * Application that actually uses Memento Pattern.
 *
 * @author Ziang Lu
 */
public class Application {

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        LivingRoom livingRoom = new LivingRoom();
        livingRoom.setLedTV(new LedTV(42, false, 800.0));
        livingRoom.setSofa(new Sofa(5));

        StorageRoom storageRoom = new StorageRoom();
        livingRoom.createMementoAndStore(storageRoom, "42-inch TV");
        livingRoom.setLedTV(new LedTV(46, true, 1000.0));

        livingRoom.createMementoAndStore(storageRoom, "46-inch TV");
        livingRoom.setLedTV(new LedTV(50, true, 1200.0));
        System.out.println("Living Room current state: " + livingRoom);

        System.out.println();
        livingRoom.restoreState(storageRoom, "42-inch TV");
        System.out.println("Living Room current state: " + livingRoom);

        System.out.println();
        livingRoom.restoreState(storageRoom, "46-inch TV");
        System.out.println("Living Room current state: " + livingRoom);

        /*
         * Output:
         * Created a memento for Living Room: Memento [ledTV=LedTV{size=42, usbSupport=false, price=$800.0}, sofa=Sofa{size=5}]
         * Created a memento for Living Room: Memento [ledTV=LedTV{size=46, usbSupport=true, price=$1000.0}, sofa=Sofa{size=5}]
         * Living Room current state: LivingRoom{ledTV=LedTV{size=50, usbSupport=true, price=$1200.0}, sofa=Sofa{size=5}}
         *
         * Living Room restoring to 42-inch TV...
         * Living Room current state: LivingRoom{ledTV=LedTV{size=42, usbSupport=false, price=$800.0}, sofa=Sofa{size=5}}
         *
         * Living Room restoring to 46-inch TV...
         * Living Room current state: LivingRoom{ledTV=LedTV{size=46, usbSupport=true, price=$1000.0}, sofa=Sofa{size=5}}
         */
    }

}
