package car;

import visitor.CarPartPrinter;
import visitor.CarPartRenderer;
import visitor.CarPartUpgrader;

import java.util.ArrayList;
import java.util.List;

/**
 * Car class that actually uses Visitor Pattern.
 * The Visitor Pattern separates an algorithm (an operation) from the object
 * structure it operates on, and the executing algorithm (operation) is
 * encapsulated in a visitor object.
 * In this way, we can change the executing algorithm (operation) on each
 * element in the object structure by simply varying the visitor object, without
 * needing to modify the object structure itself.
 *
 * @author Ziang Lu
 */
public class Car {

    /**
     * Car parts in this car.
     * This works as the object structure, whose elements can be visited by a
     * "Visitor", so that the "Visitor" can perform algorithm (handle operation)
     * on each element.
     */
    private List<CarPart> parts;

    /**
     * Default constructor.
     */
    public Car() {
        parts = new ArrayList<>();
        parts.add(new Engine(Color.GRAY));
        for (int i = 0; i < 4; ++i) {
            parts.add(new Wheel(Color.GRAY));
        }
        for (int i = 0; i < 2; ++i) {
            parts.add(new Light(Color.YELLOW));
        }
    }

    /**
     * Prints the car parts.
     */
    public void printCarParts() {
        System.out.println("Preparing to print car parts...");
        // Create a car part printer that is able to visit each car part in the car parts objects structure, and prints
        // that car part
        CarPartPrinter carPartPrinter = new CarPartPrinter();
        for (CarPart part : parts) {
            part.accept(carPartPrinter);
        }
    }

    /**
     * Renders the car parts.
     */
    public void renderCarParts() {
        System.out.println("Preparing to render car parts...");
        // Create a car part renderer that is able to visit each car part in the car parts objects structure, and
        // renders that car part
        CarPartRenderer carPartRenderer = new CarPartRenderer();
        for (CarPart part : parts) {
            part.accept(carPartRenderer);
        }
    }

    /**
     * Upgrades the car parts.
     */
    public void upgradeCarParts() {
        System.out.println("Preparing to upgrade car parts...");
        // Create a car part upgrader that is able to visit each car part in the car parts objects structure, and
        // upgrades that car part
        CarPartUpgrader carPartUpgrader = new CarPartUpgrader();
        for (CarPart part : parts) {
            part.accept(carPartUpgrader);
        }
    }

}
