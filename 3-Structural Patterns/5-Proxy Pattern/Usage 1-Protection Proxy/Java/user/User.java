package user;

/**
 * User class.
 *
 * @author Ziang Lu
 */
public class User {

    /**
     * Username of this user.
     */
    private final String username;
    /**
     * Password of this user.
     */
    private final String password;
    /**
     * Designation of this user.
     */
    private String designation;

    /**
     * Constructor with parameter.
     * @param username username of the user
     * @param password password of the user
     * @param designation designation of the user
     */
    public User(String username, String password, String designation) {
        this.username = username;
        this.password = password;
        this.designation = designation;
    }

    /**
     * Accessor of designation.
     * @return designation
     */
    public String designation() {
        return designation;
    }

}
