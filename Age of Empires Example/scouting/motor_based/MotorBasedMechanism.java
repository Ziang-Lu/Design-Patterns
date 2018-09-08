package scouting.motor_based;

import scouting.ScoutingMechanism;
import scouting.scouting_model.Motor;

/**
 * Concrete MotorBasedMechanism to perform the scouting tasks (solve the
 * scouting problems) based on motors.
 *
 * @author Ziang Lu
 */
public class MotorBasedMechanism implements ScoutingMechanism {

    @Override
    public void startScouting(String startDirection) {
        Motor motor = new Motor();
        motor.explore(startDirection);
    }

    @Override
    public void stopScouting() {
        System.out.println("Motor stops scouting.");
    }

}
