package prototype;

/**
 * Abstract Animal class.
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
 * Therefore, if we want to use Animal.clone() method, we need to let it
 * implement Cloneable interface, to indicate to Object.clone() method that it
 * is legal for that method to make a field-for-field copy of instances of that
 * class.
 *
 * @author Ziang Lu
 */
public abstract class Animal implements Cloneable {

    /**
     * By convention, classes that implement Cloneable interface should override
     * Object.clone() method (which is protected) with a public method.
     * @return cloned object
     * @throws CloneNotSupportedException if this class is not cloneable
     */
    @Override
    public Animal clone() throws CloneNotSupportedException {
        return (Animal) super.clone();
    }

}
