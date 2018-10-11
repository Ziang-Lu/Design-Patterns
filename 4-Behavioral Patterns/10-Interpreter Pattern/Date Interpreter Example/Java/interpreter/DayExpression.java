package interpreter;

import runner.Context;

/**
 * Concrete DayExpression class that works as a "NonterminalExpression".
 *
 * @author Ziang Lu
 */
public class DayExpression extends NonterminalExpression {

    /**
     * Constructor with parameter.
     * @param expr next expression
     */
    public DayExpression(AbstractExpression expr) {
        super(expr);
    }

    @Override
    public void interpret(Context context) {
        // Interpret the "day" part
        int day = context.getDate().getDate();
        String newResult = context.getCurrResult().replaceAll("DD", String.valueOf(day));
        System.out.println("After interpretation by DayExpression: " + newResult);
        context.setResult(newResult);

        // Forward the interpret request to the children expression instances in the syntax tree for further
        // interpretation
        forwardInterpret(context);
    }

}
