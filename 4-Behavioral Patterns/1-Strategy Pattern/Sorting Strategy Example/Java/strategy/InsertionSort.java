package strategy;

/**
 * Concrete Insertion Sort strategy to perform the sorting task (solve the
 * sorting problem) using Insertion Sort.
 *
 * @author Ziang Lu
 */
public class InsertionSort extends SortingStrategy {

    /**
     * Singleton instance.
     */
    private volatile static InsertionSort instance;

    /**
     * Gets the singleton instance.
     * This implementation utilizes Lazy Initialization Pattern and double-check
     * locking mechanism.
     * @return singleton instance
     */
    public static InsertionSort getInstance() {
        if (instance == null) {
            synchronized (InsertionSort.class) {
                if (instance == null) {
                    instance = new InsertionSort();
                }
            }
        }
        return instance;
    }

    /**
     * Private default constructor.
     * This has to be private so that the class instances cannot be created
     * outside of the class.
     */
    private InsertionSort() {}

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
