package word_app_menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * Commands of this menu.
     */
    private Map<String, WordDocumentCommand> commands;

    /**
     * Command history.
     */
    private List<WordDocumentCommand> commandHistory;

    /**
     * Default constructor.
     */
    public Menu() {
        commands = new HashMap<>();
        commands.put("open", new OpenCommand());
        commands.put("save", new SaveCommand());
        commands.put("close", new CloseCommand());

        commandHistory = new ArrayList<>();
    }

    /**
     * Sets the Word document for the commands.
     * @param doc Word document to set
     */
    public void setCommandDoc(WordDocument doc) {
        for (WordDocumentCommand command : commands.values()) {
            command.setDoc(doc);
        }
    }

    /**
     * User clicks the given button on this menu.
     * @param button clicked button
     */
    public void click(String button) {
        if (commands.containsKey(button)) {
            System.out.println("Menu [Invoker] starts executing the " + button + " command [Command]");
            Command command = commands.get(button);
            command.execute();
            commandHistory.add(command);
        }
    }

    /**
     * Prints the command history invoked by this menu.
     */
    public void printCommandHistory() {
        System.out.println("Command history:");
        for (Command command : commandHistory) {
            System.out.println(command);
        }
    }

}
