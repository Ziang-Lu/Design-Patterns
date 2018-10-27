package connection;

/**
 * SQLConnectionImpl class that works as "Reusable".
 * This class is expensive to instantiate, and thus can be put in a pool, and be
 * reused and shared later.
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
     * Mutator of data.
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
        // Sleep 3 seconds to simulate the data transmission
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
