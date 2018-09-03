package robot;

/**
 * RobotArms class.
 *
 * @author Ziang Lu
 */
public class RobotArms {

    /**
     * Type of these robot arms.
     */
    private final String type;

    /**
     * Constructor with parameter.
     * @param type type of the robot arms
     */
    public RobotArms(String type) {
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
