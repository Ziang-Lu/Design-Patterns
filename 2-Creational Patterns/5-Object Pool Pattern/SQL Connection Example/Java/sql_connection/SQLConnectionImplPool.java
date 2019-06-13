package sql_connection;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * SQLConnectionImplPool class that works as "ReusablePool".
 * "Reusable" class is expensive to instantiate, which means repeatedly
 * allocating and freeing instances of this class individually would be too
 * expensive operations, and thus decrease the performance.
 * Therefore, we can use this class limits the number of instances created
 * (poolSize) and manage them. In this way, we can share objects ("Reusable"
 * objects) that are expensive to create.
 *
 * @author Ziang Lu
 */
class SQLConnectionImplPool {

    /**
     * Default available size.
     */
    private static final int DEFAULT_POOL_SIZE = 10;

    /**
     * Singleton instance.
     */
    private volatile static SQLConnectionImplPool instance = null;

    /**
     * Gets the singleton instance.
     * This implementation utilizes Lazy Initialization Pattern and double-check
     * locking mechanism.
     * @return singleton instance
     */
    static SQLConnectionImplPool getInstance() {
        if (instance == null) {
            synchronized (SQLConnectionImplPool.class) {
                if (instance == null) {
                    instance = new SQLConnectionImplPool();
                }
            }
        }
        return instance;
    }

    /**
     * Private static helper method to clean up the given connection
     * implementation ("Reusable" object).
     * @param connectionImpl connection implementation to clean up
     */
    private static void cleanUp(SQLConnectionImpl connectionImpl) {
        connectionImpl.setData(null);
    }

    /**
     * Pool size.
     */
    private int poolSize;
    /**
     * Number of connection implementations ("Reusable" objects) created.
     */
    private int numOfCreated;
    /**
     * Available connection implementations ("Reusable" objects).
     */
    private final Queue<SQLConnectionImpl> available;

    /**
     * Default constructor.
     */
    private SQLConnectionImplPool() {
        poolSize = DEFAULT_POOL_SIZE;
        numOfCreated = 0;
        available = new ArrayDeque<>();
    }

    /**
     * Sets a new pool size.
     * @param newPoolSize new pool size
     */
    void setPoolSize(int newPoolSize) {
        if (newPoolSize < numOfCreated) {
            System.out.println("Cannot set a pool size smaller than number of instances already created");
            return;
        }
        poolSize = newPoolSize;
    }

    /**
     * Acquires a connection implementation ("Reusable" object) from this pool.
     * @return acquired connection implementation
     */
    SQLConnectionImpl acquireConnectionImpl() {
        // Synchronize on the pool
        synchronized (available) {
            SQLConnectionImpl connectionImpl = null;
            while (connectionImpl == null) {
                // Check if there is any "Reusable" object in the pool
                if (!available.isEmpty()) {
                    // Simply return an available "Reusable" object in the pool
                    connectionImpl = available.poll();
                } else if (numOfCreated < poolSize) { // Check whether the pool has reached its maximum size
                    // Create a new "Reusable" object
                    connectionImpl = new SQLConnectionImpl();
                    ++numOfCreated;
                } else {
                    // Wait for a previously created, currently using by a previous client "Reusable" object to be released
                    // back to the pool, and then return that "Reusable" object
                    try {
                        available.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            return connectionImpl;
        }
    }

    /**
     * Releases the given connection implementation ("Reusable object") back to
     * the pool.
     * @param connectionImpl connection implementation to release
     */
    void releaseConnectionImpl(SQLConnectionImpl connectionImpl) {
        // Synchronize on the pool
        synchronized (available) {
            // Clean up the "Reusable" object
            cleanUp(connectionImpl);

            available.offer(connectionImpl);
            available.notifyAll();
        }
    }

}
