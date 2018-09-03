package factory_creator;

import product_document.Letter;
import product_document.ModernLetter;
import product_document.ModernResume;
import product_document.Resume;

/**
 * Concrete factory ModernDocumentCreator class.
 * This class is implemented as a singleton class.
 *
 * @author Ziang Lu
 */
public class ModernDocumentCreator implements DocumentCreator {

    /**
     * Singleton instance.
     */
    private volatile static ModernDocumentCreator instance = null;

    public static ModernDocumentCreator getInstance() {
        if (instance == null) {
            synchronized (ModernDocumentCreator.class) {
                if (instance == null) {
                    instance = new ModernDocumentCreator();
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
    private ModernDocumentCreator() {}

    /**
     * Concrete factory method to make a concrete product ModernLetter instance.
     * @return instantiated Letter
     */
    @Override
    public Letter createLetter() {
        return new ModernLetter();
    }

    /**
     * Concrete factory method to make a concrete product ModernResume instance.
     * @return instantiated Letter
     */
    @Override
    public Resume createResume() {
        return new ModernResume();
    }

}
