package robot;

/**
 * Concrete Robot class.
 *
 * @author Ziang Lu
 */
public class Robot {

    /**
     * Head of this robot.
     */
    private RobotHead head;
    /**
     * Torso of this robot.
     */
    private RobotTorso torso;
    /**
     * Arms of this robot.
     */
    private RobotArms arms;
    /**
     * Legs of this robot.
     */
    private RobotLegs legs;

    /**
     * Mutator of head.
     * @param head head to set
     */
    public void setHead(RobotHead head) {
        this.head = head;
    }

    /**
     * Mutator of torso.
     * @param torso torso to set
     */
    public void setTorso(RobotTorso torso) {
        this.torso = torso;
    }

    /**
     * Mutator of arms.
     * @param arms arms to set
     */
    public void setArms(RobotArms arms) {
        this.arms = arms;
    }

    /**
     * Mutator of legs.
     * @param legs legs to set
     */
    public void setLegs(RobotLegs legs) {
        this.legs = legs;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Robot [");
        s.append("head=").append(head.getType()).append(", ");
        s.append("torso=").append(torso.getType()).append(", ");
        s.append("arms=").append(arms.getType()).append(", ");
        s.append("legs=").append(legs.getType());
        s.append("]\n");
        return s.toString();
    }

}
