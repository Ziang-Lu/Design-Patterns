package word_app_menu;

/**
 * Menu class that works as "Invoker".
 * This class is responsible for executing the different "Command"s.
 * The "Invoker" does not know how to handle the request, but simply invoke
 * command.execute() method, and let the internal correct "Receive" handle the
 * request.
 *
 * @author Ziang Lu
 */
public class Menu {

    /**
     * Open command of this menu.
     */
    private OpenCommand openCommand = new OpenCommand();
    /**
     * Save command of this menu.
     */
    private SaveCommand saveCommand = new SaveCommand();
    /**
     * Close command of this menu.
     */
    private CloseCommand closeCommand = new CloseCommand();

    /**
     * Sets the Word document for the commands.
     * @param doc Word document to set
     */
    public void setCommandDoc(WordDocument doc) {
        openCommand.setDoc(doc);
        saveCommand.setDoc(doc);
        closeCommand.setDoc(doc);
    }

    /**
     * User clicks "open" button on this menu.
     */
    public void clickOpen() {
        System.out.println("Menu [Invoker] starts executing the open command [Command]...");
        openCommand.execute();
    }

    /**
     * User clicks "save" button on this menu.
     */
    public void clickSave() {
        System.out.println("Menu [Invoker] starts executing the save command [Command]...");
        saveCommand.execute();
    }

    /**
     * User clicks "close" button on this menu.
     */
    public void clickClose() {
        System.out.println("Menu [Invoker] starts executing the close command [Command]...");
        closeCommand.execute();
    }

}
