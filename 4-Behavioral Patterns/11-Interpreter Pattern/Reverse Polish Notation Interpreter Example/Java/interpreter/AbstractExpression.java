package interpreter;

import runner.Context;

/**
 * AbstractExpression interface.
 * This interface declares interpret(Context) method that is common to all the
 * nodes (expression instances) in the syntax tree, i.e., this is the highest
 * level in the abstract syntax tree hierarchy.
 *
 * @author Ziang Lu
 */
public interface AbstractExpression {

    /**
     * Interprets the data in the given context.
     * @param context given context
     * @return interpreted result
     */
    int interpret(Context context);

}
