package logger;

import logging.LogLevel;

/**
 * WarningLogger class that works as "ConcreteHandler".
 * This class is implemented as a singleton class.
 *
 * @author Ziang Lu
 */
public class WarningLogger extends Logger {

    /**
     * Singleton instance.
     */
    private volatile static WarningLogger instance;

    /**
     * Gets the singleton instance.
     * This implementation utilizes Lazy Initialization Pattern and double-check
     * locking mechanism.
     * @param logger next logger
     * @return singleton instance
     */
    public static WarningLogger getInstance(Logger logger) {
        WarningLogger localRef = instance;
        if (localRef == null) {
            synchronized (WarningLogger.class) {
                if (localRef == null) {
                    instance = localRef = new WarningLogger(logger);
                }
            }
        }
        return localRef;
    }

    /**
     * Private default constructor.
     * This has to be private so that the class instances cannot be created
     * outside of the class.
     * @param logger next logger
     */
    private WarningLogger(Logger logger) {
        super(logger);
    }

    @Override
    protected LogLevel myLevel() {
        return LogLevel.WARNING;
    }

}
