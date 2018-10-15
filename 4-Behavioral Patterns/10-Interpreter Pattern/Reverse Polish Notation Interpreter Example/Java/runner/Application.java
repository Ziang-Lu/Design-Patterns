package runner;

import interpreter.AbstractExpression;
import interpreter.AddOperation;
import interpreter.MinusOperation;
import interpreter.NumberExpression;
import interpreter.VariableExpression;

import java.util.Stack;

/**
 * Application that actually uses Interpreter Pattern.
 *
 * @author Ziang Lu
 */
public class Application {

    /**
     * Constructs the syntax tree for the given Reverse Polish Notation
     * expression.
     * @param reversePolishNotationExpr given Reverse Polish Notation expression
     * @return entry expression of the constructed syntax tree
     */
    private static AbstractExpression constructSyntaxTree(String reversePolishNotationExpr) {
        String[] tokens = reversePolishNotationExpr.split(" ");
        Stack<AbstractExpression> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                    AbstractExpression rightOperand = stack.pop();
                    AbstractExpression leftOperand = stack.pop();
                    stack.push(new AddOperation(leftOperand, rightOperand));
                    break;
                case "-":
                    AbstractExpression subtrahend = stack.pop();
                    AbstractExpression minuend = stack.pop();
                    stack.push(new MinusOperation(minuend, subtrahend));
                    break;
                default:
                    stack.push(new VariableExpression(token));
                    break;
            }
        }
        return stack.pop();
    }

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        String reversePolishNotationExpr = "w x z - +";
        // Here, this Reverse Polish Notation expression is a pure text, but follows the grammar of a well-defined
        // language, which in this case is the Reverse Polish Notation.

        // Construct the syntax tree for this specific Reverse Polish Notation expression
        AbstractExpression entryExpr = constructSyntaxTree(reversePolishNotationExpr);
        // Only after we built the syntax tree for this specific expression are we able to interpret a "sentence" (
        // containing the variables to be placed into this specific expression)

        // Build the context object for interpretation
        Context context = new Context();
        context.addActualVariable("w", new NumberExpression(5));
        context.addActualVariable("x", new NumberExpression(10));
        context.addActualVariable("z", new NumberExpression(42));

        // Interpret the data in the context
        System.out.println("Evaluated result: " + entryExpr.interpret(context));

        /*
         * Output:
         * Evaluated result: -27
         */
    }

}
