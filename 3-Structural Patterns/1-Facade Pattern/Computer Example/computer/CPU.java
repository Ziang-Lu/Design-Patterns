package computer;

/**
 * Simple CPU representation as a sub-component of a computer.
 *
 * @author Ziang Lu
 */
class CPU {

    /**
     * Freezes this CPU.
     */
    void freeze() {
        System.out.println("Freezing CPU...");
    }

    /**
     * Jumps to the given position.
     * @param position position to jump to
     */
    void jump(long position) {
        System.out.println(String.format("CPU jumped to @%X and ready to execute instructions.", position));
    }

    /**
     * Execute instructions.
     */
    void execute() {
        System.out.println("CPU executing instructions...");
    }

}
