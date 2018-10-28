package runner;

import builder.NewRobotBuilder;
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
        RobotEngineer engineer = new RobotEngineer();

        Robot oldRobot = engineer.makeRobot(new OldRobotBuilder());
        System.out.println("Robot successfully built.");
        System.out.println(oldRobot);

        Robot newRobot = engineer.makeRobot(new NewRobotBuilder());
        System.out.println("Robot successfully built.");
        System.out.println(newRobot);

        /*
         * Output:
         * Robot successfully built.
         * Robot{head=Tin Head, torso=Tin Torso, arms=Blowtorch Arms, legs=Roller Skates}
         *
         * Robot successfully built.
         * Robot{head=Vibranium Head, torso=Vibranium Torso, arms=Artificial Flesh Arms, legs=Jet-Propelled Legs}
         */
    }

}
