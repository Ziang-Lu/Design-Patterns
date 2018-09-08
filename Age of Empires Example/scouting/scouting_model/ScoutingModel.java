package scouting.scouting_model;

/**
 * Abstract ScoutingModel class.
 *
 * @author Ziang Lu
 */
public abstract class ScoutingModel {

    /**
     * Explores towards the given direction.
     * @param direction direction to explore
     */
    public void explore(String direction) {
        System.out.println("Exploring towards " + direction + "...");
    }

}
