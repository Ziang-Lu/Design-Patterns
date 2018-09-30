package runner;

import employee.HumanResource;
import employee.ManagementEmployee;
import employee.ProjectLeader;
import employee.TeamLeader;

/**
 * Application that actually uses Chain of Responsibility Pattern.
 * In this example, ONLY ONE receiver object in the chain handles the request.
 *
 * @author Ziang Lu
 */
public class Application {

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        ManagementEmployee teamLeader = new TeamLeader();
        ManagementEmployee projectLeader = new ProjectLeader();
        teamLeader.setSupervisor(projectLeader);
        ManagementEmployee hr = new HumanResource();
        projectLeader.setSupervisor(hr);

        teamLeader.handleDeveloperLeaveRequest("David", 9);

        System.out.println();
        teamLeader.handleDeveloperLeaveRequest("John", 18);

        System.out.println();
        teamLeader.handleDeveloperLeaveRequest("Steve", 30);

        System.out.println();
        teamLeader.handleDeveloperLeaveRequest("Rohan", 50);

        /*
         * Output:
         * TeamLeader approves David for a 9-day leave.
         *
         * TeamLeader cannot approve a 18-day leave. The leave request is handled to HumanResource.
         * HumanResource approves John for a 18-day leave.
         *
         * TeamLeader cannot approve a 30-day leave. The leave request is handled to HumanResource.
         * HumanResource approves Steve for a 30-day leave.
         *
         * TeamLeader cannot approve a 50-day leave. The leave request is handled to HumanResource.
         * HumanResource cannot approve a 50-day leave. No more supervisor. The leave request will be rejected.
         */
    }

}
