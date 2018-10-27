package interpreter;

/**
 * NonterminalExpression (CompositeExpression) interface.
 * This class should contain references to other expression instances (children
 * nodes) in the syntax tree.
 * The interpret(Context) method in this class and its subclasses should do its
 * own interpretation work on the given "Context", and then forwards the
 * interpret request on the "Context" to its children nodes (expression
 * instances) in the syntax tree for further interpretation.
 *
 * @author Ziang Lu
 */
interface NonterminalExpression extends AbstractExpression {}
