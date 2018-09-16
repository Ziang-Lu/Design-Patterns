package model;

/**
 * Treasire class working as "Leaf".
 *
 * @author Ziang Lu
 */
public class Treasure extends EndingChoice {

    /**
     * Option message for Treasure.
     */
    private static final String OPTION_MSG = "Claim your treasure!";

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
        System.out.println(OPTION_MSG);
    }

    @Override
    public void printOutcome() {
        System.out.println("Your prize is " + prize + " coins.");
    }

}
