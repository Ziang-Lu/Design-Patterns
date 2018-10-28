package builder;

import robot.Robot;

/**
 * Abstract RobotBuilder class that works as an abstract factory and defines the
 * construction process for a robot, i.e., how to build a robot by creating and
 * assembling all of its parts.
 *
 * @author Ziang Lu
 */
public abstract class RobotBuilder {

    /**
     * Robot to build.
     */
    protected Robot robot = new Robot();

    /**
     * Builds the robot.
     */
    public void buildRobot() {
        buildRobotHead();
        buildRobotTorso();
        buildRobotArms();
        buildRobotLegs();
    }

    /**
     * Protected helper method to build a robot's head.
     */
    protected abstract void buildRobotHead();

    /**
     * Protected helper method to build a robot's torso.
     */
    protected abstract void buildRobotTorso();

    /**
     * Protected helper method to build a robot's arms.
     */
    protected abstract void buildRobotArms();

    /**
     * Protected helper method to build a robot's legs.
     */
    protected abstract void buildRobotLegs();

    /**
     * Returns the finished robot.
     * @return finished robot
     */
    public Robot getRobot() {
        return robot;
    }

}
