package model.receiver;

import java.util.Calendar;

/**
 * DailyReportGenerator class that works as the "Receiver".
 *
 * This class is implemented as a singleton class.
 *
 * @author Ziang Lu
 */
public class DailyReportGenerator {

    /**
     * Singleton instance.
     */
    private volatile static DailyReportGenerator instance = null;

    /**
     * Gets the singleton instance.
     * This implementation utilizes Lazy Initialization Pattern and double-check
     * locking mechanism.
     * @return singleton instance
     */
    public static DailyReportGenerator getInstance() {
        if (instance == null) {
            synchronized (DailyReportGenerator.class) {
                if (instance == null) {
                    instance = new DailyReportGenerator();
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
    private DailyReportGenerator() {}

    /**
     * Generates a daily report.
     */
    public void generateDailyReport() {
        System.out.println("<Daily Report Generator> is generating a daily report:");
        System.out.println("**********");
        System.out.println(Calendar.getInstance().getTime());
        System.out.println("**********");
    }

}
