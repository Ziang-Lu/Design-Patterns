package model.receiver;

import java.util.Calendar;
import java.util.Random;

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
        DailyReportGenerator localRef = instance;
        if (localRef == null) {
            synchronized (DailyReportGenerator.class) {
                if (localRef == null) {
                    instance = localRef = new DailyReportGenerator();
                }
            }
        }
        return localRef;
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
        System.out.println(Thread.currentThread().getName() +
                " <Daily Report Generator> is generating a daily report...");
        try {
            Thread.sleep((new Random().nextInt(8) + 1) * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("***** Daily Report *****");
        System.out.println(Calendar.getInstance().getTime());
        System.out.println("************************");
    }

}
