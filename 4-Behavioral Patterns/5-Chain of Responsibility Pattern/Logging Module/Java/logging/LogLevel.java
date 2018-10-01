package logging;

/**
 * Log level enumeration.
 *
 * @author Ziang Lu
 */
public enum LogLevel {

    /**
     * Log levels.
     */
    INFO(1), DEBUG(2), WARNING(3), ERROR(4);

    /**
     * Value of this log level.
     */
    private final int level;

    /**
     * Constructor with parameter.
     * @param level log level
     */
    LogLevel(int level) {
        this.level = level;
    }

    /**
     * Accessor of val.
     * @return val
     */
    public int level() {
        return level;
    }

}