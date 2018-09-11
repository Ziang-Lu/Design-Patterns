package computer;

/**
 * Facade class for computer that serves as a front-facing interface masking
 * more complex sub-components to simplify the usage for client and minimize the
 * dependencies between the client and the sub-components.
 *
 * @author Ziang Lu
 */
public class ComputerFacade {

    /**
     * Memory address at booting time.
     */
    private static final long BOOT_ADDRESS = 0xABCD;
    /**
     * Sector of the hard drive at booting time.
     */
    private static final int BOOT_SECTOR = 1;
    /**
     * Sector size of the hard drive.
     */
    private static final int SECTOR_SIZE = 1024;

    /**
     * CPU of this computer.
     */
    private final CPU cpu;
    /**
     * Memory of this computer.
     */
    private final Memory memory;
    /**
     * Hard drive of this computer.
     */
    private final HardDrive hardDrive;

    /**
     * Default constructor.
     */
    public ComputerFacade() {
        cpu = new CPU();
        memory = new Memory();
        hardDrive = new HardDrive();
    }

    /**
     * Starts this computer.
     */
    public void start() {
        cpu.freeze();
        memory.loadData(hardDrive.readData(BOOT_SECTOR, SECTOR_SIZE), BOOT_ADDRESS);
        cpu.jump(BOOT_ADDRESS);
        cpu.execute();
    }

}
