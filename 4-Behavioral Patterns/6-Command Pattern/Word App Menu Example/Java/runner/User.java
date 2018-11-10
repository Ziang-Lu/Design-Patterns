package runner;

import word_app_menu.WordDocument;
import word_app_menu.Menu;

/**
 * Application that actually uses Command Pattern.
 *
 * @author Ziang Lu
 */
public class User {

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        WordDocument doc = new WordDocument("Sample File.txt"); // Receiver

        Menu menu = new Menu(); // Invoker

        System.out.println();
        // Set the Word document [Receiver] for the commands [Command]
        menu.setCommandDoc(doc);

        System.out.println();
        menu.click("open");
        menu.click("save");
        menu.click("save");
        menu.click("close");

        WordDocument doc2 = new WordDocument("Sample File 2.txt"); // Receiver

        System.out.println();
        // Set the Word document [Receiver] for the commands [Command]
        menu.setCommandDoc(doc2);

        System.out.println();
        menu.click("open");
        menu.click("save");
        menu.click("save");
        menu.click("close");

        System.out.println();
        menu.printCommandHistory();

        /*
         * Output:
         * An open command [Command] has ben created.
         * A save command [Command] has ben created.
         * A open command [Command] has ben created.
         *
         * Setting the Word document [Receiver] for save command [Command] as Sample File.txt.
         * Setting the Word document [Receiver] for close command [Command] as Sample File.txt.
         * Setting the Word document [Receiver] for open command [Command] as Sample File.txt.
         *
         * Menu [Invoker] starts executing the open command [Command]
         * Sample File.txt has been opened.
         * Menu [Invoker] starts executing the save command [Command]
         * Sample File.txt has been saved.
         * Menu [Invoker] starts executing the save command [Command]
         * Sample File.txt has been saved.
         * Menu [Invoker] starts executing the close command [Command]
         * Sample File.txt has been closed.
         *
         * Setting the Word document [Receiver] for save command [Command] as Sample File 2.txt.
         * Setting the Word document [Receiver] for close command [Command] as Sample File 2.txt.
         * Setting the Word document [Receiver] for open command [Command] as Sample File 2.txt.
         *
         * Menu [Invoker] starts executing the open command [Command]
         * Sample File 2.txt has been opened.
         * Menu [Invoker] starts executing the save command [Command]
         * Sample File 2.txt has been saved.
         * Menu [Invoker] starts executing the save command [Command]
         * Sample File 2.txt has been saved.
         * Menu [Invoker] starts executing the close command [Command]
         * Sample File 2.txt has been closed.
         *
         * Command history:
         * word_app_menu.OpenCommand@39ba5a14
         * word_app_menu.SaveCommand@511baa65
         * word_app_menu.SaveCommand@511baa65
         * word_app_menu.CloseCommand@340f438e
         * word_app_menu.OpenCommand@39ba5a14
         * word_app_menu.SaveCommand@511baa65
         * word_app_menu.SaveCommand@511baa65
         * word_app_menu.CloseCommand@340f438e
         */
    }

}
