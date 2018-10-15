package interpreter;

/**
 * TerminalExpression (LeafExpression) interface.
 * This class does not contain references to other expression instances
 * (children nodes) in the syntax tree.
 * The interpret(Context) method in this class and its subclasses should only do
 * its own interpretation work on the given "Context".
 *
 * @author Ziang Lu
 */
interface TerminalExpression extends AbstractExpression {}
