package prototype;

/**
 * Abstract Prototype class.
 *
 * Note that according to the documentation of Object, any class overriding
 * clone() method better calls super.clone() first, so this will trace up to
 * Object.clone().
 *
 * However, according to the documentation of Cloneable interface, for any
 * class that doesn't implement Cloneable interface, calling clone() method on
 * an object of that class will throw CloneNotSupportedException. Since Object
 * class itself doesn't implement Cloneable interface, calling Object.clone()
 * will throw CloneNotSupportedException.
 *
 * Therefore, if we want to use Prototype.clone() method, we need to let it
 * implement Cloneable interface, to indicate to Object.clone() method that
 * it is legal for that method to make a field-for-field copy of instances of
 * that class.
 *
 * @author Ziang Lu
 */
public abstract class Prototype implements Cloneable {

    /**
     * By convention, classes that implement Cloneable interface should override
     * Object.clone() method (which is protected) with a public method.
     * @return cloned object
     * @throws CloneNotSupportedException if this class is not cloneable
     */
    @Override
    public Prototype clone() throws CloneNotSupportedException {
        return (Prototype) super.clone();
    }

}
