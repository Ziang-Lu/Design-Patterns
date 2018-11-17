package school;

import visitor.ChildSpecialistDoctor;
import visitor.Leader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * School class that actually uses Visitor Pattern.
 * The Visitor Pattern separates an algorithm (an operation) from the object
 * structure it operates on, and the executing algorithm (operation) is
 * encapsulated in a visitor object.
 * In this way, we can change the executing algorithm (operation) on each
 * element in the object structure by simply varying the visitor object, without
 * needing to modify the object structure itself.
 *
 * @author Ziang Lu
 */
public class School {

    /**
     * Employees in this school.
     * This works as one object structure, whose elements can be visited by a
     * "Visitor", so that the "Visitor" can perform algorithm (handle operation)
     * on each element.
     */
    private Map<String, Employee> employees = new HashMap<>();
    /**
     * Children in this school.
     * This works as another object structure, whose elements can be visited by
     * a "Visitor", so that the "Visitor" can perform algorithm (handle
     * operation) on each element.
     */
    private List<Visitable> children = new ArrayList<>();

    /**
     * Adds a new employee to this school.
     * @param name name of the new employee
     * @param superiors of the new employee
     */
    public void addEmployee(String name, List<String> superiors) {
        if (superiors.size() == 0) {
            employees.put(name, new Employee(name, superiors));
            return;
        }
        Employee topSuperior = employees.get(superiors.get(0));
        topSuperior.addSubordinate(name, superiors, 0);
    }

    /**
     * Adds a new child to this school.
     * @param name name of the new child
     */
    public void addChild(String name) {
        children.add(new Child(name));
    }

    /**
     * Examines by the given leader.
     * @param leader leader coming to examine
     */
    public void examineBy(Leader leader) {
        System.out.println("Leader comes to examine the school's work.");

        // The given leader is able to visit each employee/child in the employees/children objects structure, and
        // perform desired algorithm (handle operation) on that employee/child.

        for (Employee employee : employees.values()) {
            employee.accept(leader);
        }

        for (Visitable child : children) {
            child.accept(leader);
        }
    }

    /**
     * Performs health check for the children in this school.
     */
    public void performHealthCheck() {
        System.out.println("The school will perform health check for the children.");
        // Create a doctor that is able to visit each child in the children objects structure, and perform desired
        // algorithm (handle operation) on that child
        ChildSpecialistDoctor doctor = new ChildSpecialistDoctor();
        for (Visitable child : children) {
            child.accept(doctor);
        }
    }

}
