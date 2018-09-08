package scouting.drone_based;

import scouting.ScoutingMechanism;
import scouting.scouting_model.Drone;

/**
 * Concrete DroneBasedMechanism to perform the scouting tasks (solve the
 * scouting problems) based on drones.
 *
 * @author Ziang Lu
 */
public class DroneBasedMechanism implements ScoutingMechanism {

    @Override
    public void startScouting(String startDirection) {
        Drone drone = new Drone();
        drone.explore(startDirection);
    }

    @Override
    public void stopScouting() {
        System.out.println("Drone stops scouting.");
    }

}
