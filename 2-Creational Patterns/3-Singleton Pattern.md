# Singleton Pattern (单例模式)

### Applicability

* Exactly one object is needed to coordinate actions across the system.

  *Object只要一个就刚刚好*

* The system operates more efficiently with only one object exists.

  *Object一个或多个都可以, 但显然一个效率系统执行更高*

* How can a class control its instantiation?

* How can the sole instance of a class be accessed easily?

  *This might involves thread-safety issues and JVM instruction reordering issues as will be demonstrated in the code example.*

<br>

### Definition & Explanation

=> SIngle Pattern is a **creational pattern** that combines Factory Method Pattern and Lazy Initialization Pattern, which **restricts the instantiation of a class to only one single object**.

Make the class itself responsible for controlling its instantiation (that it is instantiated only once).

An implementation of the Singleton Pattern must:

* Ensure that <u>only one instance of the singleton class ever exists</u>;
* Provide global access to that instance.

<br>

### Common Uses

* Facade objects (门面对象) are often singletons because only one facade object is required.
* State objects (状态对象) are often singletons.

<br>

### Code Example

```java
public class Singleton {

    /**
     * Singleton instance.
     *
     * The use of "volatile" keyword restricts, around accessing this variable, instruction reordering conducted by JVM,
     * and thus ensures the order of compiled instructions. In other words, whenever JVM executes the creation of the
     * instance, it is guaranteed that the instructions are strictly in the following order:
     * 1. memory = allocate();  // Allocate the memory for the object
     * 2. ConstructInstance(memory);  // Construct the object
     * 3. instance = memory;  // Let instance points to the memory that just got allocated
     * In this way, instance either points to null, or an object that finished initialization, but not an intermediate
     * state, which is correct.
     */
    private volatile static Singleton instance = null;

    /**
     * Factory method to get the singleton instance.
     * However, this implementation with Lazy Initialization Pattern is
     * thread-unsafe. Check out the comments in the method body.
     * @return singleton instance
     */
    public static Singleton getInstanceThreadUnsafe() {
        if (instance == null) { // Thread-A, Thread B
            instance = new Singleton(); // Thread-A, Thread-B
            // In this case, this instance is created twice, which shouldn't be correct.
        }
        return instance;
    }

    /**
     * Factory method to get the singleton instance.
     * To avoid the above case, use a double-check locking mechanism.
     * @return singleton instance
     */
    public static Singleton getInstanceThreadSafe() {
        if (instance == null) { // [1]   Thread-A, Thread-B
            synchronized (Singleton.class) { // Thread-A   ->   Thread-B
                // For Thread-A, it simply creates the instance.

                // However, since at the moment Thread-B enters this synchronized block, it has already passed the
                // null-check at [1], so if we don't do another null-check here, Thread-B will again create the
                // instance, which shouldn't be correct.

                // Thus, we need to do another null-check.
                // Now at the moment Thread-B enters this synchronized block, since Thread-A has created the instance,
                // Thread-B will do nothing and exit the block.
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
        /*
         * This implementation looks perfect, at least in theory. However, it is practically not.
         *
         * The creation of an object is actually compiled to the following three instructions:
         * 1. memory = allocate();  // Allocate the memory for the object
         * 2. ConstructInstance(memory);  // Construct the object
         * 3. instance = memory;  // Let instance points to the memory that just got allocated
         *
         * However, JVM compiler and CPU might do some optimization, i.e., instruction reordering, resulting in the
         * following instructions:
         * 1. memory = allocate();  // Allocate the memory for the object
         * 3. instance = memory;  // Let instance points to the memory that just got allocated
         * 2. ConstructInstance(memory);  // Construct the object
         *
         * Imagine a scenario that Thread-A and Thread-B come into the methods one by one
         * When Thread-A is creating the object, specifically just finished (3), instance now points to some memory
         * address (not null) which haven't finish initialization.
         * Now if Thread-B gets the CPU resource and execute the null-check, it will be false, and Thread-B will simply
         * return instance. However, the instance haven't finish initialization!
         *
         * => Use "volatile" keyword on the singleton instance. Check out the comments on the singleton instance.
         */
    }

    /**
     * Private default constructor.
     * This has to be private so that the class instances cannot be created\
     * outside of the class.
     */
    private Singleton() {}

}

```

<br>

### Benefits

Singletons are often preferred to global variables because:

* They do not pollute the global namespace with unnecessary variables.
* They permit lazy allocation and initialization, whereas global variables in many languages will always consume resources.

<br>

### Drawback

Some people are critical of the Singleton Pattern and consider it to be an anti-pattern (反模式), in that it is frequently used in scenarios where <u>it is not beneficial, introduces unnecessary restrictions in situations where a sole instance of a class is not actually required, and introduces global state into an application</u>.

