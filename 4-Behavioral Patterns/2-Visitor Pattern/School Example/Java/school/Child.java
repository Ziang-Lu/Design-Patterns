package school;

import visitor.SchoolVisitor;

/**
 * Concrete Child class that works as "ConcreteElement".
 *
 * Note that Child class can be totally unrelated to Employee class, except that
 * they are both Visitable, and can accept a SchoolVisitor
 *
 * @author Ziang Lu
 */
public class Child implements Visitable {

    /**
     * Health status enumeration.
     */
    public enum HealthStatus {
        GOOD, BAD
    }

    /**
     * Name of this child.
     */
    private final String name;
    /**
     * Health status of this child.
     */
    private HealthStatus healthStatus;

    /**
     * Constructor with parameter.
     * @param name name of the child
     */
    Child(String name) {
        this.name = name;
        healthStatus = HealthStatus.GOOD;
    }

    /**
     * Accessor of name.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Mutator of healthStatus.
     * @param healthStatus health status to set
     */
    public void setHealthStatus(HealthStatus healthStatus) {
        this.healthStatus = healthStatus;
    }

    @Override
    public void accept(SchoolVisitor visitor) {
        visitor.visitChild(this);
    }

}
