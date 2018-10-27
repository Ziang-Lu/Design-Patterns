package employee;

/**
 * HumanResource class that works as "ConcreteHandler".
 *
 * @author Ziang Lu
 */
public class HumanResource extends ManagementEmployee {

    @Override
    protected int getMaxApprovableLeaveDays() {
        // Human Resource can only approve a leave request up to 10 days.
        return 30;
    }

}
