package interpreter;

import runner.Context;

/**
 * NonterminalExpression (CompositeExpression) class.
 * This class should contain references to other expression instances (children
 * nodes) in the syntax tree.
 * The interpret(Context) method in this class and its subclasses should do its
 * own interpretation work on the given "Context", and then forwards the
 * interpret request on the "Context" to its children nodes (expression
 * instances) in the syntax tree for further interpretation.
 *
 * Note that for this particular application, the nodes (expression instances)
 * in the syntax tree should be connected like a chain or linked-list, rather
 * than a tree structure.
 * Therefore, this can be viewed as an implementation of Chain of Responsibility
 * Pattern.
 *
 * @author Ziang Lu
 */
abstract class NonterminalExpression implements AbstractExpression {

    /**
     * Next expression.
     * This works as the next receiver (handler) in the chain of responsibility.
     */
    protected AbstractExpression nextExpr;

    /**
     * Constructor with parameter.
     * @param expr next expression
     */
    protected NonterminalExpression(AbstractExpression expr) {
        nextExpr = expr;
    }

    /**
     * Protected helper method to forward the interpret request to the next
     * expression instance in the syntax tree for further interpretation.
     * In terms of Chain of Responsibility Pattern, pass the request to the next
     * receiver in the chain of responsibility.
     * @param context given context
     */
    protected void forwardInterpret(Context context) {
        if (nextExpr != null) {
            nextExpr.interpret(context);
        }
    }

}
