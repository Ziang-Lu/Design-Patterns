package builder;

import robot.Robot;

/**
 * RobotEngineer class that works as a director and owns a robot builder
 * (working as a factory) to make and return robots.
 *
 * @author Ziang Lu
 */
public class RobotEngineer {

    /**
     * Robot builder owned by this robot engineer.
     */
    private final RobotBuilder robotBuilder;

    /**
     * Constructor with parameter.
     * @param robotBuilder robot builder to be owned by the robot engineer
     */
    public RobotEngineer(RobotBuilder robotBuilder) {
        this.robotBuilder = robotBuilder;
    }

    /**
     * Makes a robot via the robot builder.
     */
    public void makeRobot() {
        robotBuilder.buildRobotHead();
        robotBuilder.buildRobotTorso();
        robotBuilder.buildRobotArms();
        robotBuilder.buildRobotLegs();
    }

    /**
     * Returns a finished robot from the robot builder.
     * @return finished robot
     */
    public Robot getRobot() {
        return robotBuilder.getRobot();
    }

}
