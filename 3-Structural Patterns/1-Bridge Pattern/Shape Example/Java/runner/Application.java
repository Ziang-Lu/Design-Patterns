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
public class Application {

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        Shape rectangle = new Rectangle();
        rectangle.draw();
        Shape circle = new Circle();
        circle.draw();

        System.out.print("Enter the color to fill: 'red' or 'blue': ");
        Scanner scanner = new Scanner(System.in);
        String color = scanner.nextLine();
        ColorImplementor colorImplementor = null;
        if (color.equalsIgnoreCase("red")) {
            colorImplementor = new RedImplementor();
        } else if (color.equalsIgnoreCase("blue")) {
            colorImplementor = new BlueImplementor();
        } else {
            return;
        }
        rectangle.setColorImplementor(colorImplementor);
        rectangle.fillColor();
        circle.setColorImplementor(colorImplementor);
        circle.fillColor();

        /*
         * Output:
         * Rectangle has been drawn without any color.
         * Circle has been drawn without any color.
         * Enter the color to fill: 'red' or 'blue': red
         * Rectangle is filled with red color using RedImplementor.
         * Circle is filled with red color using RedImplementor.
         */
    }

}
