package employee;

/**
 * ProjectLeader class that works as "ConcreteHandler".
 *
 * @author Ziang Lu
 */
public class ProjectLeader extends ManagementEmployee {

    @Override
    protected int getMaxApprovableLeaveDays() {
        // Project leader can only approve a leave request up to 20 days.
        return 20;
    }

}
