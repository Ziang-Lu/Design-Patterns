package sql_connection;

/**
 * SQLConnectionImpl class that works as "Reusable".
 * This class is expensive to instantiate, which means repeatedly allocating and
 * freeing instances of this class individually would be too expensive
 * operations, and thus decrease the performance.
 * Therefore, we can put the instances of this class in a pool for later reuse.
 *
 * @author Ziang Lu
 */
class SQLConnectionImpl {

    /**
     * Underlying data to transmit by this SQL connection implementation.
     */
    private String data;

    /**
     * Default constructor.
     */
    SQLConnectionImpl() {
        // Sleep 1 second to simulate the expensive instantiation process
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sets the underlying data to transmit.
     * @param data data to set
     */
    void setData(String data) {
        this.data = data;
    }

    /**
     * Operate this SQL connection implementation to transmit the underlying data.
     */
    void operation() {
        System.out.println("SQL Connection Implementation operating " + data + " to SQL Server");
        // Sleep 3 seconds to simulate the data transmission process
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
