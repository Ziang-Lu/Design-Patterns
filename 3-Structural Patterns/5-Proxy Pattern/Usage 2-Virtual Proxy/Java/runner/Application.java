package runner;

import image.Image;
import image.ImageProxy;

/**
 * Application that actually uses Proxy Pattern.
 *
 * @author Ziang Lu
 */
public class Application {

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        Image image = new ImageProxy("10MB_photo.jpg");

        System.out.println("First time calling displayImage() method:");
        image.displayImage();

        /*
         * Output:
         * First time calling displayImage() method:
         * Creating a RealImage object: Loading 10MB_photo.jpg from disk... This may take around 3 seconds.
         * Displaying 10MB_photo.jpg
         */

        System.out.println();

        System.out.println("Second time calling displayImage() method:");
        image.displayImage();

        /*
         * Output:
         * Second time calling displayImage() method:
         * Displaying 10MB_photo.jpg
         */
    }

}
