package third_party_billing;

/**
 * Employee class.
 *
 * @author Ziang Lu
 */
public class Employee {

    /**
     * ID of this employee.
     */
    private final int id;
    /**
     * Name of this employee.
     */
    private final String name;
    /**
     * Designation of this employee.
     */
    private String designation;

    /**
     * Constructor with parameter.
     * @param id ID of the employee
     * @param name name of the employee
     * @param designation designation of the employee
     */
    public Employee(int id, String name, String designation) {
        this.id = id;
        this.name = name;
        this.designation = designation;
    }

    /**
     * Accessor of name.
     * @return name
     */
    String getName() {
        return name;
    }

    /**
     * Accessor of designation.
     * @return designation
     */
    String getDesignation() {
        return designation;
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + ", designation='" + designation + "}";
    }

}
