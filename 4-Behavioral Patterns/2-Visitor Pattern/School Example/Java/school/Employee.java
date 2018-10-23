package school;

import visitor.SchoolVisitor;

/**
 * Concrete Employee class that works as "ConcreteElement".
 *
 * Note that Employee class can be totally unrelated to Child class, except that
 * they are both Visitable, and can accept a SchoolVisitor
 *
 * @author Ziang Lu
 */
public class Employee implements Visitable {

    /**
     * Name of this employee.
     */
    private final String name;

    /**
     * Constructor with parameter.
     * @param name name of the employee
     */
    Employee(String name) {
        this.name = name;
    }

    /**
     * Accessor of name.
     * @return name
     */
    public String getName() {
        return name;
    }

    @Override
    public void accept(SchoolVisitor visitor) {
        visitor.visitEmployee(this);
    }

}
