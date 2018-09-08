package scouting;

import scouting.drone_based.DroneBasedMechanism;
import scouting.motor_based.MotorBasedMechanism;
import scouting.scout_based.ScoutBasedMechanism;

/**
 * Facade class for scouting that serves as a front-facing interface masking
 * more complex sub-components to simply the usage for client and minimize the
 * dependencies between the client and the sub-components.
 *
 * @author Ziang Lu
 */
public class ScoutingFacade {

    /**
     * Scouting mechanism to use.
     */
    private ScoutingMechanism scoutingMechanism;

    /**
     * Constructor with parameter.
     * @param era era of the player
     */
    public ScoutingFacade(String era) {
        switch (era) {
            case "Medieval":
                scoutingMechanism = new ScoutBasedMechanism();
                break;
            case "Second Industrial Revolution":
                scoutingMechanism = new MotorBasedMechanism();
                break;
            case "Modern":
                scoutingMechanism = new DroneBasedMechanism();
                break;
        }
    }

    /**
     * Starts scouting towards the given starting direction.
     * @param startDirection starting direction
     */
    public void startScouting(String startDirection) {
        scoutingMechanism.startScouting(startDirection);
    }

    /**
     * Stops scouting.
     */
    public void stopScouting() {
        scoutingMechanism.stopScouting();
    }

    /**
     * Gets the scouting report.
     */
    public void getScoutingReport() {
        // Implementation ignored
    }

}
