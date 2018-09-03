package product_button;

/**
 * Concrete product OsxButton class.
 *
 * @author Ziang Lu
 */
public class OsxButton implements MyButton {

    @Override
    public void paint() {
        System.out.println("This is a MacOSX button.");
    }

}
