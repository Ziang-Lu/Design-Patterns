package logger;

import logging.LogLevel;

/**
 * Abstract Logger class that works as "Handler".
 *
 * In order to let different "ConcreteHandler" be able to process the same
 * request, we need them to have similar API.
 * Therefore, we simply let this step be done via letting different
 * "ConcreteHandler" share a common super class "Handler", in which we define
 * the API to process a request.
 *
 * @author Ziang Lu
 */
public abstract class Logger {

    /**
     * Next logger of this logger.
     * This works as the next receiver (handler) in the chain of responsibility:
     * if this receiver cannot handle the request, then it passes the request to
     * the next receiver in the chain of responsibility.
     */
    private Logger nextLogger;

    /**
     * Constructor with parameter.
     * @param nextLogger next logger
     */
    protected Logger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    /**
     * Gets the level of this logger.
     * @return level of this logger
     */
    protected abstract LogLevel myLevel();

    /**
     * Handles the log request of the given level.
     * @param msg message to log
     * @param level log level
     */
    public void handleLogRequest(String msg, LogLevel level) {
        if (level.level() >= myLevel().level()) {
            // This receiver handles the request.
            logMessage(msg, level);

            if (nextLogger != null) {
                // Pass the request to the next receiver in the chain of responsibility
                nextLogger.handleLogRequest(msg, level);
            }
        }
    }

    /**
     * Private helper method to log the given message of the given level.
     * @param msg message to log
     * @param level log level
     */
    private void logMessage(String msg, LogLevel level) {
        System.out.println(getClass().getSimpleName() + ": logging a " + level + " message: " + msg);
    }

}
