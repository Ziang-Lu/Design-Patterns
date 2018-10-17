package visitor;

import car.CarPart;
import car.Color;
import car.Engine;
import car.Light;
import car.Wheel;

import java.util.Random;

/**
 * Concrete CarPartRenderer class that works as "ConcreteVisitor".
 * This class centralizes the rendering functionality, so that an instance of
 * this class can visit each "Element" in the object structure, and render that
 * "Element".
 *
 * @author Ziang Lu
 */
public class CarPartRenderer implements CarPartVisitor {

    /**
     * Private static helper method to print the rendered color of the given car
     * part.
     * @param carPart car part which is rendered
     * @param color rendered color
     */
    private static void printRenderedColor(CarPart carPart, Color color) {
        System.out.println("Car Part Renderer renders " + carPart.getClass().getSimpleName() + " with " + color + ".");
    }

    /**
     * Random number generator to use.
     */
    private Random random = new Random();

    @Override
    public void visitEngine(Engine engine) {
        // Randomly assign a color to the given engine
        int randomNumber = random.nextInt(3);
        switch (randomNumber) {
            case 0:
                printRenderedColor(engine, Color.BLACK);
                engine.setColor(Color.BLACK);
                break;
            case 1:
                printRenderedColor(engine, Color.GRAY);
                engine.setColor(Color.GRAY);
                break;
            case 2:
                printRenderedColor(engine, Color.WHITE);
                engine.setColor(Color.WHITE);
                break;
        }
    }

    @Override
    public void visitWheel(Wheel wheel) {
        // Randomly assign a color to the given wheel
        int randomNumber = random.nextInt(3);
        switch (randomNumber) {
            case 0:
                printRenderedColor(wheel, Color.WHITE);
                wheel.setColor(Color.BLACK);
                break;
            case 1:
                printRenderedColor(wheel, Color.WHITE);
                wheel.setColor(Color.GRAY);
                break;
            case 2:
                printRenderedColor(wheel, Color.WHITE);
                wheel.setColor(Color.WHITE);
                break;
        }
    }

    @Override
    public void visitLight(Light light) {
        // Randomly assign a color to the given light
        int randomNumber = random.nextInt(3);
        switch (randomNumber) {
            case 0:
                printRenderedColor(light, Color.RED);
                light.setColor(Color.RED);
                break;
            case 1:
                printRenderedColor(light, Color.YELLOW);
                light.setColor(Color.YELLOW);
                break;
            case 2:
                printRenderedColor(light, Color.WHITE);
                light.setColor(Color.WHITE);
                break;
        }
    }

}
