package runner;

import factory.GuiFactory;
import product_button.MyButton;

/**
 * Renderer class for a specific operating system.
 * Note that a renderer knows nothing about which concrete type of GuiFactory to
 * use, and thus which concrete type of Button product to create.
 *
 * @author Ziang Lu
 */
public class Renderer {

    /**
     * Abstract GUI Factory used by this renderer.
     */
    private GuiFactory guiFactory;

    /**
     * Constructor with parameter.
     * @param guiFactory GUI factory used by the renderer
     */
    public Renderer(GuiFactory guiFactory) {
        this.guiFactory = guiFactory;
    }

    /**
     * Renders the application by creating an abstract button from the abstract
     * factory and painting the button.
     */
    public void render() {
        MyButton button = guiFactory.createButton();
        button.paint();
    }

}
