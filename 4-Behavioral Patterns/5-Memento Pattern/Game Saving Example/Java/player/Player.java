package player;

/**
 * Player class that works as "Originator".
 *
 * @author Ziang Lu
 */
public class Player {

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
    public void restore(Memento memo) {
        System.out.println("Player restoring to " + memo + "...");
        level = memo.getPlayerLevel();
        life = memo.getPlayerLife();
    }

    @Override
    public String toString() {
        return "Player{level=" + level + ", life=" + life + "}";
    }

}
