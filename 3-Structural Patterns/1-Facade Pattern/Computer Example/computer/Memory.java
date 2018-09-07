package computer;

/**
 * Simple memory representation as a sub-component of a computer.
 *
 * @author Ziang Lu
 */
class Memory {

    /**
     * Loads the given data to the given position in memory.
     * @param data data to load
     * @param position position in memory to load the data to
     */
    void loadData(byte[] data, long position) {
        System.out.println(String.format("Successfully loaded %dB data @%X in memory", data.length, position));
    }

}
