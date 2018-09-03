package runner;

import strategy.SortingStrategy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * SortContext class works as an interface to the outside world: it wraps a
 * sorting strategy and the client will use that strategy to sort an array.
 *
 * @author Ziang Lu
 */
public class SortContext {

    /**
     * Reads user input to get an array.
     * @return array from user input
     */
    public static int[] readUserInput() {
        System.out.println("Enter array size: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.println("Enter input array: ");
        int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    /**
     * Prints the given array.
     * @param array array to print
     */
    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    /**
     * Sorting strategy to use.
     */
    private SortingStrategy sortingStrategy;

    /**
     * Mutator of sortingStrategy.
     * @param sortingStrategy sorting strategy to set
     */
    public void setSortingStrategy(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    /**
     * Sorts an array from user input.
     * @param array array to sort
     */
    public void sortArray(int[] array) {
        sortingStrategy.sort(array);
        printArray(array);
    }

}
