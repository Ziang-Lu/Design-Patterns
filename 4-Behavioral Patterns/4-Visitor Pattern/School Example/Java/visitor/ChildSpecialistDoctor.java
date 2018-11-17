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
     * Count of children in good health.
     */
    private int goodCount = 0;
    /**
     * Count of children in bad health.
     */
    private int badCount = 0;

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
            child.setHealthStatus(Child.HealthStatus.GOOD);
            ++goodCount;
        } else {
            System.out.println("and found that " + child.getName() +
                    " is NOT in good health. Please go to the hospital someday.");
            child.setHealthStatus(Child.HealthStatus.BAD);
            ++badCount;
        }
    }

    /**
     * Reports the health ratio of the school.
     */
    public void reportHealthRatio() {
        double healthRatio = 1.0 * goodCount / (goodCount + badCount);
        System.out.println("Health ratio of the school: " + healthRatio);
    }

}
