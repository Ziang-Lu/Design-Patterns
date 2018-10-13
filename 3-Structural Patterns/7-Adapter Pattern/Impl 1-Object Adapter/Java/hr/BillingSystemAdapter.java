package hr;

import third_party_billing.Employee;
import third_party_billing.ThirdPartyBillingSystem;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete BillingSystemAdapter class that works as "Adapter".
 *
 * Note that in this implementations, we uses Object Adapter:
 * - Since we cannot change the "Target" interface, in order to keep the
 *   original API, we create an "Adapter" class that implements the "Target"
 *   interface.
 * - In order to make the "Target" interface and the "Adaptee" work together, in
 *   the "Adapter" class, we simply keep a referent to the "Adaptee" object, and
 *   delegate the request from the client to this "Adaptee" object.
 *
 * This class is implemented as a singleton class.
 *
 * @author Ziang Lu
 */
class BillingSystemAdapter extends CompanyBillingSystem {

    /**
     * Singleton instance.
     */
    private volatile static BillingSystemAdapter instance;

    /**
     * Gets the singleton instance.
     * This implementation utilizes Lazy Initialization Pattern and double-check
     * locking mechanism.
     * @return singleton instance
     */
    public static BillingSystemAdapter getInstance() {
        if (instance == null) {
            synchronized (BillingSystemAdapter.class) {
                if (instance == null) {
                    instance = new BillingSystemAdapter();
                }
            }
        }
        return instance;
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
     * Reference to the adaptee object.
     */
    private ThirdPartyBillingSystem adaptee = new ThirdPartyBillingSystem();

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

        // Delegate the request to the adaptee object
        adaptee.processSalary(employees);
    }

}
