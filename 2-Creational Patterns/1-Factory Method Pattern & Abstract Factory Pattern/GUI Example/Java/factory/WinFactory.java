package factory;

import product_button.MyButton;
import product_button.WinButton;

/**
 * Concrete factory WinFactory class.
 * This class is implemented as a singleton class.
 *
 * @author Ziang Lu
 */
public class WinFactory implements GuiFactory {

    /**
     * Singleton instance.
     */
    private volatile static WinFactory instance = null;

    /**
     * Gets the singleton instance.
     * This implementation utilizes Lazy Initialization Pattern and double-check
     * locking mechanism.
     * @return singleton instance
     */
    public static WinFactory getInstance() {
        if (instance == null) {
            synchronized (WinFactory.class) {
                if (instance == null) {
                    instance = new WinFactory();
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
    private WinFactory() {}

    /**
     * Concrete factory method to make a concrete product WinButton instance.
     * @return instantiated MyButton
     */
    @Override
    public MyButton createButton() {
        return new WinButton();
    }

}
