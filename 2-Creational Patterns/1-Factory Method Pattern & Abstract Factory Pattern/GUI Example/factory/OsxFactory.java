package factory;

import product_button.MyButton;
import product_button.OsxButton;

/**
 * Concrete factory OsxFactory class.
 * This class is implemented as a singleton class.
 *
 * @author Ziang Lu
 */
public class OsxFactory implements GuiFactory {

    /**
     * Singleton instance.
     */
    private volatile static OsxFactory instance = null;

    /**
     * Gets the singleton instance.
     * This implementation utilizes Lazy Initialization Pattern and double-check
     * locking mechanism.
     * @return singleton instance
     */
    public static OsxFactory getInstance() {
        if (instance == null) {
            synchronized (OsxFactory.class) {
                if (instance == null) {
                    instance = new OsxFactory();
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
    private OsxFactory() {}

    /**
     * Concrete factory method to make a concrete product OsxButton instance.
     * @return instantiated MyButton
     */
    @Override
    public MyButton createButton() {
        return new OsxButton();
    }

}
