package logger;

import logging.LogLevel;

/**
 * InfoLogger class that works as "ConcreteHandler".
 * This class is implemented as a singleton class.
 *
 * @author Ziang Lu
 */
public class InfoLogger extends Logger {

    /**
     * Singleton instance.
     */
    private volatile static InfoLogger instance;

    /**
     * Gets the singleton instance.
     * This implementation utilizes Lazy Initialization Pattern and double-check
     * locking mechanism.
     * @param logger next logger
     * @return singleton instance
     */
    public static InfoLogger getInstance(Logger logger) {
        InfoLogger localRef = instance;
        if (localRef == null) {
            synchronized (InfoLogger.class) {
                if (localRef == null) {
                    instance = localRef = new InfoLogger(logger);
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
    private InfoLogger(Logger logger) {
        super(logger);
    }

    @Override
    protected LogLevel myLevel() {
        return LogLevel.INFO;
    }

}
