package runner;

import computer.ComputerFacade;

/**
 * Application that actually uses Facade Pattern.
 * Note that by using Facade Pattern, the application now doesn't necessarily
 * need to know the complex logic and implementation details in the
 * sub-components, but only need to interact with the Facade.
 *
 * @author Ziang Lu
 */
public class FacadePatternTest {

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        ComputerFacade computer = new ComputerFacade();
        computer.start();

        /*
         * Output:
         * Reading 1024B data from the hard drive @1...
         * Successfully loaded 1024B data @ABCD in memory
         * CPU jumped to @ABCD and ready to execute instructions.
         * CPU executing instructions...
         */
    }

}
