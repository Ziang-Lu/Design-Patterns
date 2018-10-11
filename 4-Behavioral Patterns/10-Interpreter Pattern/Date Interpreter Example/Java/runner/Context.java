package runner;

import java.util.Date;

/**
 * Context class.
 * This class contains the data to be interpreted.
 *
 * @author Ziang Lu
 */
public class Context {

    /**
     * Raw date to be interpreted.
     */
    private final Date date;
    /**
     * Temporarily stored interpretation result.
     */
    private String currResult;

    /**
     * Constructor with parameter.
     * @param date raw date to be interpreted
     * @param template template for the interpretation result
     */
    Context(Date date, String template) {
        this.date = date;
        currResult = template;
    }

    /**
     * Accessor of date.
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Accessor of currResult.
     * @return currResult
     */
    public String getCurrResult() {
        return currResult;
    }

    /**
     * Mutator of currResult.
     * @param result temporary result to set
     */
    public void setResult(String result) {
        currResult = result;
    }

}
