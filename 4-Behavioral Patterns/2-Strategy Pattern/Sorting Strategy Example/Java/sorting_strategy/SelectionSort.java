package sorting_strategy;

/**
 * Concrete Selection Sort strategy to perform the sorting task (solve the
 * sorting problem) using Selection Sort.
 * This class is implemented as a singleton class.
 *
 * @author Ziang Lu
 */
public class SelectionSort extends SortingStrategy {

    /**
     * Singleton instance.
     */
    private volatile static SelectionSort instance;

    /**
     * Gets the singleton instance.
     * This implementation utilizes Lazy Initialization Pattern and double-check
     * locking mechanism.
     * @return singleton instance
     */
    public static SelectionSort getInstance() {
        SelectionSort localRef = instance;
        if (localRef == null) {
            synchronized (SelectionSort.class) {
                if (localRef == null) {
                    instance = localRef = new SelectionSort();
                }
            }
        }
        return localRef;
    }

    /**
     * Private default constructor.
     * This has to be private so that the class instances cannot be created
     * outside of the class.
     */
    private SelectionSort() {}

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
