package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Room class working as "Composite".
 * The "Composite" models nodes with children in the hierarchical structure.
 * However, since both "Composite" and "Leaf" inherit from the common super
 * class "Component", "Composite" does not need to keep track of its children's
 * actual type, but only need to keep track of a collection of the abstract
 * "Component" as its contents.
 * Without the abstract "Component" super class abstraction, "Component" would
 * have to maintain different lists for each kind of element in its contents,
 * and would need to provide separate method for each kind of element.
 *
 * @author Ziang Lu
 */
public class Room implementsa Choice {

    /**
     * Room ID.
     */
    private final int id;
    /**
     * Choices of this room.
     */
    private final List<Choice> choices;

    /**
     * Constructor with parameter.
     * @param id room ID
     */
    public Room(int id) {
        this.id = id;
        choices = new ArrayList<Choice>();
        choices.add(new Choice() {
            @Override
            public void printChoiceMessage() {}
        }); // Dummy object
    }

    @Override
    public void printChoiceMessage() {
        System.out.println("Enter Room #" + id);
    }

    /**
     * Prints the next choices in this room.
     */
    public void printNextChoices() {
        System.out.println("Now you are in Room #" + id);
        System.out.println("You have the following choices:");
        for (int option = 1; option < choices.size(); ++option) {
            System.out.print("Option " + option + ": ");
            choices.get(option).printChoiceMessage();
        }
    }

    /**
     * Returns the choice in this room with the give option.
     * @param option given option
     * @return selected choice
     */
    public Choice getChoice(int option) {
        return choices.get(option);
    }

    /**
     * Returns the number of choices in this room.
     * @return
     */
    public int getNumOfChoices() {
        return choices.size();
    }

    /**
     * Adds the given choice to this room.
     * @param choice choice to add
     */
    public void addChoice(Choice choice) {
        choices.add(choice);
    }

}
