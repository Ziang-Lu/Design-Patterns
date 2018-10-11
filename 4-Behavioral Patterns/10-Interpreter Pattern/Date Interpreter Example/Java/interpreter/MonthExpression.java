package interpreter;

import runner.Context;

/**
 * Concrete MonthExpression class that works as a "NonterminalExpression".
 *
 * @author Ziang Lu
 */
public class MonthExpression extends NonterminalExpression {

    /**
     * Constructor with parameter.
     * @param expr next expression
     */
    public MonthExpression(AbstractExpression expr) {
        super(expr);
    }

    @Override
    public void interpret(Context context) {
        // Interpret the "month" part
        int month = context.getDate().getMonth() + 1;
        String newResult = context.getCurrResult().replaceAll("MM", String.valueOf(month));
        System.out.println("After interpretation by MonthExpression: " + newResult);
        context.setResult(newResult);

        // Forward the interpret request to the children expression instances in the syntax tree for further
        // interpretation
        forwardInterpret(context);
    }

}
