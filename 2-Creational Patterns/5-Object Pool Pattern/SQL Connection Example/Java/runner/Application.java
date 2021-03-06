package runner;

import sql_connection.SQLConnection;

/**
 * MyThread class.
 */
class MyThread extends Thread {
    /**
     * Constructor with parameter.
     * @param name thread name
     */
    MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        SQLConnection connection = null;
        try {
            connection = new SQLConnection();
            connection.operate("[" + getName() + " data]");
        } finally {
            connection.close();
        }
    }
}

/**
 * Application that actually uses Object Pool Pattern.
 *
 * @author Ziang Lu
 */
public class Application {

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        for (int i = 0; i < 20; ++i) {
            Thread th = new MyThread("Thread-" + i);
            th.start();
        }

        /*
         * Output:
         * SQL Connection Implementation operating [Thread-0 data] to SQL Server
         * SQL Connection Implementation operating [Thread-19 data] to SQL Server
         * SQL Connection Implementation operating [Thread-18 data] to SQL Server
         * SQL Connection Implementation operating [Thread-17 data] to SQL Server
         * SQL Connection Implementation operating [Thread-16 data] to SQL Server
         * SQL Connection Implementation operating [Thread-15 data] to SQL Server
         * SQL Connection Implementation operating [Thread-14 data] to SQL Server
         * SQL Connection Implementation operating [Thread-13 data] to SQL Server
         * SQL Connection Implementation operating [Thread-12 data] to SQL Server
         * SQL Connection Implementation operating [Thread-11 data] to SQL Server
         * SQL Connection Implementation operating [Thread-2 data] to SQL Server
         * SQL Connection Implementation operating [Thread-6 data] to SQL Server
         * SQL Connection Implementation operating [Thread-1 data] to SQL Server
         * SQL Connection Implementation operating [Thread-7 data] to SQL Server
         * SQL Connection Implementation operating [Thread-3 data] to SQL Server
         * SQL Connection Implementation operating [Thread-4 data] to SQL Server
         * SQL Connection Implementation operating [Thread-5 data] to SQL Server
         * SQL Connection Implementation operating [Thread-8 data] to SQL Server
         * SQL Connection Implementation operating [Thread-10 data] to SQL Server
         * SQL Connection Implementation operating [Thread-9 data] to SQL Server
         */
    }

}
