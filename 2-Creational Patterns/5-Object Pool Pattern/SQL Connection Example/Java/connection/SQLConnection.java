package connection;

/**
 * SQLConnection class that works as "Client", and actually uses Object Pool
 * Pattern.
 * Object Pool Pattern uses a pool ("ReusablePool") to limit the number of
 * instances created (poolSize) and manage them. In this way, we can share
 * objects ("Reusable" objects) that are expensive to create.
 *
 * @author Ziang Lu
 */
public class SQLConnection {

    /**
     * Connection pooling.
     */
    private static SQLConnectionImplPool pool = SQLConnectionImplPool.getInstance();

    /**
     * Sets the connection pooling size.
     * @param newPoolSize SQL connection pooling size to et
     */
    public static void setPoolSize(int newPoolSize) {
        pool.setPoolSize(newPoolSize);
    }

    /**
     * Underlying connection implementation of this SQL connection.
     */
    private SQLConnectionImpl connectionImpl = null;

    /**
     * Default constructor.
     */
    public SQLConnection() {
        connectionImpl = open();
    }

    /**
     * Private helper method to open this connection.
     * This method will acquire a connection implementation from the connection
     * pooling.
     * @return acquired connection implementation
     */
    private SQLConnectionImpl open() {
        return pool.acquireConnectionImpl();
    }

    /**
     * Operates this SQL connection with the given data.
     * @param data data to transmit
     */
    public void operate(String data) {
        if (connectionImpl != null) {
            connectionImpl.setData(data);
            connectionImpl.operation();
        }
    }

    /**
     * Closes this SQL connection.
     * This method will release a connection implementation back to the
     * connection pooling.
     */
    public void close() {
        if (connectionImpl != null) {
            pool.releaseConnectionImpl(connectionImpl);

            // Nullify the reference to the "Reusable" object
            connectionImpl = null;
        }
    }

}
