package computer;

/**
 * Simple HardDrive representation as a sub-component of a computer.
 *
 * @author Ziang Lu
 */
class HardDrive {

    /**
     * Reads the given size of data from the given LBA in the hard drive.
     * @param lba logical block addressing
     * @param size size of data to readData
     * @return read data block
     */
    byte[] readData(int lba, int size) {
        byte[] readData = new byte[size];
        System.out.println(String.format("Reading %dB data from the hard drive @%X...", size, lba));
        return readData;
    }

}
