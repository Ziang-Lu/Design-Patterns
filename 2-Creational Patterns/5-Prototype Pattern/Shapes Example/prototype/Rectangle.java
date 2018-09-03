package prototype;

/**
 * Concrete Rectangle class.
 *
 * @author Ziang Lu
 */
public class Rectangle extends Shape {

    /**
     * Default constructor.
     */
    public Rectangle() {
        super("Rectangle");
    }

    @Override
    public void draw() {
        System.out.println("In Rectangle.draw() method");
    }

    @Override
    public Rectangle clone() throws CloneNotSupportedException {
        return (Rectangle) super.clone();
    }

}
