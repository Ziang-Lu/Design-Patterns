package sorting_strategy;

/**
 * Concrete Bubble Sort strategy to perform the sorting task (solve the sorting
 * problem) using Bubble Sort.
 * This class is implemented as a singleton class.
 *
 * @author Ziang Lu
 */
public class BubbleSort extends SortingStrategy {

    /**
     * Singleton instance.
     */
    private volatile static BubbleSort instance;

    /**
     * Gets the singleton instance.
     * This implementation utilizes Lazy Initialization Pattern and double-check
     * locking mechanism.
     * @return singleton instance
     */
    public static BubbleSort getInstance() {
        if (instance == null) {
            synchronized (BubbleSort.class) {
                if (instance == null) {
                    instance = new BubbleSort();
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
    private BubbleSort() {}

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
