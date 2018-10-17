package visitor;

import car.Engine;
import car.Light;
import car.Wheel;

/**
 * Abstract CarPartVisitor class that works as "Visitor".
 * This class encapsulates the executing algorithm (operation) on elements in
 * the object structure, and can visit each "Element" in the object structure,
 * and perform desired algorithm (handle operation) on that "Element".
 *
 * @author Ziang Lu
 */
public interface CarPartVisitor {

    /**
     * Lets this car part visitor visit the given engine, and perform desired
     * algorithm (handle operation) on it.
     * @param engine engine to visit
     */
    void visitEngine(Engine engine);

    /**
     * Lets this car part visitor visit the given wheel, and perform desired
     * algorithm (handle operation) on it.
     * @param wheel wheel to visit
     */
    void visitWheel(Wheel wheel);

    /**
     * Lets this car part visitor visit the given light, and perform desired
     * algorithm (handle operation) on it.
     * @param light light to visit
     */
    void visitLight(Light light);

}
