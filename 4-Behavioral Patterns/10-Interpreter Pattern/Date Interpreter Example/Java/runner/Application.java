package runner;

import interpreter.AbstractExpression;
import interpreter.DayExpression;
import interpreter.MonthExpression;
import interpreter.YearExpression;

import java.util.Date;
import java.util.Scanner;

/**
 * Application that actually uses Interpreter Pattern.
 *
 * @author Ziang Lu
 */
public class Application {

    /**
     * Constructs the abstract syntax tree for the given format, which
     * essentially specifies a language whose grammar should be well-defined.
     *
     * Note that for this particular application, the nodes (expression
     * instances) in the syntax tree should be connected like a chain or
     * linked-list, rather than a tree structure.
     * @param format given format
     * @return entry expression of the constructed abstract syntax tree
     */
    private static AbstractExpression constructSyntaxTree(String format) {
        String[] parts = format.split("-");
        AbstractExpression prevExpr = null, currExpr = null;
        for (int i = parts.length - 1; i >= 0; --i) {
            switch (parts[i]) {
                case "YYYY":
                    currExpr = new YearExpression(prevExpr);
                    break;
                case "MM":
                    currExpr = new MonthExpression(prevExpr);
                    break;
                case "DD":
                    currExpr = new DayExpression(prevExpr);
                    break;
            }
            prevExpr = currExpr;
        }
        return currExpr;
    }

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        // Get user input for the date format to use
        System.out.print("Please enter the format you want to convert to: 'MM-DD-YYYY' or 'YYYY-MM-DD': ");
        Scanner scanner = new Scanner(System.in);
        String format = "";
        if (scanner.hasNextLine()) {
            format = scanner.nextLine();
        }
        // Here, the format is a pure text, but essentially specifies a "language" whose grammar should be well-defined.
        // Only after we defined the grammar for this "language" are we able to interpret a "sentence" (a Date object)
        // according to this "language".

        // Construct the abstract syntax tree for this language, which essentially is the process of defining grammar
        // for this language
        AbstractExpression entryExpr = constructSyntaxTree(format);

        // Build the context object for interpretation
        Context context = new Context(new Date(), format);

        // Interpret the data in the context
        entryExpr.interpret(context);
        System.out.println("Final output: " + context.getCurrResult());

        /*
         * Output:
         * Please enter the format you want to convert to: 'MM-DD-YYYY' or 'YYYY-MM-DD': MM-DD-YYYY
         * After interpretation by MonthExpression: 10-DD-YYYY
         * After interpretation by DayExpression: 10-10-YYYY
         * After interpretation by YearExpression: 10-10-2018
         * Final output: 10-10-2018
         *
         * Please enter the format you want to convert to: 'MM-DD-YYYY' or 'YYYY-MM-DD': YYYY-MM-DD
         * After interpretation by YearExpression: 2018-MM-DD
         * After interpretation by MonthExpression: 2018-10-DD
         * After interpretation by DayExpression: 2018-10-10
         * Final output: 2018-10-10
         */
    }

}
