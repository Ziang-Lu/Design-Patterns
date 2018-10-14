package third_party_billing;

import java.util.List;

/**
 * ThirdPartyBillingSystem class that works as "Adaptee".
 *
 * By comparing the signatures of processSalary() method and the
 * CompanyBillingSystem.processEmployeesSalary() method, we can find that this
 * class and the ThirdPartyBillingSystem are independent or incompatible
 * systems.
 *
 * @author Ziang Lu
 */
public class ThirdPartyBillingSystem {

    /**
     * Calculates the salary of the given employees, and credit it to their
     * corresponding bank account.
     * @param employees given employees
     */
    public void processSalary(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println('\n' + employee.toString());
            String designation = employee.getDesignation();
            int salary = 0;
            if (designation.equalsIgnoreCase("Team Leader")) {
                salary = 12000;
            } else if (designation.equalsIgnoreCase("Developer")) {
                salary = 8000;
            } else if (designation.equalsIgnoreCase("Tester")) {
                salary = 5000;
            }
            System.out.println(String.format("$%,d credited to %s's account", salary, employee.getName()));
        }
    }

}
