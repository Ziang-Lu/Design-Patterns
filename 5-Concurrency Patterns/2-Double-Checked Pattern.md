# Double-Checked Pattern (双重检查锁定模式)

## Definition & Explanation

The Double-Checked Pattern is a concurrency pattern that **by testing the locking criterion (the "lock hint") before acquiring the lock, reduce the overhead of acquiring a lock and synchronization**. In this way, **locking occurs only if the locking criterion check indicates that locking is required**.

<br>

## Code Example

This pattern is typically <u>used with Singleton Pattern in a multi-threaded environment</u>. Check out the code example:

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
        Singleton localRef = instance;
        if (localRef == null) { // [1]   Thread-A, Thread-B
            synchronized (Singleton.class) { // Thread-A   ->   Thread-B
                // For Thread-A, it simply creates the instance.

                // However, since at the moment Thread-B enters this synchronized block, it has already passed the
                // null-check at [1], so if we don't do another null-check here, Thread-B will again create the
                // instance, which shouldn't be correct.

                // Thus, we need to do another null-check.
                // Now at the moment Thread-B enters this synchronized block, since Thread-A has created the instance,
                // Thread-B will do nothing and exit the block.

                localRef = instance;
                if (instance == null) {
                    instance = localRef = new Singleton();
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
         *
         * Since we used "volatile" keyword on the singleton instance, we used a "localRef", so that the "volatile" field is only accessed once, which can improve the method's overall performance by as much as 25 percent.
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

