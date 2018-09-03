package robot;

/**
 * RobotTorso class.
 *
 * @author Ziang Lu
 */
public class RobotTorso {

    /**
     * Type of this robot torso.
     */
    private final String type;

    /**
     * Constructor with parameter.
     * @param type type of the robot torso
     */
    public RobotTorso(String type) {
        this.type = type;
    }

    /**
     * Accessor of type.
     * @return type
     */
    public String getType() {
        return type;
    }

}
