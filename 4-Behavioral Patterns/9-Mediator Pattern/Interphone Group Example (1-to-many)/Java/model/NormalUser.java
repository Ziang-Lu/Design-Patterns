package model;

/**
 * Concrete NormalUser class that works as "NormalUser".
 *
 * @author Ziang Lu
 */
public class NormalUser extends User {

    /**
     * Constructor with parameter.
     * @param name name of this user
     */
    public NormalUser(String name) {
        super(name);
    }

    @Override
    public void joinGroup(InterphoneGroup group) {
        this.group = group;
        group.register(this);
    }

}
