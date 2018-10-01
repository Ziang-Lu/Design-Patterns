package logging;

import logger.DebugLogger;
import logger.ErrorLogger;
import logger.InfoLogger;
import logger.Logger;
import logger.WarningLogger;

/**
 * LoggingManager class.
 *
 * @author Ziang Lu
 */
public class LoggingManager {

    /**
     * First logger to handle log requests.
     */
    private final Logger firstLogger;
    /**
     * Set-up logging level.
     */
    private LogLevel loggingLevel;

    /**
     * Default constructor.
     */
    public LoggingManager() {
        // Chain the loggers, which is the chain of responsibility
        firstLogger = InfoLogger.getInstance(
                DebugLogger.getInstance(WarningLogger.getInstance(ErrorLogger.getInstance()))
        );
    }

    /**
     * Mutator of loggingLevel.
     * @param level logging level to set
     */
    public void setLevel(LogLevel level) {
        loggingLevel = level;
    }

    /**
     * Logs the given message of the given level.
     * @param msg message to log
     * @param level log level
     */
    public void logMessage(String msg, LogLevel level) {
        firstLogger.handleLogRequest(msg, level);
    }

    /**
     * Logs the given message using the set-up logging level in this logging
     * manager.
     * @param msg message to log
     */
    public void logMessage(String msg) {
        logMessage(msg, loggingLevel);
    }

}
