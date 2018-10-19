package runner;

import flyweight.Color;
import flyweight.FlyweightShapeFactory;
import flyweight.SharedCircle;
import flyweight.SharedRectangle;

/**
 * Application that actually uses Flyweight Pattern.
 *
 * @author Ziang Lu
 */
public class FlyweightPatternTest {

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        FlyweightShapeFactory shapeFactory = FlyweightShapeFactory.getInstance();

        /*
         * In this application, we need to create a large number of objects of similar nature, which would have consumed
         * a large amount of memory and decrease the performance.
         *
         * By using Flyweight Pattern, we first get the shared "ConcreteFlyweight" from the "FlyweightFactory", and then
         * customize it to get the "UnsharedConcreteFlyweight" we desire.
         * In this way, the load on memory is reduced and the performance is improved.
         */

        for (int i = 0; i < 5; ++i) {
            // First get the SharedCircle from the FlyweightShapeFactory
            SharedCircle circle = (SharedCircle) shapeFactory.getFlyweightShape("circle");

            // Customize this SharedCircle to get the UnsharedCircle we desire
            circle.setRadius(9.0);
            circle.draw(Color.GREEN);
        }

        for (int i = 0; i < 5; ++i) {
            // First get the SharedCircle from the FlyweightShapeFactory
            SharedCircle circle = (SharedCircle) shapeFactory.getFlyweightShape("circle");

            // Customize this SharedCircle to get the UnsharedCircle we desire
            circle.setRadius(9.0);
            circle.draw(Color.PURPLE);
        }

        for (int i = 0; i < 4; ++i) {
            // First get the SharedCircle from the FlyweightShapeFactory
            SharedCircle circle = (SharedCircle) shapeFactory.getFlyweightShape("circle");

            // Customize this SharedCircle to get the UnsharedCircle we desire
            circle.setRadius(8.0);
            circle.draw(Color.ORANGE);
        }

        for (int i = 0; i < 3; ++i) {
            // First get the SharedCircle from the FlyweightShapeFactory
            SharedCircle circle = (SharedCircle) shapeFactory.getFlyweightShape("circle");

            // Customize this SharedCircle to get the UnsharedCircle we desire
            circle.setRadius(7.0);
            circle.draw(Color.BLACK);
        }

        System.out.println();

        // First get the SharedRectangle from the FlyweightShapeFactory
        SharedRectangle rectangle = (SharedRectangle) shapeFactory.getFlyweightShape("rectangle");

        // Customize this SharedRectangle to get the UnsharedRectangle we desire
        rectangle.setWidth(8.0);
        rectangle.setHeight(6.0);
        rectangle.draw(Color.RED);

        /*
         * Output:
         * Creating a Shared Circle without color: Circle@6b71769e {x=0.0, y=0.0, radius=5.0, color=null}
         * Circle has been drawn with GREEN: Circle@6b71769e {x=0.0, y=0.0, radius=9.0, color=GREEN}
         * Circle has been drawn with GREEN: Circle@6b71769e {x=0.0, y=0.0, radius=9.0, color=GREEN}
         * Circle has been drawn with GREEN: Circle@6b71769e {x=0.0, y=0.0, radius=9.0, color=GREEN}
         * Circle has been drawn with GREEN: Circle@6b71769e {x=0.0, y=0.0, radius=9.0, color=GREEN}
         * Circle has been drawn with GREEN: Circle@6b71769e {x=0.0, y=0.0, radius=9.0, color=GREEN}
         * Circle has been drawn with PURPLE: Circle@6b71769e {x=0.0, y=0.0, radius=9.0, color=PURPLE}
         * Circle has been drawn with PURPLE: Circle@6b71769e {x=0.0, y=0.0, radius=9.0, color=PURPLE}
         * Circle has been drawn with PURPLE: Circle@6b71769e {x=0.0, y=0.0, radius=9.0, color=PURPLE}
         * Circle has been drawn with PURPLE: Circle@6b71769e {x=0.0, y=0.0, radius=9.0, color=PURPLE}
         * Circle has been drawn with PURPLE: Circle@6b71769e {x=0.0, y=0.0, radius=9.0, color=PURPLE}
         * Circle has been drawn with ORANGE: Circle@6b71769e {x=0.0, y=0.0, radius=8.0, color=ORANGE}
         * Circle has been drawn with ORANGE: Circle@6b71769e {x=0.0, y=0.0, radius=8.0, color=ORANGE}
         * Circle has been drawn with ORANGE: Circle@6b71769e {x=0.0, y=0.0, radius=8.0, color=ORANGE}
         * Circle has been drawn with ORANGE: Circle@6b71769e {x=0.0, y=0.0, radius=8.0, color=ORANGE}
         * Circle has been drawn with BLACK: Circle@6b71769e {x=0.0, y=0.0, radius=7.0, color=BLACK}
         * Circle has been drawn with BLACK: Circle@6b71769e {x=0.0, y=0.0, radius=7.0, color=BLACK}
         * Circle has been drawn with BLACK: Circle@6b71769e {x=0.0, y=0.0, radius=7.0, color=BLACK}
         *
         * Creating a Shared Rectangle without color: Rectangle@506e6d5e {leftBottomX=0.0, leftBottomY=0.0, width=4.0, height=3.0, color=null}
         * Rectangle has been drawn with RED: Rectangle@506e6d5e {leftBottomX=0.0, leftBottomY=0.0, width=8.0, height=6.0, color=RED}
         */

        // From the hash code we can see that the same SharedCircle and SharedRectangle objects are being reused.
    }

}
