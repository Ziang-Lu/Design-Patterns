package employee;

/**
 * TeamLeader class that works as "ConcreteHandler".
 *
 * @author Ziang Lu
 */
public class TeamLeader extends ManagementEmployee {

    @Override
    protected int getMaxApprovableLeaveDays() {
        // Team Leader can only approve a leave request up to 10 days.
        return 10;
    }

}
