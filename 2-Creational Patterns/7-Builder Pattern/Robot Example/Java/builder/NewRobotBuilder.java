package builder;

import robot.Robot;
import robot.RobotArms;
import robot.RobotHead;
import robot.RobotLegs;
import robot.RobotTorso;

/**
 * Concrete NewRobotBuilder class that works as a concrete factory, a blueprint,
 * to build an new-school type of robot.
 *
 * @author Ziang Lu
 */
public class NewRobotBuilder extends RobotBuilder {

    @Override
    protected void buildRobotHead() {
        robot.setHead(new RobotHead("Vibranium Head"));
    }

    @Override
    protected void buildRobotTorso() {
        robot.setTorso(new RobotTorso("Vibranium Torso"));
    }

    @Override
    protected void buildRobotArms() {
        robot.setArms(new RobotArms("Artificial Flesh Arms"));
    }

    @Override
    protected void buildRobotLegs() {
        robot.setLegs(new RobotLegs("Jet-Propelled Legs"));
    }

}
