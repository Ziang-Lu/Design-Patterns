package model;

/**
 * Treasure class working as one kind of "Leaf".
 *
 * @author Ziang Lu
 */
public class Treasure extends EndingChoice {

    /**
     * Prize of this treasure.
     */
    private final int prize;

    /**
     * Constructor with parameter.
     * @param prize prize of the treasure
     */
    public Treasure(int prize) {
        this.prize = prize;
    }

    @Override
    public void printChoiceMessage() {
        System.out.println("Claim your treasure!");
    }

    @Override
    public void printOutcome() {
        System.out.println("Your prize is " + prize + " coins.");
    }

}
