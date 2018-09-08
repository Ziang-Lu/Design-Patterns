package scouting.scouting_model;

/**
 * Concrete Scout class.
 *
 * @author Ziang Lu
 */
public class Scout extends ScoutingModel {

    /**
     * Name of this scout.
     */
    private final String name;

    /**
     * Constructor with parameter.
     * @param name name of the scout
     */
    public Scout(String name) {
        this.name = name;
    }

    /**
     * Accessor of name.
     * @return name
     */
    public String getName() {
        return name;
    }

}
