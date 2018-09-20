package factory_creator;

import product_document.Letter;
import product_document.Resume;

/**
 * Abstract factory DocumentCreator interface.
 *
 * @author Ziang Lu
 */
public interface DocumentCreator {

    /**
     * Abstract factory method to make an abstract product Letter instance.
     * However, the ability to determine which concrete type of Letter product
     * to instantiate is deferred to concrete factories (subclasses).
     * @return instantiated Letter
     */
    Letter createLetter();

    /**
     * Abstract factory method to make an abstract product Resume instance.
     * However, the ability to determine which concrete type of Resume product
     * to instantiate is deferred to concrete factories (subclasses).
     * @return instantiated Resume
     */
    Resume createResume();

}
