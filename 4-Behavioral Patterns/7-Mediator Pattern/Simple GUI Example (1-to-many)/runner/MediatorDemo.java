package runner;

import model.BookButton;
import model.Command;
import model.Mediator;
import model.SearchButton;
import model.ViewButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Application that actually uses Mediator Pattern.
 *
 * @author Ziang Lu
 */
public class MediatorDemo extends JFrame {

    /**
     * Default constructor.
     */
    public MediatorDemo() {
        // Set basic information for this frame
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Mediator Pattern demo");

        Mediator mediator = new Mediator();
        // Create a display label, register it to the mediator, and add it to the content pane
        JLabel display = new JLabel("Just start...");
        mediator.register(display);
        getContentPane().add(display, "North");

        // Create a panel
        JPanel panel = new JPanel();

        // Create a view button, and add it to the panel
        ViewButton viewButton = new ViewButton(mediator);
        viewButton.addActionListener((e) -> {
            Command command = (Command) e.getSource();
            command.execute();
        });
        panel.add(viewButton);

        // Create a search button, and add it to the panel
        SearchButton searchButton = new SearchButton(mediator);
        searchButton.addActionListener((e) -> {
            Command command = (Command) e.getSource();
            command.execute();
        });
        panel.add(searchButton);

        // Create a book button, and add it to the panel
        BookButton bookButton = new BookButton(mediator);
        bookButton.addActionListener((e) -> {
            Command command = (Command) e.getSource();
            command.execute();
        });
        panel.add(bookButton);

        // Add the panel to this frame
        add(panel);

        // Display this frame
        setVisible(true);
    }

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        new MediatorDemo();
    }

}
