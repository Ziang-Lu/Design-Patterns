package factory;

import product_button.MyButton;

/**
 * Abstract factory GuiFactory interface.
 *
 * @author Ziang Lu
 */
public interface GuiFactory {

    /**
     * Abstract factory method to make an abstract product MyButton instance.
     * However, the ability to determine which concrete type of MyButton product
     * to instantiate is deferred to concrete factories (subclasses).
     * @return instantiated MyButton
     */
    MyButton createButton();

}
