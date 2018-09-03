package robot;

/**
 * RobotLegs class.
 *
 * @author Ziang Lu
 */
public class RobotLegs {

    /**
     * Type of these robot legs.
     */
    private final String type;

    /**
     * Constructor with parameter.
     * @param type type of the robot legs
     */
    public RobotLegs(String type) {
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
