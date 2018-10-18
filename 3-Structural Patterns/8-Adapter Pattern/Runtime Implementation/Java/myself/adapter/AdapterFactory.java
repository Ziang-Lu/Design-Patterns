package myself.adapter;

import java.util.HashMap;
import java.util.Map;

/**
 * AdapterFactory class.
 * Through the use of an adapter factory, we can achieve runtime looking up and
 * get the required adapter.
 * This class is implemented as a singleton class.
 *
 * @author Ziang Lu
 */
public class AdapterFactory {

    /**
     * Singleton instance.
     */
    private volatile static AdapterFactory instance = null;

    /**
     * Gets the singleton instance.
     * This implementation utilizes Lazy Initialization Pattern and double-check
     * locking mechanism.
     * @return singleton instance
     */
    public static AdapterFactory getInstance() {
        if (instance == null) {
            synchronized (AdapterFactory.class) {
                if (instance == null) {
                    instance = new AdapterFactory();
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
    private AdapterFactory() {}

    /**
     * Registered adapters.
     */
    private Map<Class<?>, Map<Class<?>, Class<? extends Adapter>>> adaptersMap = new HashMap<>();

    /**
     * Registers the given adapter, which adapts an object of "from" class to an
     * object of "to" class (and these classes are otherwise independent or
     * incompatible) using the given adapter.
     * @param from class of the adapted object
     * @param to class of the object to adapt to
     * @param adapterType adapter type used to do the adaption
     */
    public void registerAdapter(Class<?> from, Class<?> to, Class<? extends Adapter> adapterType) {
        Map<Class<?>, Class<? extends Adapter>> fromMap = adaptersMap.getOrDefault(from, new HashMap<>());
        fromMap.put(to, adapterType);
        adaptersMap.put(from, fromMap);
    }

    /**
     * Looks up and gets an adapter at runtime which adapts an object of "from"
     * class to an object of "to" class, and these two class are otherwise
     * independent or incompatible.
     * @param from class of the adapted object
     * @param to class of the object to adapt to
     * @return generated adapter
     */
    public Adapter getAdapterFromTo(Class<?> from, Class<?> to) {
        Class<? extends Adapter> adapterType = adaptersMap.get(from).get(to);
        Adapter adapter = null;
        try {
            adapter = adapterType.getConstructor().newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return adapter;
    }

}
