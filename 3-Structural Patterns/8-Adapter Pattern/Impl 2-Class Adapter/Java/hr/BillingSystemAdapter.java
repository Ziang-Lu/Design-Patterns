package hr;

import third_party_billing.Employee;
import third_party_billing.ThirdPartyBillingSystem;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete BillingSystemAdapter that works as "Adapter".
 *
 * Note that in this implementations, we uses Object Adapter:
 * - Since we cannot change the "Target" interface, in order to keep the
 *   original API, we create an "Adapter" class that implements the "Target"
 *   interface.
 * - In order to make the "Target" interface and the "Adaptee" work together, we
 *   let "Adapter" class inherit the "Adaptee" class, and thus inheriting the
 *   methods in the "Adaptee" class, so that it can forward the request from the
 *   client to the correct "Adaptee" class method.
 *
 * This class is implemented as a singleton class.
 *
 * @author Ziang Lu
 */
class BillingSystemAdapter extends ThirdPartyBillingSystem implements CompanyBillingSystem {

    /**
     * Singleton instance.
     */
    private volatile static BillingSystemAdapter instance;

    /**
     * Gets the singleton instance.
     * @return singleton instance
     */
    public static BillingSystemAdapter getInstance() {
        BillingSystemAdapter localRef = instance;
        if (localRef == null) {
            synchronized (BillingSystemAdapter.class) {
                if (localRef == null) {
                    instance = localRef = new BillingSystemAdapter();
                }
            }
        }
        return localRef;
    }

    /**
     * Private static helper method to convert String array of employee
     * information to list of Employee objects.
     * @param employeesInfo employee information
     * @return converted Employee list
     */
    private static List<Employee> employeeStringArrayToList(String[][] employeesInfo) {
        List<Employee> employeeList = new ArrayList<>();
        for (String[] employeeInfo : employeesInfo) {
            int id = Integer.parseInt(employeeInfo[0]);
            String name = employeeInfo[1];
            String designation = employeeInfo[2];
            employeeList.add(new Employee(id, name, designation));
        }
        return employeeList;
    }

    /**
     * Private default constructor.
     * This has to be private so that the class instances cannot be created
     * outside of the class.
     */
    private BillingSystemAdapter() {}

    @Override
    public void processEmployeesSalary(String[][] employeesInfo) {
        // Perform the necessary conversion to make the two independent or incompatible systems work together
        List<Employee> employees = employeeStringArrayToList(employeesInfo);
        System.out.println("\nAdapter finished format conversion of employee information:");
        System.out.println(employees);

        // Forward the request to the correct "Adaptee" class method
        processSalary(employees);
    }

}
