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
     * Makes a robot using the given robot builder.
     * @param robotBuilder robot builder to use
     * @return built robot
     */
    public Robot makeRobot(RobotBuilder robotBuilder) {
        robotBuilder.buildRobot();
        return robotBuilder.getRobot();
    }

}
