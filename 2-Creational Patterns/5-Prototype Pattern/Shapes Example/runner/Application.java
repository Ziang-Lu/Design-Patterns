package runner;

import prototype.Shape;

/**
 * Application that actually makes use of Prototype Pattern.
 *
 * @author Ziang Lu
 */
public class Application {

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
            }
            Shape clonedSquare = ShapeFactory.getShape("Square");
            if (clonedSquare != null) {
                System.out.println("Shape: " + clonedSquare.getType());
            }
            Shape clonedCircle = ShapeFactory.getShape("Circle");
            if (clonedCircle != null) {
                System.out.println("Shape: " + clonedCircle.getType());
            }
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
        }

        /*
         * Output:
         * Shape: Rectangle
         * Shape: Square
         * Shape: Circle
         */
    }

}
