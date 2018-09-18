package runner;

import model.Circle;
import model.GraphicComposite;
import model.Rectangle;

/**
 * Application that actually uses Composite Pattern.
 *
 * @author Ziang Lu
 */
public class Application {

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        GraphicComposite composite1 = new GraphicComposite("Composite-1");
        composite1.addGraphic(new Rectangle("Rectangle-1"));
        composite1.addGraphic(new Rectangle("Rectangle-2"));
        composite1.addGraphic(new Circle("Circle-1"));

        GraphicComposite composite2 = new GraphicComposite("Composite-2");
        composite2.addGraphic(new Rectangle("Rectangle-3"));
        composite2.addGraphic(new Circle("Circle-2"));

        GraphicComposite composite = new GraphicComposite("Overall Composite");
        composite.addGraphic(composite1);
        composite.addGraphic(composite2);

        composite.draw();
        System.out.println();
        composite1.translate(10, 5);
        System.out.println();
        composite2.resize(1.4);

        /*
         * Output:
         * Drawing Overall Composite as follows:
         * Drawing Composite-1 as follows:
         * Drawing Rectangle-1
         * Drawing Rectangle-2
         * Drawing Circle-1
         * Drawing Composite-2 as follows:
         * Drawing Rectangle-3
         * Drawing Circle-2
         *
         * Translating Composite-1 as follows:
         * Translating Rectangle-1 by x=10, y=5
         * Translating Rectangle-2 by x=10, y=5
         * Translating Circle-1 by x=10, y=5
         *
         * Resizing Composite-2 as follows:
         * Resizing Rectangle-3 by 1.4 times
         * Resizing Circle-2 by 1.4 times
         */
    }

}
