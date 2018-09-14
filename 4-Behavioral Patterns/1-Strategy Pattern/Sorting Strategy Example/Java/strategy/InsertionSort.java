package strategy;

/**
 * Concrete Insertion Sort strategy to perform the sorting task (solve the
 * sorting problem) using Bubble Sort.
 *
 * @author Ziang Lu
 */
public class InsertionSort extends SortingStrategy {

    @Override
    public void sort(int[] array) {
        for (int out = 1; out < array.length; ++out) {
            int tmp = array[out];
            int insertIdx = out;
            while ((insertIdx > 0) && (array[insertIdx - 1] > tmp)) {
                --insertIdx;
            }
            System.arraycopy(array, insertIdx, array, insertIdx + 1, out - insertIdx);
            array[insertIdx] = tmp;
        }
        System.out.println("Sorting is performed using Insertion Sort algorithm.");
    }

}
