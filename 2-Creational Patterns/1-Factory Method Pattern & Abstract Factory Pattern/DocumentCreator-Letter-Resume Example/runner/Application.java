package runner;

import factory_creator.DocumentCreator;
import factory_creator.FancyDocumentCreator;
import factory_creator.ModernDocumentCreator;
import product_document.Letter;
import product_document.Resume;

/**
 * Main application that actually uses the concrete factories and abstract
 * products.
 *
 * @author Ziang Lu
 */
public class Application {

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        // Get instances from a fancy creator
        DocumentCreator fancyCreator = FancyDocumentCreator.getInstance();
        // Note that the creator itself is still an abstract factory DocumentCreator

        // Let the factory to produce abstract products through the factory methods
        Letter letter = fancyCreator.createLetter();
        System.out.println(letter);
        Resume resume = fancyCreator.createResume();
        System.out.println(resume);

        // Get instances from a modern creator
        DocumentCreator modernCreator = ModernDocumentCreator.getInstance();
        // Note that the creator itself is still an abstract factory DocumentCreator

        // Let the factory to produce abstract products through the factory methods
        letter = modernCreator.createLetter();
        System.out.println(letter);
        resume = modernCreator.createResume();
        System.out.println(resume);

        /*
         * Output:
         * This is a FANCY LETTER.
         * This is a FANCY RESUME.
         * This is a MODERN LETTER.
         * This is a MODERN RESUME.
         */
    }

}
