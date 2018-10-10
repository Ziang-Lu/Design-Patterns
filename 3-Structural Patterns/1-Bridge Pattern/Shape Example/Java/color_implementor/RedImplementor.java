package color_implementor;

import shape_abstraction.Shape;

/**
 * Concrete RedImplementor class that works as "ConcreteImplementor" to fill a
 * shape with red color.
 * This class is implemented as a singleton class.
 *
 * @author Ziang Lu
 */
public class RedImplementor implements ColorImplementor {

    /**
     * Singleton instance.
     */
    private volatile static RedImplementor instance = null;

    /**
     * Gets the singleton instance.
     * This implementation utilizes Lazy Initialization Pattern and double-check
     * locking mechanism.
     * @return singleton instance
     */
    public static RedImplementor getInstance() {
        if (instance == null) {
            synchronized (RedImplementor.class) {
                if (instance == null) {
                    instance = new RedImplementor();
                }
            }
        }
        return instance;
    }

    /**
     * Private default constructor.
     * This has to be private so that the class instances cannot be created
     * outside of the class.
     */
    private RedImplementor() {}

    @Override
    public void fillColor(Shape shape) {
        System.out.println(shape + " is filled with red color using RedImplementor.");
    }

}
