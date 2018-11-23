package flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * FlyweightLetterFactory class that actually uses Flyweight Pattern.
 * Flyweight Pattern stores already existing similar objects
 * ("ConcreteFlyweight") in a cache, so that they can easily be used (shared),
 * and creates a new object only when no matching object is found.
 *
 * This class is implemented as a singleton class.
 *
 * @author Ziang Lu
 */
public class FlyweightLetterFactory {

    /**
     * Singleton instance.
     */
    private volatile static FlyweightLetterFactory instance = null;

    /**
     * Gets the singleton instance.
     * This implementation utilizes Lazy Initialization Pattern and double-check
     * locking mechanism.
     * @return singleton instance
     */
    public static FlyweightLetterFactory getInstance() {
        FlyweightLetterFactory localRef = instance;
        if (localRef == null) {
            synchronized (FlyweightLetterFactory.class) {
                if (localRef == null) {
                    instance = localRef = new FlyweightLetterFactory();
                }
            }
        }
        return localRef;
    }

    /**
     * Cached flyweight letters.
     */
    private Map<Character, Letter> flyweightLetters = new HashMap<>();

    /**
     * Private default constructor.
     * This has to be private so that the class instances cannot be created
     * outside of the class.
     */
    private FlyweightLetterFactory() {}

    /**
     * Gets the flyweight letter of the given character.
     *
     * Note that since we'll be handling a large number of "ConcreteFlyweight"
     * object requests, which may come from multiple threads, we need to take
     * concurrency into consideration.
     * Thus, this implementation utilizes double-check locking mechanism.
     * @param value character of the flyweight letter to get
     * @return flyweight letter
     */
    public Letter getLetter(char value) {
        if (!flyweightLetters.containsKey(value)) {
            flyweightLetters.put(value, new Letter(value));
        }
        return flyweightLetters.get(value);
    }

}
