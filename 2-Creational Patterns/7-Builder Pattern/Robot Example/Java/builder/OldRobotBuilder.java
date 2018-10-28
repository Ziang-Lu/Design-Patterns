package builder;

import robot.Robot;
import robot.RobotArms;
import robot.RobotHead;
import robot.RobotLegs;
import robot.RobotTorso;

/**
 * Concrete OldRobotBuilder class that works as a concrete factory, a blueprint,
 * to build an old-school type of robot.
 *
 * @author Ziang Lu
 */
public class OldRobotBuilder extends RobotBuilder {

    @Override
    protected void buildRobotHead() {
        robot.setHead(new RobotHead("Tin Head"));
    }

    @Override
    protected void buildRobotTorso() {
        robot.setTorso(new RobotTorso("Tin Torso"));
    }

    @Override
    protected void buildRobotArms() {
        robot.setArms(new RobotArms("Blowtorch Arms"));
    }

    @Override
    protected void buildRobotLegs() {
        robot.setLegs(new RobotLegs("Roller Skates"));
    }

}
