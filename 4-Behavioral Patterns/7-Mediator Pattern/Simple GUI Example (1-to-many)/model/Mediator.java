package model;

import javax.swing.JLabel;
import java.awt.Font;

/**
 * Mediator class.
 * A "Mediator" object acts as the communication center for "Colleague" objects
 * by encapsulating the communication between "Colleague" objects in this
 * "Mediator" object.
 *
 * @author Ziang Lu
 */
public class Mediator {

    /**
     * Display label.
     */
    private JLabel display;
    /**
     * View button.
     */
    private ViewButton viewButton;
    /**
     * Search button.
     */
    private SearchButton searchButton;
    /**
     * Book button.
     */
    private BookButton bookButton;

    /**
     * Registers the given display label.
     * @param display display label to register
     */
    public void register(JLabel display) {
        this.display = display;
        display.setFont(new Font("Aria", Font.BOLD, 24));
    }

    /**
     * Registers the given view button.
     * @param viewButton view button to register
     */
    void register(ViewButton viewButton) {
        this.viewButton = viewButton;
    }

    /**
     * Registers the given search button.
     * @param searchButton search button to register
     */
    void register(SearchButton searchButton) {
        this.searchButton = searchButton;
    }

    /**
     * Registers the given book button.
     * @param bookButton book button to register
     */
    void register(BookButton bookButton) {
        this.bookButton = bookButton;
    }

    /**
     * Changes the GUI to viewing.
     */
    void view() {
        display.setText("Viewing...");
        viewButton.setEnabled(false);
        searchButton.setEnabled(true);
        bookButton.setEnabled(true);
    }

    /**
     * Changes the GUI to searching.
     */
    void search() {
        display.setText("Searching...");
        viewButton.setEnabled(true);
        searchButton.setEnabled(false);
        bookButton.setEnabled(true);
    }

    /**
     * Changes the GUI to booking.
     */
    void book() {
        display.setText("Viewing...");
        viewButton.setEnabled(true);
        searchButton.setEnabled(true);
        bookButton.setEnabled(false);
    }

}
