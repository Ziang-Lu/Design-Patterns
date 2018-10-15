package interpreter;

import runner.Context;

/**
 * Concrete YearExpression class that works as a "NonterminalExpression".
 * This class is responsible for interpreting the year expression (YYYY) of a
 * date.
 *
 * @author Ziang Lu
 */
public class YearExpression extends NonterminalExpression {

    /**
     * Constructor with parameter.
     * @param expr next expression
     */
    public YearExpression(AbstractExpression expr) {
        super(expr);
    }

    @Override
    public void interpret(Context context) {
        // Interpret the "year" part
        int year = context.getDate().getYear() + 1900;
        String newResult = context.getCurrResult().replaceAll("YYYY", String.valueOf(year));
        System.out.println("After interpretation by YearExpression: " + newResult);
        context.setResult(newResult);

        // Forward the interpret request to the children expression instances in the syntax tree for further
        // interpretation
        forwardInterpret(context);
    }

}
