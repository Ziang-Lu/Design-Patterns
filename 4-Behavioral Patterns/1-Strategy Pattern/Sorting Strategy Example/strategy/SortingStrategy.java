package strategy;

/**
 * Abstract sorting strategy interface to define the sorting task to perform
 * (sorting problem to solve).
 *
 * @author Ziang Lu
 */
public abstract class SortingStrategy {

    /**
     * Sorts the given array using some sorting algorithm.
     * @param array array to sort
     */
    public abstract void sort(int[] array);

    /**
     * Protected helper function to swap two numbers in the given array.
     * @param array array to swap
     * @param i first index
     * @param j second index
     */
    protected void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}
