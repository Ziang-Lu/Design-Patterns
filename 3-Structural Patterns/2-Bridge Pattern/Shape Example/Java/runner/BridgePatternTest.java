package runner;

import color_implementor.BlueImplementor;
import color_implementor.ColorImplementor;
import color_implementor.RedImplementor;
import shape_abstraction.Circle;
import shape_abstraction.Rectangle;
import shape_abstraction.Shape;

import java.util.Scanner;

/**
 * Application that actually uses Bridge Pattern.
 *
 * @author Ziang Lu
 */
public class BridgePatternTest {

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(0.0, 0.0, 10.0, 5.0);
        rectangle.draw();
        Shape circle = new Circle(0.0, 0.0, 7.0);
        circle.draw();

        System.out.print("Enter the color to fill: 'red' or 'blue': ");
        Scanner scanner = new Scanner(System.in);
        String color = scanner.nextLine();
        ColorImplementor colorImpl = null;
        if (color.equalsIgnoreCase("red")) {
            colorImpl = RedImplementor.getInstance();
        } else if (color.equalsIgnoreCase("blue")) {
            colorImpl = BlueImplementor.getInstance();
        } else {
            return;
        }
        rectangle.setColorImplementor(colorImpl);
        rectangle.fillColor();
        circle.setColorImplementor(colorImpl);
        circle.fillColor();

        /*
         * Output:
         * Rectangle{centerX=0.0, centerY=0.0, width=10.0, height=5.0} has been draw without any color.
         * Circle{x=0.0, y=0.0, radius=7.0} has been draw without any color.
         * Enter the color to fill: 'red' or 'blue': red
         * Rectangle{centerX=0.0, centerY=0.0, width=10.0, height=5.0} is filled with red color using RedImplementor.
         * Circle{x=0.0, y=0.0, radius=7.0} is filled with red color using RedImplementor.
         */
    }

}
