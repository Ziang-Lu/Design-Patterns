package visitor;

import school.Child;
import school.Employee;

import java.util.Random;

/**
 * Concrete ChildSpecialistDoctor class that works as "ConcreteVisitor".
 *
 * @author Ziang Lu
 */
public class ChildSpecialistDoctor implements SchoolVisitor {

    /**
     * Random number generator to use.
     */
    private Random randomGenerator = new Random();

    @Override
    public void visitEmployee(Employee employee) {
        // Do nothing
    }

    @Override
    public void visitChild(Child child) {
        System.out.print("Child Specialist Doctor is checking health status for " + child.getName() + "...");
        if (randomGenerator.nextBoolean()) {
            System.out.println("and found that " + child.getName() + " is in good health!");
            child.setHealthStatus("Good");
        } else {
            System.out.println("and found that " + child.getName() +
                    " is NOT in good health. Please go to the hospital someday.");
            child.setHealthStatus("Bad");
        }
    }

}
