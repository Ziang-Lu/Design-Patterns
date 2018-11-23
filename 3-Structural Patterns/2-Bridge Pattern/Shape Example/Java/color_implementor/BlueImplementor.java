package color_implementor;

import shape_abstraction.Shape;

/**
 * Concrete BlueImplementor class that works as "ConcreteImplementor" to fill a
 * shape with blue color.
 * This class is implemented as a singleton class.
 *
 * @author Ziang Lu
 */
public class BlueImplementor implements ColorImplementor {

    /**
     * Singleton instance.
     */
    private volatile static BlueImplementor instance = null;

    /**
     * Gets the singleton instance.
     * This implementation utilizes Lazy Initialization Pattern and double-check
     * locking mechanism.
     * @return singleton instance
     */
    public static BlueImplementor getInstance() {
        BlueImplementor localRef = instance;
        if (localRef == null) {
            synchronized (BlueImplementor.class) {
                if (localRef == null) {
                    instance = localRef = new BlueImplementor();
                }
            }
        }
        return localRef;
    }

    /**
     * Private default constructor.
     * This has to be private so that the class instances cannot be created
     * outside of the class.
     */
    private BlueImplementor() {}

    @Override
    public void fillColor(Shape shape) {
        System.out.println(shape + " is filled with blue color using BlueImplementor.");
    }

}
