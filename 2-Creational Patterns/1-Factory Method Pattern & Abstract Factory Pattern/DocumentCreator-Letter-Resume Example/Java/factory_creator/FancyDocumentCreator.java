package factory_creator;

import product_document.FancyLetter;
import product_document.FancyResume;
import product_document.Letter;
import product_document.Resume;

/**
 * Concrete factory FancyDocumentCreator class.
 * This class is implemented as a singleton class.
 *
 * @author Ziang Lu
 */
public class FancyDocumentCreator implements DocumentCreator {

    /**
     * Singleton instance.
     */
    private volatile static FancyDocumentCreator instance = null;

    /**
     * Gets the singleton instance.
     * This implementation utilizes Lazy Initialization Pattern and double-check
     * locking mechanism.
     * @return singleton instance
     */
    public static FancyDocumentCreator getInstance() {
        if (instance == null) {
            synchronized (FancyDocumentCreator.class) {
                if (instance == null) {
                    instance = new FancyDocumentCreator();
                }
            }
        }
        return instance;
    }

    /**
     * Private default constructor.
     * This has to be private so that the class instances cannot be created
     * outside of the class.
     */
    private FancyDocumentCreator() {}

    /**
     * Concrete factory method to make a concrete product FancyLetter instance.
     * @return instantiated Letter
     */
    @Override
    public Letter createLetter() {
        return new FancyLetter();
    }

    /**
     * Concrete factory method to make a concrete product FancyResume instance.
     * @return instantiated Resume
     */
    @Override
    public Resume createResume() {
        return new FancyResume();
    }

}
