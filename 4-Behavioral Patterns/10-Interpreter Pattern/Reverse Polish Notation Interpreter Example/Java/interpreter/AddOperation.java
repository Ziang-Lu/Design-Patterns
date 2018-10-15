package interpreter;

import runner.Context;

/**
 * Concrete AddOperation class.
 * This class is responsible for interpreting the add operation on a left
 * operand (AbstractExpression) and a right operand (AbstractExpression).
 *
 * @author Ziang Lu
 */
public class AddOperation extends Operation {

    /**
     * Constructor with parameter.
     * @param leftOperand left operand of this add operation
     * @param rightOperand right operand of this add operation
     */
    public AddOperation(AbstractExpression leftOperand, AbstractExpression rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public int interpret(Context context) {
        return leftOperand.interpret(context) + rightOperand.interpret(context);
    }

}
