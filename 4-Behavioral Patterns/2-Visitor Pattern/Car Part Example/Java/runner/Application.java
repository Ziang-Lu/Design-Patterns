package runner;

import car.Car;

/**
 * Application.
 *
 * @author Ziang Lu
 */
public class Application {

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        Car car = new Car();

        car.printCarParts();
        System.out.println();
        car.renderCarParts();
        System.out.println();
        car.upgradeCarParts();

        /*
         * Output:
         * Preparing to print car parts...
         * Car Part Printer prints an engine: Engine{color=GRAY, horsepower=200}
         * Car Part Printer prints a wheel: Wheel{color=GRAY, level=1}
         * Car Part Printer prints a wheel: Wheel{color=GRAY, level=1}
         * Car Part Printer prints a wheel: Wheel{color=GRAY, level=1}
         * Car Part Printer prints a wheel: Wheel{color=GRAY, level=1}
         * Car Part Printer prints a light: Light{color=YELLOW, lightness=1}
         * Car Part Printer prints a light: Light{color=YELLOW, lightness=1}
         *
         * Preparing to render car parts...
         * Car Part Renderer renders Engine with GRAY.
         * Car Part Renderer renders Wheel with WHITE.
         * Car Part Renderer renders Wheel with WHITE.
         * Car Part Renderer renders Wheel with WHITE.
         * Car Part Renderer renders Wheel with WHITE.
         * Car Part Renderer renders Light with RED.
         * Car Part Renderer renders Light with WHITE.
         *
         * Preparing to upgrade car parts...
         * Car Part Upgrader upgrades an Engine to Engine{color=WHITE, horsepower=250}
         * Car Part Upgrader upgrades a Wheel to Wheel{color=BLACK, level=2}
         * Car Part Upgrader upgrades a Wheel to Wheel{color=BLACK, level=2}
         * Car Part Upgrader upgrades a Wheel to Wheel{color=BLACK, level=2}
         * Car Part Upgrader upgrades a Wheel to Wheel{color=BLACK, level=2}
         * Car Part Upgrader upgrades a Light to Light{color=WHITE, lightness=2}
         * Car Part Upgrader upgrades a Light to Light{color=WHITE, lightness=2}
         */
    }

}
