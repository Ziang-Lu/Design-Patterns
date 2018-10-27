package visitor;

import car.Engine;
import car.Light;
import car.Wheel;

/**
 * Concrete CarPartUpgrader class that works as "ConcreteVisitor".
 * This class centralizes the upgrading functionality, so that an instance of
 * this class can visit each "Element" in the object structure, and upgrade that
 * "Element".
 *
 * @author Ziang Lu
 */
public class CarPartUpgrader implements CarPartVisitor {

    @Override
    public void visitEngine(Engine engine) {
        engine.upgrade();
        System.out.println("Car Part Upgrader upgrades an Engine to " + engine);
    }

    @Override
    public void visitWheel(Wheel wheel) {
        wheel.upgrade();
        System.out.println("Car Part Upgrader upgrades a Wheel to " + wheel);
    }

    @Override
    public void visitLight(Light light) {
        light.upgrade();
        System.out.println("Car Part Upgrader upgrades a Light to " + light);
    }

}
