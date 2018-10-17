package visitor;

import car.Engine;
import car.Light;
import car.Wheel;

/**
 * Concrete CarPartPrinter class that works as "ConcreteVisitor".
 * This class centralizes the printing functionality, so that an instance of
 * this class can visit each "Element" in the object structure, and print that
 * "Element".
 *
 * @author Ziang Lu
 */
public class CarPartPrinter implements CarPartVisitor {

    @Override
    public void visitEngine(Engine engine) {
        System.out.println("Car Part Printer prints an engine: " + engine);
    }

    @Override
    public void visitWheel(Wheel wheel) {
        System.out.println("Car Part Printer prints a wheel: " + wheel);
    }

    @Override
    public void visitLight(Light light) {
        System.out.println("Car Part Printer prints a light: " + light);
    }

}
