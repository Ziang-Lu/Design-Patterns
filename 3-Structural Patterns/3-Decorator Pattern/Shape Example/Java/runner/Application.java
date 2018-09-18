package runner;

import shape.BlueShapeDecorator;
import shape.Circle;
import shape.Rectangle;
import shape.RedShapeDecorator;
import shape.Shape;
import shape.YellowOutlineShapeDecorator;

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
        Shape rectangle = new BlueShapeDecorator(new Rectangle());
        rectangle.draw();

        System.out.println();

        Shape circle = new YellowOutlineShapeDecorator(new RedShapeDecorator(new Circle()));
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
