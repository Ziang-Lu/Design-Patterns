package runner;

import interpreter.NumberExpression;

import java.util.HashMap;
import java.util.Map;

/**
 * Context class.
 * This class contains the data to be interpreted.
 *
 * @author Ziang Lu
 */
public class Context {

    /**
     * Actual variables to be interpreted.
     */
    private Map<String, NumberExpression> actualVariables = new HashMap<>();

    /**
     * Adds the given actual variable to this context.
     * @param name name of the variable
     * @param val value of the actual variable
     */
    void addActualVariable(String name, NumberExpression val) {
        actualVariables.put(name, val);
    }

    /**
     * Accessor of actualVariables.
     * @return actualVariables
     */
    public Map<String, NumberExpression> getActualVariables() {
        return actualVariables;
    }

}
