package strategy;

/**
 * Concrete Selection Sort strategy to perform the sorting task (solve the
 * sorting problem) using Selection Sort.
 *
 * @author Ziang Lu
 */
public class SelectionSort extends SortingStrategy {

    @Override
    public void sort(int[] array) {
        for (int out = 0; out < (array.length - 1); ++out) {
            int minIdx = out;
            for (int in = out + 1; in < array.length; ++in) {
                if (array[in] < array[minIdx]) {
                    minIdx = in;
                }
            }
            swap(array, minIdx, out);
        }
        System.out.println("Sorting is performed using Selection Sort algorithm.");
    }

}
