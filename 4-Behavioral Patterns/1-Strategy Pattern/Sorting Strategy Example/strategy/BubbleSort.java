package strategy;

/**
 * Concrete Bubble Sort strategy to perform the sorting task (solve the sorting
 * problem) using Bubble Sort.
 *
 * @author Ziang Lu
 */
public class BubbleSort extends SortingStrategy {

    @Override
    public void sort(int[] array) {
        for (int out = array.length - 1; out > 0; --out) {
            for (int in = 0; in < out; ++in) {
                if (array[in] > array[in + 1]) {
                    swap(array, in, in + 1);
                }
            }
        }
        System.out.println("Sorting is performed using Bubble Sort algorithm.");
    }

}
