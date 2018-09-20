package product_button;

/**
 * Concrete product WinButton class.
 *
 * @author Ziang Lu
 */
public class WinButton implements MyButton {

    @Override
    public void paint() {
        System.out.println("This is a Windows button.");
    }

}
