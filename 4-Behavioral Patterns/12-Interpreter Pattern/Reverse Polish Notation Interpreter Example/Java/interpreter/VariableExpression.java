package interpreter;

import runner.Context;

/**
 * Concrete VariableExpression class.
 * This class is responsible for interpreting a variable by querying the actual
 * variables in the given "Context".
 *
 * @author Ziang Lu
 */
public class VariableExpression implements TerminalExpression {

    /**
     * Name of this variable.
     */
    private final String name;

    /**
     * Constructor with parameter.
     * @param name name of the variable
     */
    public VariableExpression(String name) {
        this.name = name;
    }

    @Override
    public int interpret(Context context) {
        NumberExpression actualVariable = context.getActualVariables().get(name);
        if (actualVariable == null) {
            return 0;
        }
        return actualVariable.interpret(context);
    }

}
