package runner;

import strategy.BubbleSort;
import strategy.InsertionSort;
import strategy.SelectionSort;
import strategy.SortingStrategy;

import java.util.Scanner;

/**
 * Application that actually uses Strategy Pattern to provide multiple
 * algorithms, a family of algorithms, to perform a specific task (solve a
 * specific problem), so that the client can select which actual implementation
 * to use at runtime.
 *
 * @author Ziang Lu
 */
public class Application {

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        int[] array = SortContext.readUserInput();
        System.out.println("Array before sorting:");
        SortContext.printArray(array);

        System.out.println("Enter sorting algorithm: 'BubbleSort' or 'SelectionSort' or 'InsertionSort' ");
        Scanner scanner = new Scanner(System.in);
        String sortingAlgo = scanner.next();
        System.out.println("Sorting Algorithm : " + sortingAlgo);

        SortContext context = new SortContext();
        if (sortingAlgo.equalsIgnoreCase("BubbleSort")) {
            context.setSortingStrategy(new BubbleSort());
        } else if (sortingAlgo.equalsIgnoreCase("SelectionSort")) {
            context.setSortingStrategy(new SelectionSort());
        } else if (sortingAlgo.equalsIgnoreCase("InsertionSort")) {
            context.setSortingStrategy(new InsertionSort());
        }

        context.sortArray(array);
        System.out.println("Array after sorting:");
        SortContext.printArray(array);
    }

}
