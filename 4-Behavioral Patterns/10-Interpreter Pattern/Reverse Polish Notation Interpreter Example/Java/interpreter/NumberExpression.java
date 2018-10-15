package interpreter;

import runner.Context;

/**
 * Concrete NumberExpression class.
 * This class is responsible for interpreting the value of a single number.
 *
 * @author Ziang Lu
 */
public class NumberExpression implements TerminalExpression {

    /**
     * Number represented by this number expression.
     */
    private int number;

    /**
     * Constructor with parameter.
     * @param number number represented by the number expression
     */
    public NumberExpression(int number) {
        this.number = number;
    }

    @Override
    public int interpret(Context context) {
        return number;
    }

}
