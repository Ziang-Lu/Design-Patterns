package employee;

/**
 * Abstract ManagementEmployee class that works as "Handler".
 *
 * In order to let different "ConcreteHandler" be able to process the same
 * request, we need them to have similar API.
 * Therefore, we simply let this step be done via letting different
 * "ConcreteHandler" share a common super class "Handler", in which we define
 * the API to process a request.
 *
 * @author Ziang Lu
 */
public abstract class ManagementEmployee {

    /**
     * Supervisor of this management employee.
     * This works as the next receiver (handler) in the chain of responsibility:
     * if this receiver cannot handle the request, then it passes the request to
     * the next receiver in the chain of responsibility.
     */
    private ManagementEmployee supervisor;

    /**
     * Mutator of supervisor.
     * @param employee supervisor to set
     */
    public void setSupervisor(ManagementEmployee employee) {
        this.supervisor = employee;
    }

    /**
     * Gets the max number of leave days this management employee can approve.
     * @return max number approvable leave days
     */
    protected abstract int getMaxApprovableLeaveDays();

    /**
     * Handles the leave request from the given developer for the given number
     * of days.
     * @param developer name of the developer
     * @param requestedLeaveDays requested number of leave days
     * @return whether the leave request is approved
     */
    public boolean handleDeveloperLeaveRequest(String developer, int requestedLeaveDays) {
        if (requestedLeaveDays <= getMaxApprovableLeaveDays()) {
            // This receiver can handle the request.
            // Stop here and return.
            approveLeaveRequest(developer, requestedLeaveDays);
            return true;
        } else {
            // Pass the request to the next receiver in the chain of responsibility
            System.out.print(getClass().getSimpleName() + " cannot approve a " + requestedLeaveDays + "-day leave. ");
            if (supervisor != null) {
                System.out.println("The leave request is handled to " + supervisor.getClass().getSimpleName() + ".");
                return supervisor.handleDeveloperLeaveRequest(developer, requestedLeaveDays);
            } else {
                System.out.println("No more supervisor. The leave request will be rejected.");
                return false;
            }
        }
    }

    /**
     * Private helper method to approve the leave request from the given
     * employee for the given number of days.
     * @param name name of the employee
     * @param requestedLeaveDays requested number of leave days
     */
    private void approveLeaveRequest(String name, int requestedLeaveDays) {
        System.out.println(getClass().getSimpleName() + " approves " + name + " for a " + requestedLeaveDays +
                "-day leave.");
    }

}
