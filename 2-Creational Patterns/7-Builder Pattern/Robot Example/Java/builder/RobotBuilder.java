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
     * Builds a robot's head.
     */
    public abstract void buildRobotHead();

    /**
     * Builds a robot's torso.
     */
    public abstract void buildRobotTorso();

    /**
     * Builds a robot's arms.
     */
    public abstract void buildRobotArms();

    /**
     * Builds a robot's legs.
     */
    public abstract void buildRobotLegs();

    /**
     * Returns the finished robot.
     * @return finished robot
     */
    public Robot getRobot() {
        return robot;
    }

}
