package visitor;

import school.Child;
import school.Employee;

/**
 * Abstract SchoolVisitor class that works as "Visitor".
 * This class encapsulates the executing algorithm (operation) on elements in
 * the object structure, and can visit each "Element" in the object structure,
 * and perform desired algorithm (handle operation) on that "Element".
 *
 * @author Ziang Lu
 */
public interface SchoolVisitor {

    /**
     * Lets this school visitor visit the given employee, and perform desired
     * algorithm (handle operation) on it.
     * @param employee employee to visit
     */
    void visitEmployee(Employee employee);

    /**
     * Lets this school visitor visit the given child, and perform desired
     * algorithm (handle operation) on it.
     * @param child child to visit
     */
    void visitChild(Child child);

}
