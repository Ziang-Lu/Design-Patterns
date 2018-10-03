package player;

/**
 * Memento class.
 * This class holds a snapshot of the internal state of the "Originator".
 * This is like a wrapper (a packing box) for the internal state of the
 * "Originator" to be stored.
 *
 * @author Ziang Lu
 */
public class Memento {

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
