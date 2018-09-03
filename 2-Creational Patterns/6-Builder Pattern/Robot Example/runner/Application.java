package runner;

import builder.OldRobotBuilder;
import builder.RobotBuilder;
import builder.RobotEngineer;
import robot.Robot;

/**
 * Application that actually makes use of Builder Pattern to create robots.
 *
 * @author Ziang Lu
 */
public class Application {

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        RobotBuilder oldRobotBuilder = new OldRobotBuilder();
        RobotEngineer engineer = new RobotEngineer(oldRobotBuilder);

        engineer.makeRobot();

        Robot oldRobot = engineer.getRobot();
        System.out.println("Robot successfully built.");
        System.out.println(oldRobot);
    }

}
