package myself.adapter;

/**
 * Abstract Adapter interface.
 * An adapter adapts an object from some interface to an object of another
 * interface, and these two interfaces are otherwise independent or
 * incompatible.
 *
 * @author Ziang Lu
 */
public interface Adapter {

    /**
     * Adapts the given object of some interface to an object of another
     * interface, and these two interfaces are otherwise independent or
     * incompatible.
     * @param from object to be adapted
     * @return adapted object
     */
    Object adapt(Object from);

}
