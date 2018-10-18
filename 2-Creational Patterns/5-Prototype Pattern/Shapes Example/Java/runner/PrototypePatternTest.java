package runner;

import prototype.Shape;

/**
 * Application that actually uses Prototype Pattern.
 *
 * @author Ziang Lu
 */
public class PrototypePatternTest {

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        // Load the shape prototypes
        ShapeFactory.loadCache();

        try {
            Shape clonedRectangle = ShapeFactory.getShape("Rectangle");
            if (clonedRectangle != null) {
                System.out.println("Shape: " + clonedRectangle.getType());
                clonedRectangle.draw();
            }
            Shape clonedSquare = ShapeFactory.getShape("Square");
            if (clonedSquare != null) {
                System.out.println("Shape: " + clonedSquare.getType());
                clonedSquare.draw();
            }
            Shape clonedCircle = ShapeFactory.getShape("Circle");
            if (clonedCircle != null) {
                System.out.println("Shape: " + clonedCircle.getType());
                clonedCircle.draw();
            }
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
        }

        /*
         * Shape: Rectangle
         * In Rectangle.draw() method
         * Shape: Square
         * In Square.draw() method
         * Shape: Circle
         * In Circle.draw() method
         */
    }

}
