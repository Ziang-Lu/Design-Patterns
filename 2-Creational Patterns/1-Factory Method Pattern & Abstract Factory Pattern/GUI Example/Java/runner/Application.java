package runner;

import factory.GuiFactory;
import factory.OsxFactory;
import factory.WinFactory;

/**
 * Application that actually uses the concrete factories.
 *
 * @author Ziang Lu
 */
public class Application {

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        GuiFactory osxFactory = OsxFactory.getInstance();
        Renderer osxRenderer = new Renderer(osxFactory);
        osxRenderer.render();

        GuiFactory winFactory = WinFactory.getInstance();
        Renderer winRenderer = new Renderer(winFactory);
        winRenderer.render();

        /*
         * Output:
         * This is a MacOSX button.
         * This is a Windows button.
         */
    }

}
