package runner;

import flyweight.Color;
import flyweight.FlyweightShapeFactory;
import flyweight.circle.SharedCircle;
import flyweight.circle.UnsharedCircle;
import flyweight.rectangle.SharedRectangle;
import flyweight.rectangle.UnsharedRectangle;

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
         * a large, unaccepted amount of memory and decrease the performance.
         *
         * By using Flyweight Pattern, we first get the shared "ConcreteFlyweight" from the "FlyweightFactory", and then
         * customize it to get the "UnsharedConcreteFlyweight" we desire.
         * In this way, the number of physically created objects is greatly reduced, and thus the load on memory is
         * reduced and the performance is improved.
         */

        // We were supposed to get 90000 green Circle objects, but here we just get 5 for better display.
        for (int i = 0; i < 5; ++i) {
            // First get the SharedCircle from the FlyweightShapeFactory
            SharedCircle sharedCircle = (SharedCircle) shapeFactory.getFlyweightShape("circle");

            // Customize this SharedCircle to get the UnsharedCircle we desire
            UnsharedCircle unsharedCircle = new UnsharedCircle(sharedCircle);
            unsharedCircle.setRadius(9.0);
            unsharedCircle.draw(Color.GREEN);
        }

        // We were supposed to get 90000 purple Circle objects, but here we just get 5 for better display.
        for (int i = 0; i < 5; ++i) {
            // First get the SharedCircle from the FlyweightShapeFactory
            SharedCircle sharedCircle = (SharedCircle) shapeFactory.getFlyweightShape("circle");

            // Customize this SharedCircle to get the UnsharedCircle we desire
            UnsharedCircle unsharedCircle = new UnsharedCircle(sharedCircle);
            unsharedCircle.setRadius(9.0);
            unsharedCircle.draw(Color.PURPLE);
        }

        // We were supposed to get 80000 orange Circle objects, but here we just get 4 for better display.
        for (int i = 0; i < 4; ++i) {
            // First get the SharedCircle from the FlyweightShapeFactory
            SharedCircle sharedCircle = (SharedCircle) shapeFactory.getFlyweightShape("circle");

            // Customize this SharedCircle to get the UnsharedCircle we desire
            UnsharedCircle unsharedCircle = new UnsharedCircle(sharedCircle);
            unsharedCircle.setRadius(8.0);
            unsharedCircle.draw(Color.ORANGE);
        }

        // We were supposed to get 70000 black Circle objects, but here we just get 4 for better display.
        for (int i = 0; i < 3; ++i) {
            // First get the SharedCircle from the FlyweightShapeFactory
            SharedCircle sharedCircle = (SharedCircle) shapeFactory.getFlyweightShape("circle");

            // Customize this SharedCircle to get the UnsharedCircle we desire
            UnsharedCircle unsharedCircle = new UnsharedCircle(sharedCircle);
            unsharedCircle.setRadius(7.0);
            unsharedCircle.draw(Color.BLACK);
        }

        System.out.println();

        // First get the SharedRectangle from the FlyweightShapeFactory
        SharedRectangle sharedRect = (SharedRectangle) shapeFactory.getFlyweightShape("rectangle");

        // Customize this SharedRectangle to get the UnsharedRectangle we desire
        UnsharedRectangle unsharedRect = new UnsharedRectangle(sharedRect);
        unsharedRect.setWidth(8.0);
        unsharedRect.setHeight(6.0);
        unsharedRect.draw(Color.RED);

        /*
         * Output:
         * Creating a Shared Circle without color: SharedCircle{x=0.0, y=0.0}
         * Circle has been drawn with GREEN: UnsharedCircle{x=0.0, y=0.0, radius=9.0, color=GREEN}
         * Circle has been drawn with GREEN: UnsharedCircle{x=0.0, y=0.0, radius=9.0, color=GREEN}
         * Circle has been drawn with GREEN: UnsharedCircle{x=0.0, y=0.0, radius=9.0, color=GREEN}
         * Circle has been drawn with GREEN: UnsharedCircle{x=0.0, y=0.0, radius=9.0, color=GREEN}
         * Circle has been drawn with GREEN: UnsharedCircle{x=0.0, y=0.0, radius=9.0, color=GREEN}
         * Circle has been drawn with PURPLE: UnsharedCircle{x=0.0, y=0.0, radius=9.0, color=PURPLE}
         * Circle has been drawn with PURPLE: UnsharedCircle{x=0.0, y=0.0, radius=9.0, color=PURPLE}
         * Circle has been drawn with PURPLE: UnsharedCircle{x=0.0, y=0.0, radius=9.0, color=PURPLE}
         * Circle has been drawn with PURPLE: UnsharedCircle{x=0.0, y=0.0, radius=9.0, color=PURPLE}
         * Circle has been drawn with PURPLE: UnsharedCircle{x=0.0, y=0.0, radius=9.0, color=PURPLE}
         * Circle has been drawn with ORANGE: UnsharedCircle{x=0.0, y=0.0, radius=8.0, color=ORANGE}
         * Circle has been drawn with ORANGE: UnsharedCircle{x=0.0, y=0.0, radius=8.0, color=ORANGE}
         * Circle has been drawn with ORANGE: UnsharedCircle{x=0.0, y=0.0, radius=8.0, color=ORANGE}
         * Circle has been drawn with ORANGE: UnsharedCircle{x=0.0, y=0.0, radius=8.0, color=ORANGE}
         * Circle has been drawn with BLACK: UnsharedCircle{x=0.0, y=0.0, radius=7.0, color=BLACK}
         * Circle has been drawn with BLACK: UnsharedCircle{x=0.0, y=0.0, radius=7.0, color=BLACK}
         * Circle has been drawn with BLACK: UnsharedCircle{x=0.0, y=0.0, radius=7.0, color=BLACK}
         *
         * Creating a Shared Rectangle without color: SharedRectangle{leftBottomX=0.0, leftBottomY=0.0}
         * Rectangle has been draw with RED: UnsharedRectangle{leftBottomX=0.0, leftBottomY=0.0, width=8.0, height=6.0, color=RED}
         */
    }

}
