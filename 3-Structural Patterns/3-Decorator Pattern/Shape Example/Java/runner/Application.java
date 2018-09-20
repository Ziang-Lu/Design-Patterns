
package runner;

import shape.Circle;
import shape.Rectangle;
import shape.Shape;
import shape.ShapeInBlue;
import shape.ShapeInRed;
import shape.ShapeWithYellowOutline;

/**
 * Application that actually uses Decorator Pattern.
 *
 * @author Ziang Lu
 */
public class Application {

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        Shape rectangle = new ShapeInBlue(new Rectangle());
        rectangle.draw();

        System.out.println();

        Shape circle = new YellowOutlineShapeDecorator(new ShapeInRed(new Circle()));
        circle.draw();

        /*
         * Output:
         * Shape: Rectangle has been drawn.
         * Color: Blue has been applied to Shape: Rectangle.
         *
         * Shape: Circle has been drawn.
         * Color: Red has been applied to Shape: Circle.
         * Outline: Yellow has been applied to Shape: Circle.
         */
    }

}
