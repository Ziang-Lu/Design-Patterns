package hr;

/**
 * HumanResourceSystem that actually uses Object Adapter of Adapter Pattern.
 *
 * @author Ziang Lu
 */
public class HumanResourceSystem {

    /**
     * Private static helper method to get the employee information.
     * @return employee information
     */
    private static String[][] getEmployeesInfo() {
        String[][] employeesInfo = new String[4][];
        employeesInfo[0] = new String[]{"100", "Dave", "Team Leader"};
        employeesInfo[1] = new String[]{"101", "Ram", "Developer"};
        employeesInfo[2] = new String[]{"102", "Raj", "Developer"};
        employeesInfo[3] = new String[]{"103", "Rahul", "Tester"};
        return employeesInfo;
    }

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        CompanyBillingSystem companyBillingSystem = BillingSystemAdapter.getInstance();
        System.out.println("Human Resource Department is trying to process salary for the company employees.");
        companyBillingSystem.processEmployeesSalary(getEmployeesInfo());

        /*
         * Output:
         * Human Resource Department is trying to process salary for the company employees.
         *
         * Adapter finished format conversion of employee information:
         * [Employee{id=100, name='Dave, designation='Team Leader}, Employee{id=101, name='Ram, designation='Developer}, Employee{id=102, name='Raj, designation='Developer}, Employee{id=103, name='Rahul, designation='Tester}]
         *
         * Employee{id=100, name='Dave, designation='Team Leader}
         * $12,000 credited to Dave's account
         *
         * Employee{id=101, name='Ram, designation='Developer}
         * $8,000 credited to Ram's account
         *
         * Employee{id=102, name='Raj, designation='Developer}
         * $8,000 credited to Raj's account
         *
         * Employee{id=103, name='Rahul, designation='Tester}
         * $5,000 credited to Rahul's account
         */
    }

}
