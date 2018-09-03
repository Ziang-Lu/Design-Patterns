package prototype;

/**
 * Concrete Circle class.
 *
 * @author Ziang Lu
 */
public class Circle extends Shape {

    /**
     * Default constructor.
     */
    public Circle() {
        super("Circle");
    }

    @Override
    public void draw() {
        System.out.println("In Circle.draw() method");
    }

    @Override
    public Circle clone() throws CloneNotSupportedException {
        return (Circle) super.clone();
    }

}
