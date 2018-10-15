package interpreter;

import runner.Context;

/**
 * Concrete MinusOperation class.
 * This class is responsible for interpreting the minus operation on a minuend
 * (AbstractExpression) and a subtrahend (AbstractExpression).
 *
 * @author Ziang Lu
 */
public class MinusOperation extends Operation {

    /**
     * Constructor with parameter.
     * @param minuend minuend of this minus operation
     * @param subtrahend subtrahend this minus operation
     */
    public MinusOperation(AbstractExpression minuend, AbstractExpression subtrahend) {
        super(minuend, subtrahend);
    }

    @Override
    public int interpret(Context context) {
        return leftOperand.interpret(context) - rightOperand.interpret(context);
    }

}
