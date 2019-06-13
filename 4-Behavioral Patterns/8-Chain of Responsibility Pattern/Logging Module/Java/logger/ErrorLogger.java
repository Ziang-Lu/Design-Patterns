package logger;

import logging.LogLevel;

/**
 * ErrorLogger class that works as "ConcreteHandler".
 * This class is implemented as a singleton class.
 *
 * @author Ziang Lu
 */
public class ErrorLogger extends Logger {

    /**
     * Singleton instance.
     */
    private volatile static ErrorLogger instance;

    /**
     * Gets the singleton instance.
     * This implementation utilizes Lazy Initialization Pattern and double-check
     * locking mechanism.
     * @return singleton instance
     */
    public static ErrorLogger getInstance(Logger logger) {
        if (instance == null) {
            synchronized (ErrorLogger.class) {
                if (instance == null) {
                    instance = new ErrorLogger(logger);
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
    private ErrorLogger() {
        super(null);
    }

    @Override
    protected LogLevel myLevel() {
        return LogLevel.ERROR;
    }

}
