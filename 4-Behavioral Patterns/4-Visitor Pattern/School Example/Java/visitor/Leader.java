package visitor;

import school.Child;
import school.Employee;

/**
 * Concrete Leader class that works as "ConcreteVisitor".
 *
 * @author Ziang Lu
 */
public class Leader implements SchoolVisitor {

    @Override
    public void visitEmployee(Employee employee) {
        System.out.println("Leader examines " + employee.getName() + "'s work.");
    }

    @Override
    public void visitChild(Child child) {
        System.out.println("Leader kindly says hi to " + child.getName() + ".");
    }

}
