package model;

/**
 * Monster class working as "Leaf".
 *
 * @author Ziang Lu
 */
public class Monster extends EndingChoice {

    /**
     * Option message for Monster.
     */
    private static final String OPTION_MSG = "Fight a monster!";

    /**
     * Treasure hidden behind this monster.
     */
    private Treasure treasure;

    /**
     * Default constructor.
     */
    public Monster() {
        treasure = null;
    }

    @Override
    public void printChoiceMessage() {
        System.out.println(OPTION_MSG);
    }

    @Override
    public void printOutcome() {
        if (treasure == null) {
            System.out.println("Ha! The monster killed you!");
        } else {
            System.out.println("Ah! You killed the monster!");
            treasure.printOutcome();
        }
    }

    /**
     * Mutator of treasure.
     * @param treasure treasure to set
     */
    public void setTreasure(Treasure treasure) {
        this.treasure = treasure;
    }

}
