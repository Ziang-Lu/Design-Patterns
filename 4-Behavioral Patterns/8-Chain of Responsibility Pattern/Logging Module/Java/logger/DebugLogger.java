package logger;

import logging.LogLevel;

/**
 * DebugLogger class that works as "ConcreteHandler".
 * This class is implemented as a singleton class.
 *
 * @author Ziang Lu
 */
public class DebugLogger extends Logger {

    /**
     * Singleton instance.
     */
    private volatile static DebugLogger instance;

    /**
     * Gets the singleton instance.
     * This implementation utilizes Lazy Initialization Pattern and double-check
     * locking mechanism.
     * @param logger next logger
     * @return singleton instance
     */
    public static DebugLogger getInstance(Logger logger) {
        DebugLogger localRef = instance;
        if (localRef == null) {
            synchronized (DebugLogger.class) {
                if (localRef == null) {
                    instance = localRef = new DebugLogger(logger);
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
    private DebugLogger(Logger logger) {
        super(logger);
    }

    @Override
    protected LogLevel myLevel() {
        return LogLevel.DEBUG;
    }

}
