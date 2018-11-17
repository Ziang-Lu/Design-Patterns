package school;

import visitor.SchoolVisitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
     * Superiors of this employee.
     */
    private List<String> superiors;
    /**
     * Subordinates of this employee.
     */
    private Map<String, Employee> subordinates;

    /**
     * Constructor with parameter.
     * @param name name of the employee
     * @param superiors list of superiors
     */
    Employee(String name, List<String> superiors) {
        this.name = name;
        this.superiors = superiors;
        subordinates = new HashMap<>();
    }

    /**
     * Accessor of name.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Adds a subordinate to this employee.
     * @param name name of the new employee
     * @param superiors list of superiors of the new employee
     * @param currIdx index of the current employee in the superiors list
     */
    void addSubordinate(String name, List<String> superiors, int currIdx) {
        // Basic case
        if (currIdx >= (superiors.size() - 1)) {
            subordinates.put(name, new Employee(name, superiors));
            return;
        }
        // Recursive case
        Employee nextSuperior = subordinates.get(superiors.get(currIdx + 1));
        nextSuperior.addSubordinate(name, superiors, currIdx + 1);
    }

    @Override
    public void accept(SchoolVisitor visitor) {
        visitor.visitEmployee(this);
        for (Employee subordinate : subordinates.values()) {
            subordinate.accept(visitor);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Employee)) {
            return false;
        }
        Employee another = (Employee) o;
        return name.equals(another.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

}
