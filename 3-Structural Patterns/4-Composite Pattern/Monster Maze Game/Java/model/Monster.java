package model;

/**
 * Monster class working as one kind of "Leaf".
 *
 * @author Ziang Lu
 */
public class Monster extends EndingChoice {

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
        System.out.println("Fight a monster!");
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
