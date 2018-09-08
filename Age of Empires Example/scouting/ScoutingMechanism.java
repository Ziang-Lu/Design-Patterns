package scouting;

/**
 * Abstract scouting mechanism interface to define the scouting tasks to perform
 * (scouting problems to solve).
 *
 * @author Ziang Lu
 */
public interface ScoutingMechanism {

    /**
     * Starts scouting towards the given direction.
     * @param startDirection starting direction
     */
    void startScouting(String startDirection);

    /**
     * Stops scouting.
     */
    void stopScouting();

}
