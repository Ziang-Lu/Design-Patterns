package runner;

import school.School;
import visitor.Leader;

/**
 * Application.
 *
 * @author Ziang Lu
 */
public class VisitorPatternTest {

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        School school = new School();
        school.addEmployee("Steve");
        school.addEmployee("Tony");
        school.addChild("Bruce");
        school.addChild("Nathasha");
        school.addChild("Clint");

        school.performHealthCheck();

        System.out.println();
        school.examineBy(new Leader());

        /*
         * Output:
         * The school will perform health check for the children.
         * Child Specialist Doctor is checking health status for Bruce...and found that Bruce is in good health!
         * Child Specialist Doctor is checking health status for Nathasha...and found that Nathasha is in good health!
         * Child Specialist Doctor is checking health status for Clint...and found that Clint is in good health!
         *
         * Leader comes to examine the school's work.
         * Leader examines Steve's work.
         * Leader examines Tony's work.
         * Leader kindly says hi to Bruce.
         * Leader kindly says hi to Nathasha.
         * Leader kindly says hi to Clint.
         */
    }

}
