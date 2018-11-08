package model;

/**
 * Concrete LeaderUser class that works as "NormalUser".
 *
 * @author Ziang Lu
 */
public class LeaderUser extends User {

    /**
     * Constructor with parameter.
     * @param name name of this user
     */
    public LeaderUser(String name) {
        super(name);
    }

    @Override
    public void joinGroup(InterphoneGroup group) {
        this.group = group;
        group.register(this);
    }

}
