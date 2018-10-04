package player;

/**
 * Player class that works as "Originator".
 *
 * @author Ziang Lu
 */
public class Player {

    /**
     * Memento class.
     * This class holds a snapshot of the internal state of the "Originator".
     * This is like a wrapper (a packing box) for the internal state of the
     * "Originator" to be stored.
     */
    private static class Memento implements IMemento {
        /**
         * Stored player playerLevel.
         */
        private int playerLevel;
        /**
         * Stored player playerLife.
         */
        private double playerLife;

        /**
         * Constructor with parameter.
         * @param playerLevel player playerLevel to store
         * @param playerLife player playerLife to store
         */
        Memento(int playerLevel, double playerLife) {
            this.playerLevel = playerLevel;
            this.playerLife = playerLife;
        }

        /**
         * Accessor of playerLevel.
         * @return playerLevel
         */
        int getPlayerLevel() {
            return playerLevel;
        }

        /**
         * Accessor of playerLife.
         * @return playerLife
         */
        double getPlayerLife() {
            return playerLife;
        }

        @Override
        public String toString() {
            return "Memento{playerLevel=" + playerLevel + ", playerLife=" + playerLife + "}";
        }
    }

    /**
     * Defined full life of a player.
     */
    private static final double FULL_LIFE = 1.0;
    /**
     * Percentage damage when failed a checkpoint.
     */
    private static final double DAMAGE_PER = 0.1;

    /**
     * Level of this player.
     */
    private int level;
    /**
     * Life of this player.
     */
    private double life;

    /**
     * Constructor with parameter.
     * @param level level of the player
     * @param life life of the player
     */
    public Player(int level, double life) {
        this.level = level;
        this.life = life;
    }

    /**
     * Succeeds a checkpoint.
     */
    public void succeed() {
        ++this.level;
        this.life = FULL_LIFE;
    }

    /**
     * Fails a checkpoint.
     */
    public void fail() {
        this.life *= DAMAGE_PER;
    }

    /**
     * Creates a memento containing a snapshot of the internal state of this
     * player.
     * @return created memento
     */
    public Memento createMemento() {
        Memento memo = new Memento(level, life);
        System.out.println("Created a memento for Player: " + memo);
        return memo;
    }

    /**
     * Restores the internal state of this player from the given memento.
     * @param memo memento to restore from
     */
    public void restore(IMemento memo) {
        Memento memento = (Memento) memo;
        System.out.println("Player restoring to " + memento + "...");
        level = memento.getPlayerLevel();
        life = memento.getPlayerLife();
    }

    @Override
    public String toString() {
        return "Player{level=" + level + ", life=" + life + "}";
    }

}
