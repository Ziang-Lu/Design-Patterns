package interpreter;

/**
 * Abstract Operation class.
 * This class is responsible for interpreting an operation on a left operand
 * (AbstractExpression) and a right operand (AbstractExpression).
 *
 * @author Ziang Lu
 */
abstract class Operation implements NonterminalExpression {

    /**
     * Left operand of this operation.
     */
    protected final AbstractExpression leftOperand;
    /**
     * Right operand of this operation.
     */
    protected final AbstractExpression rightOperand;

    /**
     * Constructor with parameter.
     * @param leftOperand left operand of this operation
     * @param rightOperand right operand of this operation
     */
    protected Operation(AbstractExpression leftOperand, AbstractExpression rightOperand) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

}
