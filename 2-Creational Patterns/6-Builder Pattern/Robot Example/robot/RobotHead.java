package robot;

/**
 * RobotHead class.
 *
 * @author Ziang Lu
 */
public class RobotHead {

    /**
     * Type of this robot head.
     */
    private final String type;

    /**
     * Constructor with parameter.
     * @param type type of the robot head
     */
    public RobotHead(String type) {
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
