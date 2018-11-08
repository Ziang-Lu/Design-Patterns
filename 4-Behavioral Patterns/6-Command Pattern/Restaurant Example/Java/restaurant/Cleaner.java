package restaurant;

/**
 * Cleaner class that works as the "Receiver" for "CleanCommand" command.
 *
 * @author Ziang Lu
 */
public class Cleaner {

    /**
     * Cleans the table.
     */
    void cleanTable() {
        System.out.println("Cleaner [Receiver] is cleaning up the table.");
    }

}
